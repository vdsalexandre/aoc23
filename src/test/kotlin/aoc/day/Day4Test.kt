package aoc.day

import aoc.Utils
import aoc.Utils.stringNumbersToList
import aoc.model.NumberLine
import org.junit.jupiter.api.Test

class Day4Test {

    private val points = listOf(0, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16_384, 32_768, 65_536, 131_072)

    @Test
    fun `day 4 part 1`() {
        val lines = Utils.linesFromFile(Utils.filePath("/04/input"))
        val winningNumbers: MutableList<NumberLine> = mutableListOf()
        val playedNumbers: MutableList<NumberLine> = mutableListOf()

        lines.forEach { line ->
            val part = line.substringAfter(":").split("|")
            winningNumbers.add(NumberLine(stringNumbersToList(part[0])))
            playedNumbers.add(NumberLine(stringNumbersToList(part[1])))
        }

        val allCommonNumbers: MutableList<List<Int>> = mutableListOf()
        for (i in 0 until winningNumbers.size) {
            allCommonNumbers.add(winningNumbers[i].getCommonNumbers(playedNumbers[i].numbers))
        }

        allCommonNumbers
            .sumOf { points[it.size] }
            .also { println(it) }
    }

    @Test
    fun `day 4 part 2`() {
        val lines = Utils.linesFromFile(Utils.filePath("/04/test"))
        val winningNumbers: MutableList<NumberLine> = mutableListOf()
        val playedNumbers: MutableList<NumberLine> = mutableListOf()

        lines.forEach { line ->
            val cardId = line.substringBefore(":").replace("Card", "").trim().toInt()
            val part = line.substringAfter(":").split("|")
            winningNumbers.add(NumberLine(stringNumbersToList(part[0]), cardId))
            playedNumbers.add(NumberLine(stringNumbersToList(part[1]), cardId))
        }

        val allCommonNumbers: MutableList<NumberLine> = mutableListOf()
        for (i in 0 until winningNumbers.size) {
            allCommonNumbers.add(NumberLine(winningNumbers[i].getCommonNumbers(playedNumbers[i].numbers), winningNumbers[i].cardId))
        }

        allCommonNumbers.forEach(::println)
    }
}