package cberg.aoc2020

class Day05(private val input: List<String>) {
    constructor() : this(Input("05.txt").lines())

    fun part1() = input.maxOf { line -> getId(line) }

    private fun getId(line: String) = line.map { if (it in "FL") 0 else 1 }
        .joinToString("")
        .toInt(2)

    fun part2(): Int {
        val ids = input.map { line -> getId(line) }.sorted()
        for (i in 0 until ids.lastIndex) {
            if (ids[i + 1] != ids[i] + 1) {
                return ids[i] + 1
            }
        }
        error("No solution found")
    }
}
