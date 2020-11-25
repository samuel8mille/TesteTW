package com.example.datepickertest.view.model.hotel

import java.math.BigDecimal

interface IHotel {

    fun getName(): String

    fun getRating(): Int

    fun getRegularWeekdayDaily(): BigDecimal

    fun getRewardWeekdayDaily(): BigDecimal

    fun getRegularWeekendDaily(): BigDecimal

    fun getRewardWeekendDaily(): BigDecimal
}