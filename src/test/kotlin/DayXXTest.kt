package cberg.aoc2020

import kotlin.test.Test
import kotlin.test.assertEquals

class DayXXTest {
    private val exampleInput = listOf(
        ""
    )

    private val realInput = Input("XX").lines()

    @Test
    fun part1_Example() {
        val result = DayXX(exampleInput).part1()
        assertEquals(0, result)
    }

    @Test
    fun part1_RealInput() {
        val result = DayXX(realInput).part1()
        assertEquals(0, result)
    }

    @Test
    fun part2_Example() {
        val result = DayXX(exampleInput).part2()
        assertEquals(0, result)
    }

    @Test
    fun part2_RealInput() {
        val result = DayXX(realInput).part2()
        assertEquals(0, result)
    }
}