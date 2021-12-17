package cberg.aoc2020

import kotlin.math.abs

class Day12(private val input: List<String>) {
    constructor() : this(Input("12.txt").lines())

    fun part1(): Int {
        var pos = Vec(0, 0)
        var dir = east
        for ((action, value) in input.map(::parse)) {
            when (action) {
                'N' -> pos += north * value
                'S' -> pos += south * value
                'E' -> pos += east * value
                'W' -> pos += west * value
                'L' -> dir = dir.rotateLeft(value)
                'R' -> dir = dir.rotateRight(value)
                'F' -> pos += dir * value
            }
        }
        return pos.manhattanDistance
    }

    fun part2(): Int {
        var pos = Vec(0, 0)
        var wp = Vec(10, 1)
        for ((action, value) in input.map(::parse)) {
            when (action) {
                'N' -> wp += north * value
                'S' -> wp += south * value
                'E' -> wp += east * value
                'W' -> wp += west * value
                'L' -> wp = wp.rotateLeft(value)
                'R' -> wp = wp.rotateRight(value)
                'F' -> pos += wp * value
            }
        }
        return pos.manhattanDistance
    }

    private fun parse(line: String): Pair<Char, Int> = Pair(line.first(), line.substring(1).toInt())

    private val north = Vec(0, 1)
    private val east = Vec(1, 0)
    private val south = Vec(0, -1)
    private val west = Vec(-1, 0)

    data class Vec(val x: Int, val y: Int) {
        operator fun plus(other: Vec) = Vec(x + other.x, y + other.y)
        operator fun times(value: Int) = Vec(x * value, y * value)
        val manhattanDistance: Int get() = abs(x) + abs(y)

        fun rotateLeft(angle: Int) = when (angle) {
            90 -> Vec(-y, x)
            180 -> Vec(-x, -y)
            270 -> Vec(y, -x)
            else -> error("Unsupported angle $angle")
        }

        fun rotateRight(angle: Int) = when (angle) {
            90 -> Vec(y, -x)
            180 -> Vec(-x, -y)
            270 -> Vec(-y, x)
            else -> error("Unsupported angle $angle")
        }
    }
}
