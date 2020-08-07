package com.restu.forecastapplication.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.restu.forecastapplication.service.RetrofitManager
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class WeatherRepository {

    private val apiService = RetrofitManager.apiService

    val usersSuccessLiveData = MutableLiveData<Weather>()
    val usersFailureLiveData = MutableLiveData<Boolean>()

    /*
    this fun is suspend fun means it will execute in different thread
     */
    suspend fun getWeather(q : String) {
        try {

            val response = apiService.getWeather(q,"275e7fb5868c589065d21086d2eb1170")

            Log.d(TAG, "$response")

            if (response.isSuccessful) {
                Log.d(TAG, "SUCCESS")
                Log.d(TAG, "${response.body()}")
                usersSuccessLiveData.postValue(response.body())

            } else {
                Log.d(TAG, "FAILURE")
                Log.d(TAG, "${response.body()}")
                usersFailureLiveData.postValue(true)
            }

        } catch (e: UnknownHostException) {
            Log.e(TAG, e.message)
            //this exception occurs when there is no internet connection or host is not available
            //so inform user that something went wrong
            usersFailureLiveData.postValue(true)
        } catch (e: SocketTimeoutException) {
            Log.e(TAG, e.message)
            //this exception occurs when time out will happen
            //so inform user that something went wrong
            usersFailureLiveData.postValue(true)
        } catch (e: Exception) {
            Log.e(TAG, e.message)
            //this is generic exception handling
            //so inform user that something went wrong
            usersFailureLiveData.postValue(true)
        }

    }

    companion object {
        val TAG = WeatherRepository::class.java.simpleName
    }
}