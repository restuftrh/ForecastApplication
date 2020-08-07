package com.restu.forecastapplication.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.restu.forecastapplication.R
import com.restu.forecastapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.jakartaBtn.setOnClickListener {
            intent = Intent(applicationContext, WeatherDetailActivity::class.java)
            intent.putExtra("id", "1")
            startActivity(intent)
        }

        binding.bandungBtn.setOnClickListener {
            intent = Intent(applicationContext, WeatherDetailActivity::class.java)
            intent.putExtra("id", "2")
            startActivity(intent)
        }

        binding.yogyakartaBtn.setOnClickListener {
            intent = Intent(applicationContext, WeatherDetailActivity::class.java)
            intent.putExtra("id", "3")
            startActivity(intent)
        }

        binding.surabayaBtn.setOnClickListener {
            intent = Intent(applicationContext, WeatherDetailActivity::class.java)
            intent.putExtra("id", "4")
            startActivity(intent)
        }

        binding.medanBtn.setOnClickListener {
            intent = Intent(applicationContext, WeatherDetailActivity::class.java)
            intent.putExtra("id", "5")
            startActivity(intent)
        }

        binding.banjarmasinBtn.setOnClickListener {
            intent = Intent(applicationContext, WeatherDetailActivity::class.java)
            intent.putExtra("id", "6")
            startActivity(intent)
        }

        binding.padangBtn.setOnClickListener {
            intent = Intent(applicationContext, WeatherDetailActivity::class.java)
            intent.putExtra("id", "7")
            startActivity(intent)
        }

    }
}
