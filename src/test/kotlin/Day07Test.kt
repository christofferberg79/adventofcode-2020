package cberg.aoc2020

import kotlin.test.Test
import kotlin.test.assertEquals

class Day07Test {
    private val exampleInput = listOf(
        "light red bags contain 1 bright white bag, 2 muted yellow bags.",
        "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
        "bright white bags contain 1 shiny gold bag.",
        "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
        "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
        "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
        "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
        "faded blue bags contain no other bags.",
        "dotted black bags contain no other bags."
    )

    private val realInput = Input("07").lines()

    @Test
    fun part1_Example() {
        val result = Day07(exampleInput).part1()
        assertEquals(4, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day07(realInput).part1()
        assertEquals(355, result)
    }

    @Test
    fun part2_Example() {
        val result = Day07(exampleInput).part2()
        assertEquals(32, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day07(realInput).part2()
        assertEquals(5312, result)
    }
}