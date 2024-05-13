package com.example.starshineacademy.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.starshineacademy.models.Form4
import com.example.starshineacademy.navigation.LOGIN_URL
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class Form4ViewModel(var navController:NavHostController, var context: Context) {
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

    fun Form4(fullname:String,guardianname:String,guardianphonenumber:String,gender:String, kcpemarks:String, filePath:Uri){
        val form4Id = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Form4/$form4Id")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var form4 = Form4(fullname,  guardianname, guardianphonenumber, gender, kcpemarks, filePath)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Form4/$form4Id")
                    databaseRef.setValue(form4).addOnCompleteListener {
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

    fun allForm4Students(
        form4:MutableState<Form4>,
        form4s:SnapshotStateList<Form4>):SnapshotStateList<Form4>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Form4")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                form4s.clear()
                for (snap in snapshot.children){
                    var retrievedForm4 = snap.getValue(Form4::class.java)
                    form4.value = retrievedForm4!!
                    form4s.add(retrievedForm4)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return form4s
    }

    fun deleteForm4(form4Id:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Form4/$form4Id")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}