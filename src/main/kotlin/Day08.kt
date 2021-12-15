package cberg.aoc2020

class Day08(input: List<String>) {
    constructor() : this(Input("08.txt").lines())

    private val instructions = input.map { line -> parse(line) }

    fun part1(): Int {
        val (exitCode, acc) = execute(instructions)
        check(exitCode == -1)
        return acc
    }

    fun part2(): Int {
        val swaps = instructions.indices.filter { i -> instructions[i].first != "acc" }
        for (swap in swaps) {
            val (exitCode, acc) = execute(instructions.swap(swap))
            if (exitCode == 0) {
                return acc
            }
        }
        error("No solution found")
    }

    private fun execute(instructions: List<Pair<String, Int>>): Pair<Int, Int> {
        var i = 0
        var acc = 0
        val visited = mutableSetOf<Int>()
        while (i < instructions.size && visited.add(i)) {
            val (op, arg) = instructions[i]
            when (op) {
                "acc" -> {
                    acc += arg
                    i++
                }
                "jmp" -> i += arg
                "nop" -> i++
                else -> error("invalid operation: $op")
            }
        }
        val exitCode = if (i < instructions.size) -1 else 0
        return exitCode to acc
    }

    private fun parse(line: String) = line.split(" ").let { (a, b) -> a to b.toInt() }

    private fun List<Pair<String, Int>>.swap(swap: Int) = mapIndexed { i, (op, arg) ->
        when {
            i != swap -> op to arg
            op == "nop" -> "jmp" to arg
            op == "jmp" -> "nop" to arg
            else -> error("should not swap here")
        }
    }
}
