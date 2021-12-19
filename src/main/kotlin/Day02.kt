package cberg.aoc2020

class Day02(private val input: List<String>) {
    fun part1() = input.map(::parse).count { d ->
        d.run { s.count { it == c } in i1..i2 }
    }

    fun part2() = input.map(::parse).count { d ->
        d.run { (s[i1 - 1] == c) xor (s[i2 - 1] == c) }
    }

    private class Data(val i1: Int, val i2: Int, val c: Char, val s: String)

    private fun parse(line: String) = line.split(Regex("[- :]+"))
        .let { Data(it[0].toInt(), it[1].toInt(), it[2].single(), it[3]) }
}
