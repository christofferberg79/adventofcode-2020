package cberg.aoc2020

import kotlin.test.Test
import kotlin.test.assertEquals

class Day14Test {
    private val exampleInput1 = listOf(
        "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
        "mem[8] = 11",
        "mem[7] = 101",
        "mem[8] = 0"
    )

    private val exampleInput2 = listOf(
        "mask = 000000000000000000000000000000X1001X",
        "mem[42] = 100",
        "mask = 00000000000000000000000000000000X0XX",
        "mem[26] = 1"
    )

    private val realInput = Input("14").lines()

    @Test
    fun part1_Example() {
        val result = Day14(exampleInput1).part1()
        assertEquals(165, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day14(realInput).part1()
        assertEquals(13556564111697, result)
    }

    @Test
    fun part2_Example() {
        val result = Day14(exampleInput2).part2()
        assertEquals(208, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day14(realInput).part2()
        assertEquals(4173715962894, result)
    }
}