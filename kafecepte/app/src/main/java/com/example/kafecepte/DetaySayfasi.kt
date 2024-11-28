package com.example.kafecepte

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kafecepte.databinding.ActivityDetaysayfasiBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DetaySayfasi : AppCompatActivity() {
    lateinit var binding: ActivityDetaysayfasiBinding
    private lateinit var firebaseFireStore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetaysayfasiBinding.inflate(layoutInflater)

        setContentView(binding.root)
        firebaseFireStore = Firebase.firestore
        val intent = intent
        var Fiyat = intent.getStringExtra("Fiyat")
        var Urunicerigi = intent.getStringExtra("Urunicerigi")
        var Urunad = intent.getStringExtra("Urunad")

        binding.txtFiyat.text = Fiyat.toString()

        binding.txtUrunicerik2.text = Urunicerigi.toString()
        binding.txtUrunAd.text = Urunad.toString()
        var siparisfiyati = binding.txtFiyat.text.toString().toInt()




        binding.button3.setOnClickListener() {
            if (binding.editTextTextPersonName.text.isNullOrEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Lütfen sipariş adedi giriniz",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                var siparisadedi = binding.editTextTextPersonName.text.toString().toInt()
                var Urunad = binding.txtUrunAd.text.toString()


                var siparistoplami = siparisadedi * siparisfiyati
                val postMap = hashMapOf<String, Any>()

                postMap.put("tutar", siparistoplami.toString())
                postMap.put("adet", siparisadedi.toString())
                postMap.put("fiyat", siparisfiyati.toString())
                postMap.put("Urunad", Urunad)
                postMap.put("date", com.google.firebase.Timestamp.now())




                firebaseFireStore.collection("Siparisler").add(postMap)
                    .addOnCompleteListener() { task ->
                        if (task.isComplete && task.isSuccessful) {

                            finish()
                        }

                    }.addOnFailureListener {
                        Toast.makeText(
                            this@DetaySayfasi,
                            it.localizedMessage,
                            Toast.LENGTH_LONG
                        ).show()
                    }
            }


        }
    }
}
