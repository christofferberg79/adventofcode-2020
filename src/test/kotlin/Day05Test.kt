package cberg.aoc2020

import kotlin.test.Test
import kotlin.test.assertEquals

class Day05Test {
    private val realInput = Input("05").lines()

    @Test
    fun part1_RealInput() {
        val result = Day05(realInput).part1()
        assertEquals(864, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day05(realInput).part2()
        assertEquals(739, result)
    }
}