package com.duyts.weatherforecast.data.repository

import androidx.lifecycle.LiveData
import com.duyts.weatherforecast.data.model.WeatherForecastResponse
import org.threeten.bp.LocalDate

interface WeatherForecastRepository {
    suspend fun getWeatherForecast(): LiveData<out WeatherForecastResponse>
}