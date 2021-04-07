package com.duyts.weatherforecast.data.network

import android.content.Context
import android.net.ConnectivityManager
import com.duyts.weatherforecast.internal.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

class ConnectivityInterceptorImpl(context: Context) : ConnectivityInterceptor {
    private val applicationContext = context.applicationContext;

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isOnline()) {
            throw NoConnectivityException()
        }
        else {
            return chain.proceed(chain.request())
        }
    }


    private fun isOnline():Boolean {
       val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
       val networkInfo = connectivityManager.activeNetworkInfo
       return networkInfo != null && networkInfo.isConnected
    }
}