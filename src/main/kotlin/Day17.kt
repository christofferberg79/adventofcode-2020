package cberg.aoc2020

class Day17(private val input: List<String>) {

    fun part1() = solve(Vec4(1, 1, 1, 0))

    fun part2() = solve(Vec4(1, 1, 1, 1))

    private fun solve(expand: Vec4) =
        generateSequence(parse(input)) { state -> update(state, expand) }.elementAt(6).active.size

    private fun parse(input: List<String>): State {
        val active = input.flatMapIndexed { y, line ->
            line.mapIndexedNotNull { x, c ->
                if (c == '#') Vec4(x, y, 0, 0) else null
            }
        }.toSet()
        val min = Vec4(0, 0, 0, 0)
        val max = Vec4(input.first().lastIndex, input.lastIndex, 0, 0)
        return State(min, max, active)
    }

    private class State(val min: Vec4, val max: Vec4, val active: Set<Vec4>)

    private fun update(state: State, expand: Vec4): State {
        val min = state.min - expand
        val max = state.max + expand
        val active = (min.x..max.x).flatMap { x ->
            (min.y..max.y).flatMap { y ->
                (min.z..max.z).flatMap { z ->
                    (min.w..max.w).mapNotNull { w ->
                        Vec4(x, y, z, w).let { v ->
                            val adjacent = v.adjacent
                            val count = adjacent.count { va -> va in state.active }
                            when (v in state.active) {
                                true -> if (count in 2..3) v else null
                                false -> if (count == 3) v else null
                            }
                        }
                    }
                }
            }
        }
        return State(min, max, active.toSet())
    }

    private data class Vec4(val x: Int, val y: Int, val z: Int, val w: Int)

    private operator fun Vec4.plus(other: Vec4) = Vec4(x + other.x, y + other.y, z + other.z, w + other.w)
    private operator fun Vec4.minus(other: Vec4) = Vec4(x - other.x, y - other.y, z - other.z, w - other.w)

    private val Vec4.adjacent
        get() = (x - 1..x + 1).flatMap { xx ->
            (y - 1..y + 1).flatMap { yy ->
                (z - 1..z + 1).flatMap { zz ->
                    (w - 1..w + 1).map { ww -> Vec4(xx, yy, zz, ww) }
                }
            }
        } - this
}
