package cberg.aoc2020

import kotlin.test.Test
import kotlin.test.assertEquals

class Day03Test {
    private val exampleInput = listOf(
        "..##.......",
        "#...#...#..",
        ".#....#..#.",
        "..#.#...#.#",
        ".#...##..#.",
        "..#.##.....",
        ".#.#.#....#",
        ".#........#",
        "#.##...#...",
        "#...##....#",
        ".#..#...#.#"
    )

    private val realInput = Input("03").lines()

    @Test
    fun part1_Example() {
        val result = Day03(exampleInput).part1()
        assertEquals(7, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day03(realInput).part1()
        assertEquals(225, result)
    }

    @Test
    fun part2_Example() {
        val result = Day03(exampleInput).part2()
        assertEquals(336, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day03(realInput).part2()
        assertEquals(1115775000, result)
    }
}