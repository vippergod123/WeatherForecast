package com.duyts.weatherforecast

import android.app.Application
import com.duyts.weatherforecast.data.repository.WeatherForecastRepository
import com.duyts.weatherforecast.data.repository.WeatherForecastRepositoryImpl
import com.duyts.weatherforecast.di.networkModule
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class BaseApplication : Application(), KodeinAware {
    private lateinit var application: Application
    override val kodein: Kodein
        get() = Kodein.lazy {
            import(androidXModule(this@BaseApplication))
            bind<WeatherForecastRepository>() with singleton {
                WeatherForecastRepositoryImpl(instance())
            }
            import(networkModule)
        }

    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)
    }
}