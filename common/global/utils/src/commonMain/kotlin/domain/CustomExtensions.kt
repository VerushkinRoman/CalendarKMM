package domain

import kotlin.math.absoluteValue

fun <T> Sequence<T>.second(): T {
    val iterator = iterator()
    if (!iterator.hasNext()) throw NoSuchElementException("Sequence is empty.")
    iterator.next()
    if (!iterator.hasNext()) throw NoSuchElementException("Sequence contains only single element.")
    return iterator.next()
}

fun Double?.toFormattedAmount(): String {
    if (this == null) return "Р"

    val integerDigits = this.toInt().absoluteValue
    val integerLength = integerDigits.toString().length

    val integerData = if (integerLength > 3) {
        val startNumbers = integerLength % 3
        integerDigits.toString()
            .substring(startNumbers)
            .chunked(3)
            .joinToString(" ")
            .let {
                return@let if (startNumbers > 0) "${
                    integerDigits.toString().take(startNumbers)
                } $it" else it
            }
    } else {
        integerDigits.toString()
    }.let { if (this < 0) "-$it" else it }

    val floatDigits = ((this.absoluteValue - integerDigits) * 100.0)
        .toInt()
        .absoluteValue
        .toString()
        .let { return@let if (it.length < 2) "${it}0" else it }

    return "${integerData}.$floatDigits Р"
}