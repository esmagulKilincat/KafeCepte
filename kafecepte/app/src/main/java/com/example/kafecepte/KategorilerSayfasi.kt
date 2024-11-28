package com.example.kafecepte

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kafecepte.databinding.ActivityKategorilerSayfasiBinding

class KategorilerSayfasi : AppCompatActivity() {
    private lateinit var binding: ActivityKategorilerSayfasiBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityKategorilerSayfasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.corbaview.setOnClickListener(){
            intent= Intent(applicationContext,MenuSayfasi::class.java)
            startActivity(intent)
        }

        binding.anayemekview.setOnClickListener(){
            intent= Intent(applicationContext,AnaYemekSayfasi::class.java)
            startActivity(intent)
        }
        binding.salataview.setOnClickListener(){
            intent= Intent(applicationContext,SalatalarSayfasi::class.java)
            startActivity(intent)
        }
        binding.tatliview.setOnClickListener(){
            intent= Intent(applicationContext,TatlilarSayfasi::class.java)
            startActivity(intent)
        }
        binding.sogukicecekview.setOnClickListener(){
            intent= Intent(applicationContext,SogukIceceklerSayfasi::class.java)
            startActivity(intent)
        }
        binding.sicakicicekview.setOnClickListener(){
            intent= Intent(applicationContext,SicakIceceklerSayfasi::class.java)
            startActivity(intent)
        }
    }
}