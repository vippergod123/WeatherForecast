package com.duyts.weatherforecast.di

import com.duyts.weatherforecast.data.network.*
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton


private const val MODULE_NAME = "Network Module"



val networkModule = Kodein.Module(MODULE_NAME, false) {

    bind() from singleton { WeatherApiService(instance()) }
    bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
    bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }

}