package cberg.aoc2020

import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {
    private val exampleInput = listOf(
        1721,
        979,
        366,
        299,
        675,
        1456
    )

    private val realInput = Input("01").intLines()

    @Test
    fun part1_Example() {
        val result = Day01(exampleInput).part1()
        assertEquals(514579, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day01(realInput).part1()
        assertEquals(1010884, result)
    }

    @Test
    fun part2_Example() {
        val result = Day01(exampleInput).part2()
        assertEquals(241861950, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day01(realInput).part2()
        assertEquals(253928438, result)
    }
}