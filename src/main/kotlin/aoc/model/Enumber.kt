package aoc.model

data class Enumber(val startRow: Int, val startCol: Int, val value: String) {

    fun isAdjacentWith(row: Int, col: Int): Boolean {
        return row to col in getAllAdjacentAround()
    }

    fun intValue() = value.toInt()

    private fun getAllAdjacentAround(): List<Pair<Int, Int>> {
        val allAdjacentAround: MutableList<Pair<Int, Int>> = mutableListOf()

        for (i in (startRow - 1)..(startRow + 1)) {
            for (j in (startCol - 1)..(startCol + value.length)) {
                allAdjacentAround.add(i to j)
            }
        }

        return allAdjacentAround
    }
}
