package com.example.kafecepte

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kafecepte.databinding.ActivitySiparisVermelerSayfasiBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SiparisVermelerSayfasi : AppCompatActivity() {
    private lateinit var binding: ActivitySiparisVermelerSayfasiBinding
    private lateinit var  db: FirebaseFirestore

    private lateinit var PostArrayList:ArrayList<siparis>
    private lateinit var feedadapter:siparisadapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySiparisVermelerSayfasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db= Firebase.firestore

        PostArrayList=ArrayList<siparis>()

        getdata()

        binding.siparisrecycler.layoutManager= LinearLayoutManager(this)

        feedadapter= siparisadapter(PostArrayList)
        binding.siparisrecycler.adapter=feedadapter




    }

    private fun getdata() {
        db.collection("Siparisler").orderBy("date",
            Query.Direction.DESCENDING).addSnapshotListener { value, error ->
            if (error!=null){
                Toast.makeText(this,error.localizedMessage, Toast.LENGTH_LONG).show()
            }
            else{
                if (value!=null){
                    if (!value.isEmpty){


                        val documents =   value.documents
                        for (document in documents){

                            val Urunad= document.get("Urunad") as String
                            val fiyat = document.get("fiyat") as String
                            val adet= document.get("adet") as String
                            val tutar= document.get("tutar") as String
                            val id = document.id as String

                            val siparis =siparis(Urunad,adet, fiyat,tutar, id)
                            PostArrayList.add(siparis)


                        }
                        feedadapter.notifyDataSetChanged()
                    }
                }
            }



        }
    }
}