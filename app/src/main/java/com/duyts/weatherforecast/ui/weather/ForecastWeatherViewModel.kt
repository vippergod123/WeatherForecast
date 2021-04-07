package com.duyts.weatherforecast.ui.weather

import androidx.lifecycle.ViewModel
import com.duyts.weatherforecast.data.repository.WeatherForecastRepository
import com.duyts.weatherforecast.internal.lazyDeferred

class ForecastWeatherViewModel(
        private val forecastRepository: WeatherForecastRepository,
) : ViewModel() {
    val forecast by lazyDeferred {
        forecastRepository.getWeatherForecast()
    }

}