package com.sourav.weatherapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sourav.weatherapp.R
import com.sourav.weatherapp.databinding.FragmentDailyBinding
import com.sourav.weatherapp.databinding.FragmentHourlyBinding
import com.sourav.weatherapp.presentation.adapter.WeatherAdapter
import com.sourav.weatherapp.presentation.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_hourly.*


//Created on 22 April 2021 by Sourav
@AndroidEntryPoint
class HourlyFragment : Fragment(R.layout.fragment_hourly) {

    private val viewModel : WeatherViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentHourlyBinding.bind(view)
        val weatherAdapter = WeatherAdapter()

        binding.apply {
            hourly_recycler_view.setHasFixedSize(true)
            hourly_recycler_view.apply {
                adapter = weatherAdapter
                layoutManager = LinearLayoutManager(this@HourlyFragment.requireActivity())
            }

            viewModel.hourly.observe(viewLifecycleOwner){ weather ->
                weatherAdapter.submitList(weather)
            }
        }

    }

}