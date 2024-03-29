package aoc.model

enum class Number(val value: Int) {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10);

    companion object {
        fun Number.formatted() = this.name.lowercase()

        fun Number.toDigitValue() = this.value.toString()
    }
}