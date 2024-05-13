package com.example.starshineacademy.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.starshineacademy.models.Form1
import com.example.starshineacademy.navigation.LOGIN_URL
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class Form1ViewModel(var navController:NavHostController, var context: Context) {
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

    fun Form1(fullname:String,guardianname:String,guardianphonenumber:String,gender:String, kcpemarks:String, filePath:Uri){
        val form1Id = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Form1/$form1Id")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var form1 = Form1(fullname,  guardianname, guardianphonenumber, gender, kcpemarks, filePath)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Form1/$form1Id")
                    databaseRef.setValue(form1).addOnCompleteListener {
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

    fun allForm1Students(
        form1:MutableState<Form1>,
        form1s:SnapshotStateList<Form1>):SnapshotStateList<Form1>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Form1")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                form1s.clear()
                for (snap in snapshot.children){
                    var retrievedForm1 = snap.getValue(Form1::class.java)
                    form1.value = retrievedForm1!!
                    form1s.add(retrievedForm1)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return form1s
    }

    fun deletestudent(form1Id:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Form1/$form1Id")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}