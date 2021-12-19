package cberg.aoc2020

import kotlin.test.Test
import kotlin.test.assertEquals

class Day12Test {
    private val exampleInput = listOf(
        "F10",
        "N3",
        "F7",
        "R90",
        "F11"
    )

    private val realInput = Input("12").lines()

    @Test
    fun part1_Example() {
        val result = Day12(exampleInput).part1()
        assertEquals(25, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day12(realInput).part1()
        assertEquals(521, result)
    }

    @Test
    fun part2_Example() {
        val result = Day12(exampleInput).part2()
        assertEquals(286, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day12(realInput).part2()
        assertEquals(22848, result)
    }
}