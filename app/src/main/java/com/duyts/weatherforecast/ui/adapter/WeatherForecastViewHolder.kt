package com.duyts.weatherforecast.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.duyts.weatherforecast.data.model.WeatherForecastResponse
import kotlinx.android.synthetic.main.weather_view_holder.view.*

class WeatherForecastViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
    //2
    private var view: View = v
    private var item: WeatherForecastResponse.WeatherForecastModel? = null

    //3
    init {
        v.setOnClickListener(this)
    }

    //4
    override fun onClick(v: View) {
    }

    fun bindPhoto(item: WeatherForecastResponse.WeatherForecastModel) {
        this.item = item
        view.dateTextView?.text = item.dt.toString()
        view.temperatureTextView?.text = item.temp.toString()
        view.pressureTextView?.text = item.pressure.toString()
        view.humidityTextView?.text = item.humidity.toString()
        view.descriptionTextView?.text =  item.weather.first().description
    }

    companion object {
        //5
        private val PHOTO_KEY = "PHOTO"
    }
}