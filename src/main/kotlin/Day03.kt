package cberg.aoc2020

class Day03(private val input: List<String>) {
    constructor() : this(Input("03.txt").lines())

    fun part1() = treesOfSlope(3, 1)

    fun part2(): Int {
        val slopes = listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
        return slopes.fold(1) { acc, (dx, dy) ->
            acc * treesOfSlope(dx, dy)
        }
    }

    private fun treesOfSlope(dx: Int, dy: Int): Int {
        var x = 0
        var y = 0
        var trees = 0

        while (y <= input.lastIndex) {
            if (input[y][x] == '#') {
                trees++
            }
            y += dy
            x = (x + dx) % input.first().length
        }
        return trees
    }
}
