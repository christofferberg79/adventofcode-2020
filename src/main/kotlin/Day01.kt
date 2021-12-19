package cberg.aoc2020

class Day01(private val input: List<Int>) {
    fun part1(): Int {
        for (i in 0..input.lastIndex - 1) {
            for (j in (i + 1)..input.lastIndex) {
                if (input[i] + input[j] == 2020) {
                    return input[i] * input[j]
                }
            }
        }
        error("No solution found")
    }

    fun part2(): Int {
        for (i in 0..(input.lastIndex - 2)) {
            for (j in (i + 1)..input.lastIndex - 1) {
                for (k in (j + 1)..input.lastIndex) {
                    if (input[i] + input[j] + input[k] == 2020) {
                        return input[i] * input[j] * input[k]
                    }
                }
            }
        }
        error("No solution found")
    }
}
