package cberg.aoc2020

class Day06(private val input: List<String>) {
    fun part1() = solve(Set<Char>::union)

    fun part2() = solve(Set<Char>::intersect)

    private fun solve(operation: (Set<Char>, Set<Char>) -> Set<Char>) = input.split { it.isBlank() }
        .map { lines ->
            lines.map { line -> line.toSet() }.reduce { acc, line -> operation(acc, line) }
        }
        .sumOf { it.size }
}
