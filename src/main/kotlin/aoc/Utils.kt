package aoc

import java.io.File
import java.io.FileNotFoundException

object Utils {

    fun linesFromFile(filename: String) = File(filename).useLines { it.toList() }

    fun filePath(filename: String) =
        object {}.javaClass.getResource(filename)?.file ?: throw FileNotFoundException(filename)

    fun stringNumbersToList(line: String) = line.trim().replace("\\s+".toRegex(), " ").split(" ").map { it.toInt() }
}