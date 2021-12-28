package cberg.aoc2020

import cberg.aoc2020.Day18.Expression
import cberg.aoc2020.Day18.Expression2
import kotlin.test.Test
import kotlin.test.assertEquals

class Day18Test {
    private val realInput = Input("18").lines()

    @Test
    fun part1_Example() {
        assertEquals(71, Expression("1 + 2 * 3 + 4 * 5 + 6").evaluate())
        assertEquals(51, Expression("1 + (2 * 3) + (4 * (5 + 6))").evaluate())
        assertEquals(26, Expression("2 * 3 + (4 * 5)").evaluate())
        assertEquals(437, Expression("5 + (8 * 3 + 9 + 3 * 4 * 3").evaluate())
        assertEquals(12240, Expression("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))").evaluate())
        assertEquals(13632, Expression("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2").evaluate())
    }

    @Test
    fun part1_RealInput() {
        val result = Day18(realInput).part1()
        assertEquals(14208061823964, result)
    }

    @Test
    fun part2_Example() {
        assertEquals(231, Expression2("1 + 2 * 3 + 4 * 5 + 6").evaluate())
        assertEquals(51, Expression2("1 + (2 * 3) + (4 * (5 + 6))").evaluate())
        assertEquals(46, Expression2("2 * 3 + (4 * 5)").evaluate())
        assertEquals(1445, Expression2("5 + (8 * 3 + 9 + 3 * 4 * 3").evaluate())
        assertEquals(669060, Expression2("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))").evaluate())
        assertEquals(23340, Expression2("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2").evaluate())
    }

    @Test
    fun part2_RealInput() {
        val result = Day18(realInput).part2()
        assertEquals(320536571743074, result)
    }
}