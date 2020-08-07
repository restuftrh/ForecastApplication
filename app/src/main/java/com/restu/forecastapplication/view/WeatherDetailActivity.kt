package com.restu.forecastapplication.view

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import com.restu.forecastapplication.R
import com.restu.forecastapplication.databinding.ActivityDetailWeatherBinding
import com.restu.forecastapplication.model.utils.unixTimestampToDateTimeString
import com.restu.forecastapplication.viewmodel.WeatherActivityViewModel
import retrofit2.Response
import java.security.cert.Extension
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.Observer



class WeatherDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailWeatherBinding
    private lateinit var weatherActivityViewModel: WeatherActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_weather)
        weatherActivityViewModel =
            ViewModelProviders.of(this).get(WeatherActivityViewModel::class.java)

        registerObservers()

        weatherActivityViewModel.getWeather(intent.getStringExtra("id")

        )

    }

    private fun registerObservers() {

        weatherActivityViewModel.usersSuccessLiveData.observe(this, androidx.lifecycle.Observer {
            val temp = it.list[0].main.temp - 273.15
            binding.cityName.text = "Weather for ${it.city.name}, Indonesia"
            binding.temp.text = "${temp.toInt().toString()} C"
            binding.date.text = it.list[0].dt_txt
            binding.temp2.text = ": ${temp.toInt().toString()} C"
            binding.condition.text = ": " + it.list[0].weather[0].description
            binding.lat.text = ": " +it.city.coord.lat.toString()
            binding.lon.text = ": " +it.city.coord.lon.toString()
            binding.sunrise.text = it.city.sunrise.toString()
            binding.sunset.text = it.city.sunset.toString()

            val temp2 = it.list[1].main.temp - 273.15
            val temp3 = it.list[2].main.temp - 273.15
            val temp4 = it.list[3].main.temp - 273.15
            val temp5 = it.list[4].main.temp - 273.15

            binding.dateTime.text = it.list[1].dt_txt
            binding.dateTime2.text = it.list[2].dt_txt
            binding.dateTime3.text = it.list[3].dt_txt
            binding.dateTime4.text = it.list[4].dt_txt
            binding.tempAndCondition.text = "${temp2.toInt().toString()}'C - ${it.list[1].weather[0].description}"
            binding.tempAndCondition2.text = "${temp3.toInt().toString()}'C - ${it.list[2].weather[0].description}"
            binding.tempAndCondition3.text = "${temp4.toInt().toString()}'C - ${it.list[3].weather[0].description}"
            binding.tempAndCondition4.text = "${temp5.toInt().toString()}'C - ${it.list[4].weather[0].description}"

            if (it.list[0].weather[0].main == "Clouds"){
                binding.cloudMain.setImageResource(R.drawable.ic_cloudy)
            }else{
                binding.cloudMain.setImageResource(R.drawable.ic_rain)
            }

            if (it.list[1].weather[0].main == "Clouds"){
                binding.cloud.setImageResource(R.drawable.ic_cloudy)
            }else{
                binding.cloud.setImageResource(R.drawable.ic_rain)
            }

            if (it.list[2].weather[0].main == "Clouds"){
                binding.cloud2.setImageResource(R.drawable.ic_cloudy)
            }else{
                binding.cloud2.setImageResource(R.drawable.ic_rain)
            }

            if (it.list[3].weather[0].main == "Clouds"){
                binding.cloud3.setImageResource(R.drawable.ic_cloudy)
            }else{
                binding.cloud3.setImageResource(R.drawable.ic_rain)
            }

            if (it.list[4].weather[0].main == "Clouds"){
                binding.cloud4.setImageResource(R.drawable.ic_cloudy)
            }else{
                binding.cloud4.setImageResource(R.drawable.ic_rain)
            }

        })


    }


}

