package model

import kotlinx.datetime.LocalDate

data class DayData(val date: LocalDate, val drinkType: DrinkType? = null) {
    override fun toString(): String = date.toString()
}