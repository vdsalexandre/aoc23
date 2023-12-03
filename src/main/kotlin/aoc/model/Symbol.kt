package aoc.model

data class Symbol(val character: Char, val row: Int, val col: Int) {
    val id = "$character$row$col"
}
