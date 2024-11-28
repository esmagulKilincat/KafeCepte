package com.example.kafecepte

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kafecepte.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       //  fetchWeatherData()

        binding.girisuyebutton.setOnClickListener(){

            intent= Intent(applicationContext,UyeSayfasi::class.java)
            startActivity(intent)


        }
        binding.restorangirisbutton.setOnClickListener(){
            intent= Intent(applicationContext,AdminGirisSayfasi::class.java)
            startActivity(intent)
        }

    }

    private fun fetchWeatherData() {
        CoroutineScope(Dispatchers.IO).launch {
            println("Fetching weather data...")
            val temperature = WeatherService.fetchWeather()

            withContext(Dispatchers.Main) {
                if (temperature != null) {
                    println("Weather data received: $temperature")
                    binding.havaSicaklikText.text = "Hava Sıcaklığı: $temperature°C"
                } else {
                    println("Weather data fetch failed!")
                    binding.havaSicaklikText.text = "Hava durumu alınamadı!"
                }
            }
        }
    }

}