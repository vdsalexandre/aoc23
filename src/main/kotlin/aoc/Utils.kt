package aoc

import java.io.File
import java.io.FileNotFoundException

object Utils {

    fun linesFromFile(filename: String) = File(filename).useLines { it.toList() }

    fun filePath(filename: String) =
        object {}.javaClass.getResource(filename)?.file ?: throw FileNotFoundException(filename)
}