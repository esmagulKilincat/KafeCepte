package com.example.kafecepte

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kafecepte.databinding.ActivityParolaSifirlamaSayfasiBinding
import com.google.firebase.auth.FirebaseAuth

class ParolaSifirlamaSayfasi : AppCompatActivity() {
    lateinit var binding:ActivityParolaSifirlamaSayfasiBinding
    private lateinit var  auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityParolaSifirlamaSayfasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth= FirebaseAuth.getInstance()

        binding.sifresifirlabutton.setOnClickListener{
            var parolasıfırlamail = binding.editTextTextEmailAddress2.text.toString().trim()
            if(TextUtils.isEmpty((parolasıfırlamail)))
            {
                binding.editTextTextEmailAddress2.error="Lütfen e-mail adresinizi yazınız."
            }
            else
            {
                auth.sendPasswordResetEmail(parolasıfırlamail)
                    .addOnCompleteListener(this){ sifirlama ->
                        if(sifirlama.isSuccessful){
                            binding.textView2.text="e-mail adresinize sıfırlama bağlantısı gönderildi, lütfen kontrol ediniz."
                        }
                        else
                        {
                            binding.textView2.text="Sıfırlama Gerçekleştirilemedi"
                        }
                    }
            }
        }

        //Giriş sayfasına gitmek için
        binding.geridonbutton.setOnClickListener{
            intent= Intent(applicationContext,UyeSayfasi::class.java)
            startActivity(intent)
            finish()
        }

    }
}