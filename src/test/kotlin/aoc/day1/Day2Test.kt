package aoc.day1

import aoc.Utils
import org.junit.jupiter.api.Test

class Day2Test {

    @Test
    fun `should check if each game is possible with the initial configuration (red green blue)`() {
        val lines = Utils.linesFromFile(Utils.filePath("/02/input"))
        val maxRed = 12
        val maxGreen = 13
        val maxBlue = 14
        var total = 0

        lines.mapIndexed { index, line ->
            var r = 0; var g = 0; var b = 0; var validity = 0
            line.substringAfter(":", "").replace(";", ",").split(",").forEach {
                if (it.contains("red"))
                    r = it.replace("red", "").trim().toInt()
                if (it.contains("green"))
                    g = it.replace("green", "").trim().toInt()
                if (it.contains("blue"))
                    b = it.replace("blue", "").trim().toInt()

                if (r > maxRed) validity++
                if (g > maxGreen) validity++
                if (b > maxBlue) validity++
            }
            if (validity == 0)
                total += index.inc()
        }

        println("total: $total")
    }

    @Test
    fun `should compute the minimum value for each color is needed for each game`() {
        val lines = Utils.linesFromFile(Utils.filePath("/02/input"))
        var maxRed = 0
        var maxGreen = 0
        var maxBlue = 0
        var total: Int
        var overTotal = 0

        lines.map { line ->
            var r = 0; var g = 0; var b = 0
            line.substringAfter(":", "").replace(";", ",").split(",").forEach {
                if (it.contains("red"))
                    r = it.replace("red", "").trim().toInt()
                if (it.contains("green"))
                    g = it.replace("green", "").trim().toInt()
                if (it.contains("blue"))
                    b = it.replace("blue", "").trim().toInt()

                if (r > maxRed) maxRed = r
                if (g > maxGreen) maxGreen = g
                if (b > maxBlue) maxBlue = b
            }
            total = maxRed * maxGreen * maxBlue
            overTotal += total
            println("Red ($maxRed) * Green ($maxGreen) * Blue ($maxBlue) = $total")
            maxRed = 0
            maxGreen = 0
            maxBlue = 0
        }
        println("\nSum: $overTotal")
    }
}
