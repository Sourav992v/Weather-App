package com.sourav.weatherapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sourav.weatherapp.data.WeatherEntity
import com.sourav.weatherapp.databinding.WeatherItemBinding
import com.sourav.weatherapp.databinding.WeatherItemDailyBinding
import java.text.SimpleDateFormat
import java.util.*


//Created on 22 April 2021 by Sourav
class WeatherAdapterDaily: ListAdapter<WeatherEntity, WeatherAdapterDaily.WeatherViewHolderDaily>(WeatherComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolderDaily {
        val binding = WeatherItemDailyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  WeatherViewHolderDaily(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolderDaily, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null){
            holder.bind(currentItem)
        }
    }


    class WeatherViewHolderDaily(
        private val binding: WeatherItemDailyBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(weather: WeatherEntity){
            binding.apply {
                textViewTempValueDaily.text = weather.temperatureHigh.toString()
                apparentTempValueDaily.text = weather.apparentTemperatureHigh.toString()
                time.text = convertLongToTime(weather.time * 1000)

                summery.text = weather.summary
            }
        }

        fun convertLongToTime(time: Long): String {
            val date = Date(time)
            val format = SimpleDateFormat("dd:MM:yyyy", Locale.getDefault())
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