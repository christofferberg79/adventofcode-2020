package cberg.aoc2020

class Day11(private val input: List<String>) {
    private val xRange = input.indices
    private val yRange = input.first().indices

    fun part1() = solve(::rule1)

    fun part2() = solve(::rule2)

    private fun solve(rule: (Pos, Char, List<String>) -> Char): Int {
        var state = input

        while (true) {
            val newState = state.mapIndexed { x, line ->
                line.mapIndexed { y, c -> rule(Pos(x, y), c, state) }
                    .joinToString("")
            }

            if (newState == state) {
                break
            }
            state = newState
        }

        return state.sumOf { line -> line.count { c -> c == '#' } }
    }

    private fun rule1(pos: Pos, c: Char, state: List<String>): Char {
        val adjacentOccupied = pos.adjacent().count { (x, y) -> state[x][y] == '#' }
        return when {
            c == '#' && adjacentOccupied >= 4 -> 'L'
            c == 'L' && adjacentOccupied == 0 -> '#'
            else -> c
        }
    }

    private fun rule2(pos: Pos, c: Char, state: List<String>): Char {
        val seenOccupied = pos.seenSeats(state).count { (x, y) -> state[x][y] == '#' }
        return when {
            c == '#' && seenOccupied >= 5 -> 'L'
            c == 'L' && seenOccupied == 0 -> '#'
            else -> c
        }
    }

    data class Pos(val x: Int, val y: Int)

    private operator fun Pos.plus(other: Pos) = Pos(x + other.x, y + other.y)

    private val directions = listOf(
        Pos(-1, -1), Pos(0, -1), Pos(1, -1),
        Pos(-1, 0), Pos(1, 0),
        Pos(-1, 1), Pos(0, 1), Pos(1, 1)
    )

    private fun Pos.adjacent() = directions.map { this + it }
        .filter { (x, y) -> x in xRange && y in yRange }

    private fun Pos.seenSeats(state: List<String>) = directions.mapNotNull { dir ->
        generateSequence(this + dir) { prev -> prev + dir }
            .takeWhile { p -> p.x in xRange && p.y in yRange }
            .firstOrNull { p -> state[p.x][p.y] != '.' }
    }
}
