package cberg.aoc2020

import kotlin.test.Test
import kotlin.test.assertEquals

class Day11Test {
    private val exampleInput = listOf(
        "L.LL.LL.LL",
        "LLLLLLL.LL",
        "L.L.L..L..",
        "LLLL.LL.LL",
        "L.LL.LL.LL",
        "L.LLLLL.LL",
        "..L.L.....",
        "LLLLLLLLLL",
        "L.LLLLLL.L",
        "L.LLLLL.LL"
    )

    @Test
    fun part1_Example() {
        val result = Day11(exampleInput).part1()
        assertEquals(37, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day11().part1()
        assertEquals(2354, result)
    }

    @Test
    fun part2_Example() {
        val result = Day11(exampleInput).part2()
        assertEquals(26, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day11().part2()
        assertEquals(2072, result)
    }
}