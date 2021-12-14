package cberg.aoc2020

import kotlin.test.Test
import kotlin.test.assertEquals

class Day06Test {
    private val exampleInput = listOf(
        "abc",
        "",
        "a",
        "b",
        "c",
        "",
        "ab",
        "ac",
        "",
        "a",
        "a",
        "a",
        "a",
        "",
        "b"
    )

    @Test
    fun part1_Example() {
        val result = Day06(exampleInput).part1()
        assertEquals(11, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day06().part1()
        assertEquals(6782, result)
    }

    @Test
    fun part2_Example() {
        val result = Day06(exampleInput).part2()
        assertEquals(6, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day06().part2()
        assertEquals(3596, result)
    }
}