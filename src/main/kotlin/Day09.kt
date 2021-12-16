package cberg.aoc2020

class Day09(private val input: List<Long>, private val n: Int) {
    constructor(n: Int) : this(Input("09.txt").longLines(), n)

    fun part1(): Long {
        for (i in n..input.lastIndex) {
            if (!isValid(i)) {
                return input[i]
            }
        }
        error("No solution found")
    }

    fun part2(): Long {
        val target = part1()

        for (m in 2..input.size) {
            val startSum = input.take(m).sum()
            generateSequence(0 to startSum) { (i, sum) -> i + 1 to sum - input[i] + input[i + m] }
                .take(input.size - m + 1)
                .firstOrNull { (_, sum) -> sum == target }?.let { (i, _) ->
                    val sublist = input.subList(i, i + m)
                    return sublist.minOf { it } + sublist.maxOf { it }
                }
        }

        error("No solution found")
    }

    private fun isValid(i: Int): Boolean {
        for (j in i - n until i - 1) {
            for (k in j + 1 until i) {
                if (input[i] == input[j] + input[k]) {
                    return true
                }
            }
        }
        return false
    }
}
