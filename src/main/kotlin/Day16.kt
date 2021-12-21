package cberg.aoc2020

class Day16(input: List<String>) {

    private val rules: List<Rule>
    private val myTicket: List<Int>
    private val nearbyTickets: List<List<Int>>

    init {
        val blocks = input.split { line -> line.isBlank() }
        rules = blocks[0].map { parseRule(it) }
        myTicket = parseTicket(blocks[1][1])
        nearbyTickets = blocks[2].drop(1).map { line -> parseTicket(line) }
    }

    fun part1() = nearbyTickets.sumOf { ticket ->
        ticket.filter { value ->
            rules.none { rule ->
                rule.ranges.any { range -> value in range }
            }
        }.sum()
    }

    fun part2() = getFieldPositions()
        .filterKeys { it.startsWith("departure") }
        .values.fold(1L) { a, b -> a * myTicket[b] }

    fun getFieldPositions(): Map<String, Int> {
        val validTickets = nearbyTickets.filter { ticket ->
            ticket.all { value -> rules.any { rule -> rule.ranges.any { range -> value in range } } }
        }
        val possibleFieldPositions = rules.associate { rule ->
            val candidates = myTicket.indices.filter { fieldIndex ->
                validTickets.all { ticket ->
                    rule.ranges.any { range -> ticket[fieldIndex] in range }
                }
            }
            rule.field to candidates.toMutableSet()
        }.toMutableMap()

        val fieldPositions = mutableMapOf<String, Int>()
        while (possibleFieldPositions.isNotEmpty()) {
            possibleFieldPositions
                .filterValues { it.size == 1 }
                .forEach { (field, candidates) ->
                    val fieldIndex = candidates.single()
                    fieldPositions[field] = fieldIndex
                    possibleFieldPositions.remove(field)
                    possibleFieldPositions.values.forEach { it.remove(fieldIndex) }
                }
        }
        return fieldPositions
    }

    data class Rule(val field: String, val ranges: List<IntRange>)

    private fun parseRule(s: String): Rule {
        val (field, ranges) = s.split(": ")
        return Rule(
            field,
            ranges.split(" or ")
                .map { range ->
                    range.split("-").let { (from, to) -> from.toInt()..to.toInt() }
                }
        )
    }

    private fun parseTicket(line: String) = line.split(",").map { it.toInt() }
}
