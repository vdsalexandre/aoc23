package aoc.day

import aoc.Utils
import aoc.model.Enumber
import aoc.model.Symbol
import org.junit.jupiter.api.Test

class Day3Test {

    @Test
    fun `day 3 part 1`() {
        val symbols = listOf('*', '$', '+', '-', '%', '#', '&', '=', '/', '@')
        val lines = Utils.linesFromFile(Utils.filePath("/03/input"))
        val engineSymbols: MutableList<Symbol> = mutableListOf()
        val engineNumbers: MutableList<Enumber> = mutableListOf()

        lines.mapIndexed { row, line ->
            var enumber = ""
            var currentCol = 0
            line.toCharArray().mapIndexed { col, c ->
                currentCol = col
                when {
                    c.isDigit() -> enumber += c
                    c in symbols -> {
                        engineSymbols.add(Symbol(c, row, col))
                        if (enumber.isNotEmpty()) {
                            engineNumbers.add(Enumber(row, col - enumber.length, enumber))
                            enumber = ""
                        }
                    }

                    enumber.isNotEmpty() && !c.isDigit() -> {
                        engineNumbers.add(Enumber(row, col - enumber.length, enumber))
                        enumber = ""
                    }

                    else -> {}
                }
            }
            if (enumber.isNotEmpty()) {
                engineNumbers.add(Enumber(row, currentCol - enumber.length, enumber))
                enumber = ""
            }
        }
        var adjacentNumbersTotal = 0
        var count = 0
        engineNumbers.forEach { enumber ->
            engineSymbols.forEach { symbol ->
                if (enumber.isAdjacentWith(symbol.row, symbol.col)) {
                    adjacentNumbersTotal += enumber.intValue()
                    count++
                }
            }
        }
        println("Adjacent numbers total ($count / ${engineNumbers.size}): $adjacentNumbersTotal")
    }

    @Test
    fun `day 3 part 2`() {
        val symbols = listOf('*', '$', '+', '-', '%', '#', '&', '=', '/', '@')
        val lines = Utils.linesFromFile(Utils.filePath("/03/input"))
        val engineSymbols: MutableList<Symbol> = mutableListOf()
        val engineNumbers: MutableList<Enumber> = mutableListOf()

        lines.mapIndexed { row, line ->
            var enumber = ""
            var currentCol = 0
            line.toCharArray().mapIndexed { col, c ->
                currentCol = col
                when {
                    c.isDigit() -> enumber += c
                    c in symbols -> {
                        engineSymbols.add(Symbol(c, row, col))
                        if (enumber.isNotEmpty()) {
                            engineNumbers.add(Enumber(row, col - enumber.length, enumber))
                            enumber = ""
                        }
                    }

                    enumber.isNotEmpty() && !c.isDigit() -> {
                        engineNumbers.add(Enumber(row, col - enumber.length, enumber))
                        enumber = ""
                    }

                    else -> {}
                }
            }
            if (enumber.isNotEmpty()) {
                engineNumbers.add(Enumber(row, currentCol - enumber.length, enumber))
                enumber = ""
            }
        }

        engineNumbers.forEach { enumber ->
            engineSymbols.forEach { symbol ->
                if (enumber.isAdjacentWith(symbol.row, symbol.col)) {
                    enumber.symbolId = symbol.id
                }
            }
        }

        val elements = engineNumbers
            .filter { it.symbolId.isNotEmpty() }
            .groupBy { it.symbolId }
            .values.toList()
            .filter { it.size == 2 }

        var total = 0
        elements.forEach { enumbers ->
            total += (enumbers[0].value.toInt() * enumbers[1].value.toInt())
            return@forEach
        }

        println("total: $total")
    }
}
