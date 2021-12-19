package cberg.aoc2020

class Day07(input: List<String>) {
    private val rules = parse(input)

    fun part1() = rules.keys.count { bag -> bag.eventuallyContains("shiny gold") }

    fun part2() = numberOfBagsIn("shiny gold")

    private fun parse(input: List<String>) = input.associate { line ->
        val parts = line.split("contain", ",").map { it.trim() }
        val containingBag = parts[0].substringBefore(" bag")
        val containedBags = parts.drop(1)
            .filter { part -> part.first().isDigit() }
            .associate { part ->
                val bag = part.substringAfter(" ").substringBefore(" bag")
                val num = part.substringBefore(" ").toInt()
                bag to num
            }

        containingBag to containedBags
    }

    private fun String.eventuallyContains(otherBag: String): Boolean {
        val containedBags = rules[this] ?: return false
        return containedBags.keys.any { bag -> bag == otherBag || bag.eventuallyContains(otherBag) }
    }

    private fun numberOfBagsIn(bag: String): Int {
        val containedBags = rules[bag] ?: return 0
        return containedBags.entries.sumOf { (bag, num) -> num + num * numberOfBagsIn(bag) }
    }
}
