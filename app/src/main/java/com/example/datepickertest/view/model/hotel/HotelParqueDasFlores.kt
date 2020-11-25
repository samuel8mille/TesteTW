package com.example.datepickertest.view.model.hotel

import com.example.datepickertest.view.model.hotel.Hotel
import java.math.BigDecimal

class HotelParqueDasFlores : Hotel() {

    override fun getName(): String {
        return "Hotel Parque das Flores"
    }

    override fun getRegularWeekdayDaily(): BigDecimal {
        return BigDecimal(110)
    }

    override fun getRewardWeekdayDaily(): BigDecimal {
        return BigDecimal(80)
    }

    override fun getRegularWeekendDaily(): BigDecimal {
        return BigDecimal(90)
    }

    override fun getRewardWeekendDaily(): BigDecimal {
        return BigDecimal(80)
    }

    override fun getClassificacao(): Int {
        return 3
    }
}