package cberg.aoc2020

import kotlin.test.Test
import kotlin.test.assertEquals

class Day10Test {
    private val exampleInput = listOf(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4)

    private val realInput = Input("10").intLines()

    @Test
    fun part1_Example() {
        val result = Day10(exampleInput).part1()
        assertEquals(35, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day10(realInput).part1()
        assertEquals(2812, result)
    }

    @Test
    fun part2_Example() {
        val result = Day10(exampleInput).part2()
        assertEquals(8, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day10(realInput).part2()
        assertEquals(386869246296064, result)
    }
}