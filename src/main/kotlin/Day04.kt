package cberg.aoc2020

class Day04(private val input: List<String>) {
    constructor() : this(Input("04.txt").lines())

    fun part1() = parseInput()
        .count { it.hasAllRequiredFields() }

    fun part2() = parseInput()
        .count { it.isValid() }

    private fun parseInput() = input.split { line -> line.isBlank() }
        .map { lines -> lines.joinToString(" ") }
        .map { line ->
            line.split(" ")
                .map { entry -> entry.split(":") }
                .associate { (field, value) -> field to value }
        }

    private fun Map<String, String>.hasAllRequiredFields() =
        keys.containsAll(setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"))

    private fun Map<String, String>.isValid() =
        get("byr")?.toIntOrNull() in 1920..2002 &&
                get("iyr")?.toIntOrNull() in 2010..2020 &&
                get("eyr")?.toIntOrNull() in 2020..2030 &&
                get("hgt")?.let {
                    when (it.takeLast(2)) {
                        "cm" -> it.dropLast(2).toIntOrNull() in 150..193
                        "in" -> it.dropLast(2).toIntOrNull() in 59..76
                        else -> false
                    }
                } ?: false &&
                get("hcl")?.matches(Regex("#[0-9a-f]{6}")) ?: false &&
                get("ecl")?.matches(Regex("amb|blu|brn|gry|grn|hzl|oth")) ?: false &&
                get("pid")?.matches(Regex("\\d{9}")) ?: false
}
