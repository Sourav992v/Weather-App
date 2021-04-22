package com.sourav.weatherapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sourav.weatherapp.R
import com.sourav.weatherapp.databinding.FragmentDailyBinding
import com.sourav.weatherapp.presentation.adapter.WeatherAdapter
import com.sourav.weatherapp.presentation.adapter.WeatherAdapterDaily
import com.sourav.weatherapp.presentation.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint


//Created on 22 April 2021 by Sourav

@AndroidEntryPoint
class DailyFragment : Fragment(R.layout.fragment_daily) {

    private val viewModel : WeatherViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDailyBinding.bind(view)
        val weatherAdapter = WeatherAdapterDaily()

        binding.apply {
            dailyRecyclerView.setHasFixedSize(true)
            dailyRecyclerView.apply {
                adapter = weatherAdapter
                layoutManager = LinearLayoutManager(this@DailyFragment.requireActivity())
            }

            viewModel.daily.observe(viewLifecycleOwner){ weather ->
                weatherAdapter.submitList(weather)
            }
        }

    }

}