package com.example.datepickertest

import com.example.datepickertest.view.model.hotel.Hotel
import com.example.datepickertest.view.model.hotel.HotelJardimBotanico
import com.example.datepickertest.view.model.hotel.HotelMarAtlantico
import com.example.datepickertest.view.model.hotel.HotelParqueDasFlores
import com.prolificinteractive.materialcalendarview.CalendarDay
import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun testGetTotalCostFirstScenario() {
        val dates = mutableListOf(
            CalendarDay(2020, 2, 16),
            CalendarDay(2020, 2, 17),
            CalendarDay(2020, 2, 18)
        )
        val isReward = false
        val hotel = HotelParqueDasFlores()

        assertEquals(BigDecimal(330), hotel.calculateCost(dates, isReward))
    }

    @Test
    fun testGetTotalCostSecondScenario() {
        val dates = mutableListOf(
            CalendarDay(2020, 2, 20),
            CalendarDay(2020, 2, 21),
            CalendarDay(2020, 2, 22)
        )
        val isReward = false
        val hotel = HotelJardimBotanico()

        assertEquals(BigDecimal(280), hotel.calculateCost(dates, isReward))
    }

    @Test
    fun testGetTotalCostThirdScenario() {
        val dates = mutableListOf(
            CalendarDay(2020, 2, 26),
            CalendarDay(2020, 2, 27),
            CalendarDay(2020, 2, 28)
        )
        val isReward = true
        val hotel = HotelMarAtlantico()

        assertEquals(BigDecimal(240), hotel.calculateCost(dates, isReward))
    }

    @Test
    fun testCalculateBestPriceFirstScenario() {
        val dates = mutableListOf(
            CalendarDay(2020, 2, 16),
            CalendarDay(2020, 2, 17),
            CalendarDay(2020, 2, 18)
        )
        val hotels = listOf(
            HotelParqueDasFlores(),
            HotelJardimBotanico(),
            HotelMarAtlantico()
        )
        val isReward = false

        assertEquals(HotelParqueDasFlores()::class, Hotel.calculateBestPrice(dates, hotels, isReward)::class)
    }

    @Test
    fun testCalculateBestPriceSecondScenario() {
        val dates = mutableListOf(
            CalendarDay(2020, 2, 20),
            CalendarDay(2020, 2, 21),
            CalendarDay(2020, 2, 22)
        )
        val hotels = listOf(
            HotelParqueDasFlores(),
            HotelJardimBotanico(),
            HotelMarAtlantico()
        )
        val isReward = false

        assertEquals(HotelJardimBotanico()::class, Hotel.calculateBestPrice(dates, hotels, isReward)::class)
    }

    @Test
    fun testCalculateBestPriceThirdScenario() {
        val dates = mutableListOf(
            CalendarDay(2020, 2, 26),
            CalendarDay(2020, 2, 27),
            CalendarDay(2020, 2, 28)
        )
        val hotels = listOf(
            HotelParqueDasFlores(),
            HotelJardimBotanico(),
            HotelMarAtlantico()
        )
        val isReward = true

        assertEquals(HotelMarAtlantico()::class, Hotel.calculateBestPrice(dates, hotels, isReward)::class)
    }

    @Test
    fun testGetBestPriceHotel() {
        val hotels = listOf(
            HotelParqueDasFlores(),
            HotelJardimBotanico(),
            HotelMarAtlantico()
        )

        assertEquals(HotelMarAtlantico()::class, Hotel.getBestRatingHotel(hotels)::class)
    }
}