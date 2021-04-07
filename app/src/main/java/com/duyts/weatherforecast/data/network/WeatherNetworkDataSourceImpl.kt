package com.duyts.weatherforecast.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.duyts.weatherforecast.data.model.WeatherForecastResponse
import com.duyts.weatherforecast.internal.NoConnectivityException

class WeatherNetworkDataSourceImpl(private val weatherApiService: WeatherApiService) :
        WeatherNetworkDataSource {

    private val _weatherForecastData = MutableLiveData<WeatherForecastResponse>()
    override val weatherForecastData: LiveData<WeatherForecastResponse>
        get() = _weatherForecastData

    override suspend fun fetchWeather(location: String, count: Int) {
        try {
            val fetchCurrentWeather = weatherApiService.getWeatherForecastAsync(location, count)
                    .await()
            _weatherForecastData.postValue(fetchCurrentWeather)
        } catch (e: NoConnectivityException) {
            Log.e("Connectivity", "No internet connection", e)
        }
    }
}