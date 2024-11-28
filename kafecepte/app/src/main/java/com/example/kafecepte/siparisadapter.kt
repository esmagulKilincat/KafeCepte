package com.example.kafecepte

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kafecepte.databinding.CardviewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class siparisadapter(val siparislist: ArrayList<siparis> ): RecyclerView.Adapter<siparisadapter.SiparisHolder>(){
    private lateinit var db : FirebaseFirestore
    private lateinit var auth: FirebaseAuth
    var dbreference: DatabaseReference?=null
    var database: FirebaseDatabase?=null

    class SiparisHolder(val binding: CardviewBinding):RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiparisHolder {

        val binding =CardviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SiparisHolder(binding)


    }

    override fun onBindViewHolder(holder: SiparisHolder, position: Int) {

        val siparis = siparislist[position] // Şu anki siparişi alıyoruz

        holder.binding.adettext.text = siparis.adet
        holder.binding.urunadtext.text = siparis.Urunad
        holder.binding.tutartext.text = siparis.tutar

        holder.binding.button.setOnClickListener {
            if (holder.binding.checkBox.isChecked) {
                // Firestore bağlantısı başlat
                db = Firebase.firestore

                // Firestore'dan siparişi sil
                db.collection("Siparisler") // Koleksiyon adı
                    .document(siparis.id) // Belge id'sini kullanarak silme işlemi
                    .delete()
                    .addOnSuccessListener {
                        Toast.makeText(
                            holder.itemView.context,
                            "Sipariş başarıyla silindi.",
                            Toast.LENGTH_SHORT
                        ).show()

                        // Listeden de kaldır ve RecyclerView'i güncelle
                        siparislist.removeAt(position)
                        notifyDataSetChanged()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(
                            holder.itemView.context,
                            "Hata: ${e.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
            }
        }
    }



    override fun getItemCount(): Int {

        return siparislist.size
    }


    }



