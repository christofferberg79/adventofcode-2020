package cberg.aoc2020

class Day18(private val input: List<String>) {
    fun part1() = input.sumOf { line -> Expression(line).evaluate() }

    fun part2() = input.sumOf { line -> Expression2(line).evaluate() }

    class Expression(private val input: String) {
        private var pos = 0

        fun evaluate(): Long {
            var result = 0L
            var plus = true

            while (pos <= input.lastIndex) {
                when (val c = input[pos++]) {
                    ' ' -> continue
                    '+' -> plus = true
                    '*' -> plus = false
                    '(' -> {
                        if (plus) {
                            result += evaluate()
                        } else {
                            result *= evaluate()
                        }
                    }
                    ')' -> return result
                    else -> {
                        check(c.isDigit())
                        if (plus) {
                            result += c.digitToInt()
                        } else {
                            result *= c.digitToInt()
                        }
                    }
                }
            }

            return result
        }
    }

    class Expression2(private val input: String) {
        private var pos = 0

        fun evaluate(): Long {
            var result = 0L

            while (pos <= input.lastIndex) {
                when (val c = input[pos++]) {
                    ' ' -> continue
                    '+' -> continue
                    '*' -> result *= evaluate()
                    '(' -> {
                        result += evaluate()
                        pos++
                    }
                    ')' -> {
                        pos--
                        return result
                    }
                    else -> result += c.digitToInt()
                }
            }

            return result
        }
    }
}
