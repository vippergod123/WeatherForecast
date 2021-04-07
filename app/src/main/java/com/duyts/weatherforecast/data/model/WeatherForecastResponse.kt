package com.duyts.weatherforecast.data.model

import com.google.gson.annotations.SerializedName

data class WeatherForecastResponse(

	@field:SerializedName("city")
	val city: City,

	@field:SerializedName("cnt")
	val cnt: Int,

	@field:SerializedName("cod")
	val cod: String,

	@field:SerializedName("message")
	val message: Double,

	@field:SerializedName("list")
	val list: List<WeatherForecastModel>
) {
	data class City(

		@field:SerializedName("country")
		val country: String,

		@field:SerializedName("coord")
		val coord: Coord,

		@field:SerializedName("timezone")
		val timezone: Int,

		@field:SerializedName("name")
		val name: String,

		@field:SerializedName("id")
		val id: Int,

		@field:SerializedName("population")
		val population: Int
	) {

		data class Coord(

			@field:SerializedName("lon")
			val lon: Double,

			@field:SerializedName("lat")
			val lat: Double
		)
	}


	data class WeatherForecastModel(

		@field:SerializedName("dt")
		val dt: Int,

		@field:SerializedName("pop")
		val pop: Double,

		@field:SerializedName("sunrise")
		val sunrise: Int,

		@field:SerializedName("temp")
		val temp: Temp,

		@field:SerializedName("sunset")
		val sunset: Int,

		@field:SerializedName("deg")
		val deg: Int,

		@field:SerializedName("weather")
		val weather: List<WeatherItem>,

		@field:SerializedName("humidity")
		val humidity: Int,

		@field:SerializedName("pressure")
		val pressure: Int,

		@field:SerializedName("clouds")
		val clouds: Int,

		@field:SerializedName("feels_like")
		val feelsLike: FeelsLike,

		@field:SerializedName("speed")
		val speed: Double,

		@field:SerializedName("rain")
		val rain: Double
	) {
		data class FeelsLike(

			@field:SerializedName("eve")
			val eve: Double,

			@field:SerializedName("night")
			val night: Double,

			@field:SerializedName("day")
			val day: Double,

			@field:SerializedName("morn")
			val morn: Double
		)
	}

	data class Temp(

		@field:SerializedName("min")
		val min: Double,

		@field:SerializedName("max")
		val max: Double,

		@field:SerializedName("eve")
		val eve: Double,

		@field:SerializedName("night")
		val night: Double,

		@field:SerializedName("day")
		val day: Double,

		@field:SerializedName("morn")
		val morn: Double
	)

	data class WeatherItem(

		@field:SerializedName("icon")
		val icon: String,

		@field:SerializedName("description")
		val description: String,

		@field:SerializedName("main")
		val main: String,

		@field:SerializedName("id")
		val id: Int
	)
}