package com.duyts.weatherforecast.data.network

import androidx.lifecycle.LiveData
import com.duyts.weatherforecast.data.model.WeatherForecastResponse

interface WeatherNetworkDataSource {
    val weatherForecastData: LiveData<WeatherForecastResponse>

    suspend fun fetchWeather(
            location: String, count: Int
    )
}