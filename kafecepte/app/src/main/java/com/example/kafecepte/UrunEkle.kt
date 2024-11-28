package com.example.kafecepte

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kafecepte.databinding.ActivityUrunEkleBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.ktx.Firebase
import java.util.UUID
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage

class UrunEkle : AppCompatActivity() {



    lateinit var binding: ActivityUrunEkleBinding
    private lateinit var storage: FirebaseStorage
    private lateinit var firebaseFireStore: FirebaseFirestore
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    private lateinit var permissionLauncher: ActivityResultLauncher<String>


    private var imageuri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUrunEkleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseFireStore = Firebase.firestore
        storage = Firebase.storage
        //inItVars()
        binding.buttonyukle.setOnClickListener(){
            registerClickEvents()
        }


    }


    private fun registerClickEvents() {


        binding.radiogrup.setOnCheckedChangeListener { radioGroup, i ->

            if (i!=null){
                if (binding.corbabutton.isChecked){
                    val downloadUrl = binding.etResimURL.text.toString()

                    val postMap = hashMapOf<String, Any>()
                    postMap.put("downloadUrl", downloadUrl)
                    postMap.put("Fiyat",binding.etMenuAd2.text.toString())
                    postMap.put("Urunad", binding.etMenuAd.text.toString())
                    postMap.put("Urunicindekiler",binding.eturunicindekiler.text.toString())


                    binding.buttonyukle.setOnClickListener(){
                        firebaseFireStore.collection("Dondurmalar").add(postMap).addOnCompleteListener() {task->
                            if (task.isComplete && task.isSuccessful) {
                                Toast.makeText(
                                    this@UrunEkle,
                                    "Menüye Eklendi",
                                    Toast.LENGTH_LONG
                                ).show()
                                finish()
                            }

                        }.addOnFailureListener {
                            Toast.makeText(
                                this@UrunEkle,
                                it.localizedMessage,
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    }
                }
                else if (binding.anayemekbutton.isChecked){
                    val downloadUrl = binding.etResimURL.text.toString()

                    val postMap = hashMapOf<String, Any>()
                    postMap.put("downloadUrl", downloadUrl)
                    postMap.put("Fiyat",binding.etMenuAd2.text.toString())
                    postMap.put("Urunad", binding.etMenuAd.text.toString())
                    postMap.put("Urunicindekiler",binding.eturunicindekiler.text.toString())


                    binding.buttonyukle.setOnClickListener(){
                        firebaseFireStore.collection("Smoothieler").add(postMap).addOnCompleteListener() {task->
                            if (task.isComplete && task.isSuccessful) {
                                Toast.makeText(
                                    this@UrunEkle,
                                    "Menüye Eklendi",
                                    Toast.LENGTH_LONG
                                ).show()
                                finish()
                            }

                        }.addOnFailureListener {
                            Toast.makeText(
                                this@UrunEkle,
                                it.localizedMessage,
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    }

                }
                else if (binding.salatabutton.isChecked){
                    val downloadUrl = binding.etResimURL.text.toString()

                    val postMap = hashMapOf<String, Any>()
                    postMap.put("downloadUrl", downloadUrl)
                    postMap.put("Fiyat",binding.etMenuAd2.text.toString())
                    postMap.put("Urunad", binding.etMenuAd.text.toString())
                    postMap.put("Urunicindekiler",binding.eturunicindekiler.text.toString())


                    binding.buttonyukle.setOnClickListener(){
                        firebaseFireStore.collection("SoğukKahveler").add(postMap).addOnCompleteListener() {task->
                            if (task.isComplete && task.isSuccessful) {
                                Toast.makeText(
                                    this@UrunEkle,
                                    "Menüye Eklendi",
                                    Toast.LENGTH_LONG
                                ).show()
                                finish()
                            }

                        }.addOnFailureListener {
                            Toast.makeText(
                                this@UrunEkle,
                                it.localizedMessage,
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    }
                }
                else if (binding.tatlibutton.isChecked){
                    val downloadUrl = binding.etResimURL.text.toString()

                    val postMap = hashMapOf<String, Any>()
                    postMap.put("downloadUrl", downloadUrl)
                    postMap.put("Fiyat",binding.etMenuAd2.text.toString())
                    postMap.put("Urunad", binding.etMenuAd.text.toString())
                    postMap.put("Urunicindekiler",binding.eturunicindekiler.text.toString())


                    binding.buttonyukle.setOnClickListener(){
                        firebaseFireStore.collection("SıcakKahveler").add(postMap).addOnCompleteListener() {task->
                            if (task.isComplete && task.isSuccessful) {
                                Toast.makeText(
                                    this@UrunEkle,
                                    "Menüye Eklendi",
                                    Toast.LENGTH_LONG
                                ).show()
                                finish()
                            }

                        }.addOnFailureListener {
                            Toast.makeText(
                                this@UrunEkle,
                                it.localizedMessage,
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    }
                }
                else if (binding.sogukicecekbutton.isChecked){
                    val downloadUrl = binding.etResimURL.text.toString()

                    val postMap = hashMapOf<String, Any>()
                    postMap.put("downloadUrl", downloadUrl)
                    postMap.put("Fiyat",binding.etMenuAd2.text.toString())
                    postMap.put("Urunad", binding.etMenuAd.text.toString())
                    postMap.put("Urunicindekiler",binding.eturunicindekiler.text.toString())


                    binding.buttonyukle.setOnClickListener(){
                        firebaseFireStore.collection("Tatlılar").add(postMap).addOnCompleteListener() {task->
                            if (task.isComplete && task.isSuccessful) {
                                Toast.makeText(
                                    this@UrunEkle,
                                    "Menüye Eklendi",
                                    Toast.LENGTH_LONG
                                ).show()
                                finish()
                            }

                        }.addOnFailureListener {
                            Toast.makeText(
                                this@UrunEkle,
                                it.localizedMessage,
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    }
                }
                else if (binding.sCakicecekbutton.isChecked){
                    val downloadUrl = binding.etResimURL.text.toString()

                    val postMap = hashMapOf<String, Any>()
                    postMap.put("downloadUrl", downloadUrl)
                    postMap.put("Fiyat",binding.etMenuAd2.text.toString())
                    postMap.put("Urunad", binding.etMenuAd.text.toString())
                    postMap.put("Urunicindekiler",binding.eturunicindekiler.text.toString())


                    binding.buttonyukle.setOnClickListener(){
                        firebaseFireStore.collection("Çaylar").add(postMap).addOnCompleteListener() {task->
                            if (task.isComplete && task.isSuccessful) {
                                Toast.makeText(
                                    this@UrunEkle,
                                    "Menüye Eklendi",
                                    Toast.LENGTH_LONG
                                ).show()
                                finish()
                            }

                        }.addOnFailureListener {
                            Toast.makeText(
                                this@UrunEkle,
                                it.localizedMessage,
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    }

                }



            }
            else{
                Toast.makeText(this,"Lütfen Seçeneklerden Birini Seçiniz", Toast.LENGTH_LONG).show()
            }

        }



    }
}