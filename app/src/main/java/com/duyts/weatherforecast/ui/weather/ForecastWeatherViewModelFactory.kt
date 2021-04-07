package com.duyts.weatherforecast.ui.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.duyts.weatherforecast.data.repository.WeatherForecastRepository

class ForecastWeatherViewModelFactory(
        private val forecastRepository: WeatherForecastRepository,
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ForecastWeatherViewModel(forecastRepository) as T
    }
}