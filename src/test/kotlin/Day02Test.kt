package cberg.aoc2020

import kotlin.test.Test
import kotlin.test.assertEquals

class Day02Test {
    private val exampleInput = listOf(
        "1-3 a: abcde",
        "1-3 b: cdefg",
        "2-9 c: ccccccccc"
    )

    @Test
    fun part1_Example() {
        val result = Day02(exampleInput).part1()
        assertEquals(2, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day02().part1()
        assertEquals(439, result)
    }

    @Test
    fun part2_Example() {
        val result = Day02(exampleInput).part2()
        assertEquals(1, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day02().part2()
        assertEquals(584, result)
    }
}