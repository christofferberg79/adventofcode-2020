package cberg.aoc2020

import kotlin.test.Test
import kotlin.test.assertEquals

class Day09Test {
    private val exampleInput = listOf<Long>(
        35,
        20,
        15,
        25,
        47,
        40,
        62,
        55,
        65,
        95,
        102,
        117,
        150,
        182,
        127,
        219,
        299,
        277,
        309,
        576
    )

    @Test
    fun part1_Example() {
        val result = Day09(exampleInput, 5).part1()
        assertEquals(127, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day09(25).part1()
        assertEquals(14144619, result)
    }

    @Test
    fun part2_Example() {
        val result = Day09(exampleInput, 5).part2()
        assertEquals(62, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day09(25).part2()
        assertEquals(1766397, result)
    }
}