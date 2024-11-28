package com.example.kafecepte

import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

object WeatherService {

    private const val API_URL = "https://yahoo-weather5.p.rapidapi.com/weather?lat=40.821444&long=29.91725&format=json&u=c"
    private const val API_KEY = "2f7adefb55msh0f3ff4f99867aa2p191beajsna80263a4bf97"

    fun fetchWeather(): String? {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(API_URL)
            .get()
            .addHeader("x-rapidapi-key", API_KEY)
            .addHeader("x-rapidapi-host", "yahoo-weather5.p.rapidapi.com")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                println("API Response Error: ${response.code}")
                return null
            }

            val responseBody = response.body!!.string()
            println("API Response: $responseBody") // Yanıtı konsola yazdır

            val jsonResponse = JSONObject(responseBody)
            val temperature = jsonResponse
                .getJSONObject("current_observation")
                .getJSONObject("condition")
                .getInt("temperature")

            return temperature.toString()
        }
    }

}
