package cberg.aoc2020

import kotlin.test.Test
import kotlin.test.assertEquals

class Day08Test {
    private val exampleInput = listOf(
        "nop +0",
        "acc +1",
        "jmp +4",
        "acc +3",
        "jmp -3",
        "acc -99",
        "acc +1",
        "jmp -4",
        "acc +6"
    )

    private val realInput = Input("08").lines()

    @Test
    fun part1_Example() {
        val result = Day08(exampleInput).part1()
        assertEquals(5, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day08(realInput).part1()
        assertEquals(1594, result)
    }

    @Test
    fun part2_Example() {
        val result = Day08(exampleInput).part2()
        assertEquals(8, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day08(realInput).part2()
        assertEquals(758, result)
    }
}