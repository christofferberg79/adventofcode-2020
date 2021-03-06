package cberg.aoc2020

import java.io.File

class Input(filename: String) {
    private val file = File("input/$filename.txt")

    fun oneLine() = lines().first()
    fun lines() = file.readLines()
    fun intLines() = lines().map { it.toInt() }
    fun longLines() = lines().map { it.toLong() }
}