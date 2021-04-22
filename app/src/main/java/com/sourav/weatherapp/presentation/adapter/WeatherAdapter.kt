package com.sourav.weatherapp.presentation.adapter

import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sourav.weatherapp.data.WeatherEntity
import com.sourav.weatherapp.databinding.WeatherItemBinding
import java.text.SimpleDateFormat
import java.util.*


//Created on 22 April 2021 by Sourav

class WeatherAdapter: ListAdapter<WeatherEntity, WeatherAdapter.WeatherViewHolder>(WeatherComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding = WeatherItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null){
            holder.bind(currentItem)
        }
    }


    class WeatherViewHolder(
        private val binding: WeatherItemBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(weather: WeatherEntity){
            binding.apply {

                textViewTempValue.text = weather.temperature.toString()

                apparentTempValue.text = weather.apparentTemperature.toString()
                time.text = convertLongToTime(weather.time * 1000)
                summery.text = weather.summary

            }
        }

        fun convertLongToTime(time: Long): String {
            val date = Date(time)
            val format = SimpleDateFormat("hh:mm:ss aa", Locale.getDefault())
            return format.format(date)
        }
    }

    class WeatherComparator: DiffUtil.ItemCallback<WeatherEntity>(){
        override fun areItemsTheSame(oldItem: WeatherEntity, newItem: WeatherEntity) =
            oldItem.time == newItem.time


        override fun areContentsTheSame(oldItem: WeatherEntity, newItem: WeatherEntity) =
            oldItem == newItem

    }

}