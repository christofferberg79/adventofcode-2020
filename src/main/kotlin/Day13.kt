package cberg.aoc2020

class Day13(private val input: List<String>) {
    fun part1(): Int {
        val t = input.first().toInt()
        val buses = input.last().split(",").mapNotNull { it.toIntOrNull() }
        return buses.associateWith { bus -> (bus - t).mod(bus) }
            .minByOrNull { (_, wait) -> wait }
            ?.let { (bus, wait) -> bus * wait }
            ?: error("No solution found")
    }

    fun part2(): Long {
        val offsets = input.last().split(",")
            .mapIndexedNotNull { i, s -> s.toLongOrNull()?.let { bus -> bus to i.toLong() } }
            .sortedBy { (bus, _) -> bus }

        var t = 0L
        var dt = 1L
        for ((bus, offset) in offsets) {
            while ((t + offset) % bus != 0L) {
                t += dt
            }
            dt *= bus
        }
        return t
    }

}

