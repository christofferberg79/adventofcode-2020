package cberg.aoc2020

fun <T> Iterable<T>.split(block: (T) -> Boolean): List<List<T>> {
    val outer = mutableListOf<List<T>>()
    var inner = mutableListOf<T>()
    forEach { e ->
        if (block(e)) {
            outer.add(inner)
            inner = mutableListOf()
        } else {
            inner.add(e)
        }
    }
    outer.add(inner)
    return outer
}
