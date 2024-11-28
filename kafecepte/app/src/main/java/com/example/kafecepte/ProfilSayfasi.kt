package com.example.kafecepte

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kafecepte.databinding.ActivityProfilSayfasiBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfilSayfasi : AppCompatActivity() {

    lateinit var binding: ActivityProfilSayfasiBinding
    private lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference?=null
    var database: FirebaseDatabase?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProfilSayfasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth= FirebaseAuth.getInstance()
        database= FirebaseDatabase.getInstance()
        databaseReference=database?.reference!!.child("Kayıtlar")

        var currentUser=auth.currentUser
        binding.etEmailguncelle.setText(currentUser?.email)

        var userReference = databaseReference?.child(currentUser?.uid!!)
        userReference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                binding.etadsoyadguncelle.setText(snapshot.child("adisoyadi").value.toString())
                binding.etphoneguncelle.setText(snapshot.child("Telephone").value.toString())

            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
        //bilgileri güncelleme
        binding.button2.setOnClickListener(){
            var guncelleemail = binding.etEmailguncelle.text.toString().trim()
            currentUser!!.updateEmail(guncelleemail)
                .addOnCompleteListener{
                    if (it.isSuccessful){
                        Toast.makeText(this@ProfilSayfasi,"E-mailiniz güncellendi", Toast.LENGTH_LONG).show()
                    }
                    else{
                        Toast.makeText(this@ProfilSayfasi,"Mailiniz güncellenemedi", Toast.LENGTH_LONG).show()
                    }
                }
            //Parola güncelleme
            if (binding.etpasswordguncelle.text.toString()==binding.etpasswordcheckguncelle.toString()){
                var parolaGuncelle = binding.etpasswordguncelle.text.toString().trim()
                currentUser!!.updatePassword(parolaGuncelle)
                    .addOnCompleteListener{
                        if (it.isSuccessful){
                            Toast.makeText(this@ProfilSayfasi,"Parolanız güncellendi", Toast.LENGTH_LONG).show()
                        }
                        else{
                            Toast.makeText(this@ProfilSayfasi,"Parolanız güncellenemedi", Toast.LENGTH_LONG).show()
                        }

                    }
            }


            //ad-soyad güncelleme
            var currentUserDb =
                currentUser?.let { it1 -> databaseReference?.child(it1.uid) }
            currentUserDb?.removeValue()

            currentUserDb?.child("adisoyadi")
                ?.setValue(binding.etadsoyadguncelle.text.toString())
            currentUserDb?.child("Telephone")
                ?.setValue(binding.etphoneguncelle.text.toString())

            currentUserDb?.child("Mail")
                ?.setValue(binding.etEmailguncelle.text.toString())
            currentUserDb?.child("Password")
                ?.setValue(binding.etpasswordguncelle.text.toString())
            Toast.makeText(this@ProfilSayfasi,"bilgileriniz  güncellendi", Toast.LENGTH_LONG).show()
        }
    }
}