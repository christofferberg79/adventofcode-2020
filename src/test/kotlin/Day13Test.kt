package cberg.aoc2020

import kotlin.test.Test
import kotlin.test.assertEquals

class Day13Test {
    private val exampleInput = listOf(
        "939",
        "7,13,x,x,59,x,31,19"
    )

    @Test
    fun part1_Example() {
        val result = Day13(exampleInput).part1()
        assertEquals(295, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day13().part1()
        assertEquals(4808, result)
    }

    @Test
    fun part2_Example() {
        val result = Day13(exampleInput).part2()
        assertEquals(1068781, result)
    }

    @Test
    fun part2_MoreExamples() {
        assertEquals(3417, Day13(listOf("17,x,13,19")).part2())
        assertEquals(754018, Day13(listOf("67,7,59,61")).part2())
        assertEquals(779210, Day13(listOf("67,x,7,59,61")).part2())
        assertEquals(1261476, Day13(listOf("67,7,x,59,61")).part2())
        assertEquals(1202161486, Day13(listOf("1789,37,47,1889")).part2())
    }

    @Test
    fun part2_RealInput() {
        val result = Day13().part2()
        assertEquals(741745043105674, result)
    }
}