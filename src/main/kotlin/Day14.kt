package cberg.aoc2020

class Day14(private val input: List<String>) {
    fun part1() = runProgram { memory, mask, addr, value ->
        val binary = value.toString(2).padStart(36, '0')
        val masked = binary.mapIndexed { i, c -> if (mask[i] == 'X') c else mask[i] }.joinToString("")
        memory[addr] = masked.toLong(2)
    }

    fun part2() = runProgram { memory, mask, addr, value ->
        val binary = addr.toString(2).padStart(36, '0')
        val masked = binary.mapIndexed { i, c -> if (mask[i] == '0') c else mask[i] }.joinToString("")

        for (a in unfloat(masked)) {
            memory[a.toLong(2)] = value
        }
    }

    private fun unfloat(s: String): List<String> = when (val i = s.indexOf('X')) {
        -1 -> listOf(s)
        else -> unfloat(s.replaceRange(i, i + 1, "0")) +
                unfloat(s.replaceRange(i, i + 1, "1"))
    }

    private fun runProgram(decoder: (MutableMap<Long, Long>, String, Long, Long) -> Unit): Long {
        val memory = mutableMapOf<Long, Long>()
        var mask = ""
        for (line in input) {
            if (line.startsWith("mask")) {
                mask = line.substringAfter("mask = ")
            } else {
                val (addr, value) = Regex("mem\\[(.*)] = (.*)").matchEntire(line)
                    ?.destructured?.let { (s1, s2) -> s1.toLong() to s2.toLong() }
                    ?: error("Invalid input: $line")
                decoder(memory, mask, addr, value)
            }
        }
        return memory.values.sum()
    }

}
