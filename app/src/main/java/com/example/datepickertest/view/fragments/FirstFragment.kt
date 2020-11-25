package com.example.datepickertest.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.datepickertest.databinding.FragmentFirstBinding
import com.example.datepickertest.view.model.hotel.Hotel
import com.example.datepickertest.view.model.hotel.HotelJardimBotanico
import com.example.datepickertest.view.model.hotel.HotelMarAtlantico
import com.example.datepickertest.view.model.hotel.HotelParqueDasFlores
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import java.text.NumberFormat
import java.util.*

class FirstFragment : Fragment() {

    private lateinit var calendarView: MaterialCalendarView

    private lateinit var binding: FragmentFirstBinding

    private val formatoDinheiro = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calendarView = binding.calendarView

        binding.buttonFirst.setOnClickListener {
            getBestPrice()
        }
    }

    fun getBestPrice() {
        if (calendarView.selectedDates.isNotEmpty()) {
            val bestPriceHotel = Hotel.calculateBestPrice(
                calendarView.selectedDates,
                listOf(
                    HotelParqueDasFlores(),
                    HotelJardimBotanico(),
                    HotelMarAtlantico()
                ),
                binding.rewardClintSwitch.isChecked
            )

            Toast.makeText(
                context,
                "O melhor preço é do: ${bestPriceHotel.getName()} com o valor de: ${formatoDinheiro.format(bestPriceHotel.totalCost)}",
                Toast.LENGTH_LONG
            ).show()
        } else {
            Toast.makeText(context, "Por favor, selecione um período!", Toast.LENGTH_SHORT).show()
        }
    }
}