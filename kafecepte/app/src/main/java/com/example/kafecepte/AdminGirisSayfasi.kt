package com.example.kafecepte

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kafecepte.databinding.ActivityAdminGirisSayfasiBinding
import com.google.firebase.auth.FirebaseAuth

class AdminGirisSayfasi : AppCompatActivity() {
    lateinit var auth: FirebaseAuth

    lateinit var binding: ActivityAdminGirisSayfasiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminGirisSayfasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        binding.girisbutton2.setOnClickListener() {

            var loginemail = binding.editTextTextEmailAddress3.text.toString()
            var loginpassword = binding.editTextTextPassword2.text.toString()
            if (TextUtils.isEmpty(loginemail)) {
                binding.editTextTextEmailAddress3.error = "Lütfen E-mail adresini doldurunuz"
                return@setOnClickListener
            } else if (TextUtils.isEmpty(loginpassword)) {
                binding.editTextTextPassword2.error = "Lütfen parolunuzu doldurunuz"
                return@setOnClickListener
            }
            if (loginemail=="esmg.2882@gmail.com"&&loginpassword=="esma123"){
                intent= Intent(applicationContext,AdminSayfa::class.java)
                startActivity(intent)

            }else{
                Toast.makeText(this@AdminGirisSayfasi,"Yanlış Giriş Yaptınız", Toast.LENGTH_LONG).show()
            }


        }



    }
}