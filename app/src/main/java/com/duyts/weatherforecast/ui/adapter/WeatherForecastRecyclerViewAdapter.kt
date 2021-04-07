package com.duyts.weatherforecast.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.duyts.weatherforecast.R
import com.duyts.weatherforecast.data.model.WeatherForecastResponse
import com.duyts.weatherforecast.internal.inflate

class WeatherForecastRecyclerViewAdapter(
        private val list: ArrayList<WeatherForecastResponse.WeatherForecastModel>) :
        RecyclerView.Adapter<WeatherForecastViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherForecastViewHolder {
        val inflatedView = parent.inflate(R.layout.weather_view_holder, false)
        return WeatherForecastViewHolder(inflatedView)

    }

    override fun onBindViewHolder(holder: WeatherForecastViewHolder, position: Int) {
        val itemPhoto = list[position]
        holder.bindPhoto(itemPhoto)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
