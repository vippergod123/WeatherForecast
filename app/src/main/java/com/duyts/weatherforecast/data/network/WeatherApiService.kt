package com.duyts.weatherforecast.data.network

import com.duyts.weatherforecast.data.model.WeatherForecastResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "60c6fbeb4b93ac653c492ba806fc346d"
const val BASE_URL = "https://api.openweathermap.org/data/2.5/forecast/"

//https://api.openweathermap.org/data/2.5/forecast/daily?q=saigon&cnt=7&appid=
interface WeatherApiService {
    @GET("daily")
    fun getWeatherForecastAsync(@Query("q") location: String,
                                @Query("cnt") count: Int): Deferred<WeatherForecastResponse>

    companion object {
        operator fun invoke(connectivityInterceptor: ConnectivityInterceptor): WeatherApiService {
            val requestInterceptor = Interceptor { chain ->
                val url = chain.request().url().newBuilder().addQueryParameter("appid", API_KEY)
                        .build()
                val request = chain.request().newBuilder().url(url).build()

                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder().addInterceptor(requestInterceptor)
                    .addInterceptor(connectivityInterceptor).build()

            return Retrofit.Builder().client(okHttpClient).baseUrl(BASE_URL)
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create()).build()
                    .create(WeatherApiService::class.java)
        }


    }

}