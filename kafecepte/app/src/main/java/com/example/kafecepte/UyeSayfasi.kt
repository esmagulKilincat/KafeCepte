package com.example.kafecepte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.kafecepte.UyeSayfasi
import com.example.kafecepte.databinding.ActivityUyeSayfasiBinding
import com.google.firebase.auth.FirebaseAuth

class UyeSayfasi : AppCompatActivity() {

        lateinit var auth: FirebaseAuth
        lateinit var binding: ActivityUyeSayfasiBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityUyeSayfasiBinding.inflate(layoutInflater)
            setContentView(binding.root)
            auth = FirebaseAuth.getInstance()

            binding.girisbutton.setOnClickListener() {

                var loginemail = binding.editTextTextEmailAddress.text.toString()
                var loginpassword = binding.editTextTextPassword.text.toString()
                if (TextUtils.isEmpty(loginemail)) {
                    binding.editTextTextEmailAddress.error = "Lütfen E-mail adresini doldurunuz"
                    return@setOnClickListener
                } else if (TextUtils.isEmpty(loginpassword)) {
                    binding.editTextTextPassword.error = "Lütfen parolunuzu doldurunuz"
                    return@setOnClickListener
                }



                auth.signInWithEmailAndPassword(loginemail, loginpassword)
                    .addOnCompleteListener(this) {
                        if (it.isSuccessful) {
                            intent = Intent(applicationContext, UyeLoginSayfasi::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(applicationContext, "Hatalı giriş yaptınız", Toast.LENGTH_LONG)
                                .show()
                        }
                    }

            }

            binding.kayitbutton.setOnClickListener(){
                intent= Intent(applicationContext,UyeKayitSayfasi::class.java)
                startActivity(intent)
            }
            binding.sifreunuttumbutton.setOnClickListener(){
                intent= Intent(applicationContext,ParolaSifirlamaSayfasi::class.java)
                startActivity(intent)
            }
        }
    }