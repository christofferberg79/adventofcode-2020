package cberg.aoc2020

import kotlin.test.Test
import kotlin.test.assertEquals

class Day17Test {
    private val exampleInput = listOf(
        ".#.",
        "..#",
        "###"
    )

    private val realInput = Input("17").lines()

    @Test
    fun part1_Example() {
        val result = Day17(exampleInput).part1()
        assertEquals(112, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day17(realInput).part1()
        assertEquals(232, result)
    }

    @Test
    fun part2_Example() {
        val result = Day17(exampleInput).part2()
        assertEquals(848, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day17(realInput).part2()
        assertEquals(1620, result)
    }
}