package com.example.starshineacademy.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.starshineacademy.models.Form2
import com.example.starshineacademy.navigation.LOGIN_URL
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class Form2ViewModel(var navController:NavHostController, var context: Context) {
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

    fun Form2(fullname:String,guardianname:String,guardianphonenumber:String,gender:String, kcpemarks:String, filePath:Uri){
        val form2Id = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Form2/$form2Id")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var form2 = Form2(fullname,  guardianname, guardianphonenumber, gender, kcpemarks, filePath)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Form2/$form2Id")
                    databaseRef.setValue(form2).addOnCompleteListener {
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

    fun allForm2Students(
        form2:MutableState<Form2>,
        form2s:SnapshotStateList<Form2>):SnapshotStateList<Form2>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Form2")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                form2s.clear()
                for (snap in snapshot.children){
                    var retrievedForm2 = snap.getValue(Form2::class.java)
                    form2.value = retrievedForm2!!
                    form2s.add(retrievedForm2)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return form2s
    }

    fun deleteForm2(form2Id:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Form2/$form2Id")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}