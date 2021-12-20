package cberg.aoc2020

import kotlin.test.Test
import kotlin.test.assertEquals

class Day15Test {
    private val exampleInput = "0,3,6"

    private val realInput = Input("15").oneLine()

    @Test
    fun part1_Example() {
        val result = Day15(exampleInput).part1()
        assertEquals(436, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day15(realInput).part1()
        assertEquals(536, result)
    }

    @Test
    fun part2_Example() {
        val result = Day15(exampleInput).part2()
        assertEquals(175594, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day15(realInput).part2()
        assertEquals(24065124, result)
    }
}