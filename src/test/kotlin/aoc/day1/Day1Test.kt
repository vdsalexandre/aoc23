package aoc.day1

import aoc.Utils.filePath
import aoc.Utils.linesFromFile
import org.junit.jupiter.api.Test

class Day1Test {

    @Test
    fun `should extract calibration values from document`() {
        val lines = linesFromFile(filePath("/01/01-input")) // test

        val total = lines.map { line ->
            line.toCharArray()
                .filter { c -> c.isDigit() }
                .joinToString(separator = "")
        }.sumOf {
            listOf(it.first(), it.last())
                .joinToString(separator = "")
                .toInt()
        }

        println("total: $total")
    }

    @Test
    fun `should do something`() {
        TODO("Not yet implemented")
    }
}