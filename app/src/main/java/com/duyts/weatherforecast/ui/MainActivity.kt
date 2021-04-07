package com.duyts.weatherforecast.ui

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.duyts.weatherforecast.R
import com.duyts.weatherforecast.ui.base.ScopedActivity
import com.duyts.weatherforecast.ui.weather.ForecastWeatherViewModel
import com.duyts.weatherforecast.ui.weather.ForecastWeatherViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class MainActivity : ScopedActivity() {

//    private lateinit var currentWeatherViewModel: ForecastWeatherViewModel
//    override val kodein by kodein()
//    private val viewModelFactory: ForecastWeatherViewModelFactory by instance()

    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        weatherRecyclerView.layoutManager = linearLayoutManager

//        currentWeatherViewModel =
//                ViewModelProvider(this, viewModelFactory).get(ForecastWeatherViewModel::class.java)

//        bindUI()
    }
//
//    private fun bindUI() = launch {
//        val forecast = currentWeatherViewModel.forecast.await()
//        forecast.observe(this@MainActivity, Observer {
//            if (it == null) return@Observer
//            Log.d("DUYTS", it.toString())
//        })
//    }

}