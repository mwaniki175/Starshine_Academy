package com.example.starshineacademy.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.starshineacademy.models.Form3
import com.example.starshineacademy.navigation.LOGIN_URL
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class Form3ViewModel(var navController:NavHostController, var context: Context) {
    var authViewModel:AuthViewModel
    var progress:ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(LOGIN_URL)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun Form3(fullname:String,guardianname:String,guardianphonenumber:String,gender:String, kcpemarks:String, filePath:Uri){
        val form3Id = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Form3/$form3Id")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var form3 = Form3(fullname,  guardianname, guardianphonenumber, gender, kcpemarks, filePath)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Form3/$form3Id")
                    databaseRef.setValue(form3).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun allForm3Students(
        form3:MutableState<Form3>,
        form3s:SnapshotStateList<Form3>):SnapshotStateList<Form3>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Form3")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                form3s.clear()
                for (snap in snapshot.children){
                    var retrievedForm3 = snap.getValue(Form3::class.java)
                    form3.value = retrievedForm3!!
                    form3s.add(retrievedForm3)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return form3s
    }

    fun deleteForm3(form3Id:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Form3/$form3Id")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}