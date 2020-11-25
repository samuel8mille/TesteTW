package com.example.datepickertest.view.model.hotel

import com.prolificinteractive.materialcalendarview.CalendarDay
import java.math.BigDecimal
import java.util.*

abstract class Hotel {

    abstract fun getName(): String

    abstract fun getRegularWeekdayDaily(): BigDecimal

    abstract fun getRewardWeekdayDaily(): BigDecimal

    abstract fun getRegularWeekendDaily(): BigDecimal

    abstract fun getRewardWeekendDaily(): BigDecimal

    abstract fun getRating(): Int

    private var _totalCost = BigDecimal(0)

    val totalCost: BigDecimal
        get() {
            return _totalCost
        }

    private fun calculateCost(dates: MutableList<CalendarDay>, isReward: Boolean): BigDecimal {

        var cost = BigDecimal(0)

        dates.forEach {
            if (it.calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || it.calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                cost =
                    cost.add(if (isReward) this.getRewardWeekendDaily() else this.getRegularWeekendDaily())
            } else {
                cost =
                    cost.add(if (isReward) this.getRewardWeekdayDaily() else this.getRegularWeekdayDaily())
            }
        }

        _totalCost = cost

        return cost
    }


    companion object {
        fun calculateBestPrice(
            dates: MutableList<CalendarDay>,
            hotels: List<Hotel>,
            isReward: Boolean
        ): Hotel {

            val prices: MutableList<BigDecimal> = arrayListOf()
            val hotel: MutableList<Hotel> = arrayListOf()

            hotels.forEach {
                prices.add(it.calculateCost(dates, isReward))
            }

            hotels.forEach {
                if (it.calculateCost(dates, isReward) == prices.min())
                    hotel.add(it)
            }

            return if (hotel.size == 1) {
                hotel[0]
            } else {
                getBestRatingHotel(
                    hotels
                )
            }
        }

        private fun getBestRatingHotel(hotels: List<Hotel>): Hotel {
            var hotel = hotels[0]
            var rating = 0

            hotels.forEach {
                if (it.getRating() > rating) {
                    rating = it.getRating()
                    hotel = it
                }
            }
            return hotel
        }
    }


}