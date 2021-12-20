package cberg.aoc2020

class Day15(private val input: String) {
    fun part1() = solve(2020)

    fun part2() = solve(30000000)

    private fun solve(n: Int): Int {
        val startNumbers = input.split(",").map { it.toInt() }
        val data = startNumbers.dropLast(1).mapIndexed { i, c -> c to i + 1 }.toMap().toMutableMap()
        var last = startNumbers.last()
        var turn = startNumbers.size
        while (turn < n) {
            val turnOfLast = data[last]
            data[last] = turn
            last = if (turnOfLast == null) 0 else turn - turnOfLast
            turn++
        }
        return last
    }
}
