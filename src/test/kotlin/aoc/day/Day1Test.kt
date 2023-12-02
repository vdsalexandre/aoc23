package aoc.day

import aoc.Utils.filePath
import aoc.Utils.linesFromFile
import aoc.model.Number
import aoc.model.Number.Companion.formatted
import aoc.model.Number.Companion.toDigitValue
import org.junit.jupiter.api.Test

class Day1Test {

    @Test
    fun `should extract calibration values from document`() {
        val lines = linesFromFile(filePath("/01/input"))

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
    fun `should extract calibration values from document even if values are in character`() {
        val lines = linesFromFile(filePath("/01/input"))
        val updatedLines: MutableList<String> = mutableListOf()

        lines.forEach { line ->
            var temp = ""
            var tempLine = ""
            line.toCharArray().map { c ->
                if (c.isDigit()) {
                    tempLine += c
                    temp = ""
                } else {
                    temp += c
                    val foundNumber = Number.values().firstOrNull { it.formatted() in temp }

                    if (foundNumber != null) {
                        tempLine += foundNumber.toDigitValue()
                        temp = c.toString()
                    }
                }
            }
            updatedLines.add(tempLine)
        }

        val total = updatedLines.map { line ->
            line.toCharArray()
                .filter { c -> c.isDigit()  }
                .joinToString(separator = "")
        }.sumOf {
            listOf(it.first(), it.last())
                .joinToString(separator = "")
                .toInt()
        }

        println("total: $total")
    }
}