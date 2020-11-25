package com.example.datepickertest.view.model.hotel

import com.example.datepickertest.view.model.hotel.Hotel
import java.math.BigDecimal

class HotelMarAtlantico : Hotel() {

    override fun getName(): String {
        return "Hotel Mar Atlântico"
    }

    override fun getRegularWeekdayDaily(): BigDecimal {
        return BigDecimal(220)
    }

    override fun getRewardWeekdayDaily(): BigDecimal {
        return BigDecimal(100)
    }

    override fun getRegularWeekendDaily(): BigDecimal {
        return BigDecimal(150)
    }

    override fun getRewardWeekendDaily(): BigDecimal {
        return BigDecimal(40)
    }

    override fun getClassificacao(): Int {
        return 5
    }
}