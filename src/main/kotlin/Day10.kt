package cberg.aoc2020

class Day10(input: List<Int>) {
    private val max = input.maxOrNull()!!
    private val adapters = (input + 0 + (max + 3)).toSet()
    private val numArrangements = mutableMapOf(max to 1L)

    fun part1() = adapters.sorted().zipWithNext { a, b -> b - a }
        .let { diffs -> diffs.count { it == 1 } * diffs.count { it == 3 } }

    fun part2() = getArrangementsFrom(0)

    private fun getArrangementsFrom(n: Int): Long = numArrangements.getOrPut(n) {
        (n + 1..n + 3).filter { it in adapters }.sumOf { getArrangementsFrom(it) }
    }
}
