package com.example.kafecepte

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kafecepte.databinding.ActivityAdminSayfaBinding

class AdminSayfa : AppCompatActivity() {
    lateinit var binding: ActivityAdminSayfaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminSayfaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView2.setOnClickListener(){
            intent= Intent(applicationContext,UrunEkle::class.java)
            startActivity(intent)
        }
        binding.imageView3.setOnClickListener(){
            intent= Intent(applicationContext,SiparisVermelerSayfasi::class.java)
            startActivity(intent)
        }

    }
}