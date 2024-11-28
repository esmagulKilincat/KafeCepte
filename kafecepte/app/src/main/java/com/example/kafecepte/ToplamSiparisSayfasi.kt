package com.example.kafecepte

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kafecepte.databinding.ActivityToplamSiparisSayfasiBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ToplamSiparisSayfasi : AppCompatActivity() {
    private lateinit var binding: ActivityToplamSiparisSayfasiBinding
    private lateinit var  db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityToplamSiparisSayfasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db= Firebase.firestore



    }
}