package aoc.model

data class NumberLine(val numbers: List<Int>, val cardId: Int = 0) {

    fun getCommonNumbers(otherNumbers: List<Int>): List<Int> {
        val commonNumbers: MutableList<Int> = mutableListOf()

        otherNumbers.forEach { otherNumber ->
            if (otherNumber in numbers)
                commonNumbers.add(otherNumber)
        }
        return commonNumbers
    }
}
