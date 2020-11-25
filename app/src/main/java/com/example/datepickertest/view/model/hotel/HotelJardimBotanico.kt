package com.example.datepickertest.view.model.hotel

import com.example.datepickertest.view.model.hotel.Hotel
import java.math.BigDecimal

class HotelJardimBotanico : Hotel() {

    override fun getName(): String {
        return "Hotel Jardim Botânico"
    }

    override fun getRegularWeekdayDaily(): BigDecimal {
        return BigDecimal(160)
    }

    override fun getRewardWeekdayDaily(): BigDecimal {
        return BigDecimal(110)
    }

    override fun getRegularWeekendDaily(): BigDecimal {
        return BigDecimal(60)
    }

    override fun getRewardWeekendDaily(): BigDecimal {
        return BigDecimal(50)
    }

    override fun getClassificacao(): Int {
        return 4
    }
}