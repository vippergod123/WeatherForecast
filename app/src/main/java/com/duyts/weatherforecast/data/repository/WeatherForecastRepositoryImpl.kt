package com.duyts.weatherforecast.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.duyts.weatherforecast.data.model.WeatherForecastResponse
import com.duyts.weatherforecast.data.network.WeatherNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherForecastRepositoryImpl (private val weatherNetworkDataSource: WeatherNetworkDataSource) : WeatherForecastRepository {
    override suspend fun getWeatherForecast(): LiveData<out WeatherForecastResponse> {
        return withContext(Dispatchers.IO) {
            weatherNetworkDataSource.fetchWeather("London", 10)
            return@withContext weatherNetworkDataSource.weatherForecastData
        }
    }
}