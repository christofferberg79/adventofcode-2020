package cberg.aoc2020

import kotlin.test.Test
import kotlin.test.assertEquals

class Day16Test {
    private val exampleInput = listOf(
        "class: 1-3 or 5-7",
        "row: 6-11 or 33-44",
        "seat: 13-40 or 45-50",
        "",
        "your ticket:",
        "7,1,14",
        "",
        "nearby tickets:",
        "7,3,47",
        "40,4,50",
        "55,2,20",
        "38,6,12"
    )

    private val realInput = Input("16").lines()

    @Test
    fun part1_Example() {
        val result = Day16(exampleInput).part1()
        assertEquals(71, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day16(realInput).part1()
        assertEquals(23122, result)
    }

    @Test
    fun part2_Example() {
        val result = Day16(exampleInput).getFieldPositions()
        assertEquals(mapOf("row" to 0, "class" to 1, "seat" to 2), result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day16(realInput).part2()
        assertEquals(362974212989, result)
    }
}