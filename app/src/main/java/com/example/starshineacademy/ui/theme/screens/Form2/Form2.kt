package com.example.starshineacademy.ui.theme.screens.Form2

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.starshineacademy.navigation.FORM2RECORDS_URL
import com.example.starshineacademy.navigation.STUDENTSCREEN_URL


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Form2(navController: NavHostController){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        Card(modifier = Modifier.size(300.dp, height = 400.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                var fullname by remember { mutableStateOf("") }
                var guardianname by remember { mutableStateOf("") }
                var guardianphonenumber by remember { mutableStateOf("") }
                var gender by remember { mutableStateOf("") }
                var kcpemarks by remember { mutableStateOf("") }
                val context = LocalContext.current

                Spacer(modifier = Modifier.height(30.dp))

                //---------------------IMAGE PICKER START-----------------------------------//

                var modifier = Modifier
                ImagePicker(modifier,context, navController, fullname.trim(),gender.trim(),guardianname.trim(),guardianphonenumber.trim(),kcpemarks.trim())

                //---------------------IMAGE PICKER END-----------------------------------//
                Spacer(modifier = Modifier.height(20.dp))

                OutlinedTextField(
                    value = fullname,
                    onValueChange = { fullname = it },
                    label = { Text(text = "Enter Your Fullname ") },

                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "person"
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                Spacer(modifier = Modifier.height(30.dp))



                OutlinedTextField(
                    value = kcpemarks,
                    onValueChange = { kcpemarks = it },
                    label = { Text(text = "KCPE Marks") },

                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )

                Spacer(modifier = Modifier.height(30.dp))

                OutlinedTextField(
                    value = gender,
                    onValueChange = { gender = it },
                    label = { Text(text = "Gender") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                )


                OutlinedTextField(
                    value = guardianname,
                    onValueChange = { guardianname = it },
                    label = { Text(text = "Guardian's Fullname ") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "person"
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                Spacer(modifier = Modifier.height(30.dp))

                OutlinedTextField(
                    value = guardianphonenumber,
                    onValueChange = { guardianphonenumber = it },
                    label = { Text(text = "Guardian's PhoneNumber") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = "contact "
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )




                Spacer(modifier = Modifier.height(30.dp))





            }

            Spacer(modifier = Modifier.height(30.dp))


        }

        Spacer(modifier = Modifier.height(40.dp))

        Row {
            Button(onClick = {
                navController.navigate(STUDENTSCREEN_URL)
            },
                Modifier.size(150.dp, height = 50.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(Color.Red)) {
                Text(text = "Cancel")

            }

            Spacer(modifier = Modifier.width(30.dp))

            Button(onClick = {
                navController.navigate(FORM2RECORDS_URL)
            },
                Modifier.size(100.dp, height = 50.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(Color.Green)) {
                Text(text = "Done")

            }


        }




    }

}

@Composable
fun ImagePicker(modifier: Modifier = Modifier, context: Context, navController: NavHostController, fullname:String,gender:String,guardianname:String, guardianphonenumber:String,kcpemarks:String) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier,) {
        if (hasImage && imageUri != null) {
            val bitmap = MediaStore.Images.Media.
            getBitmap(context.contentResolver,imageUri)
            Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp), horizontalAlignment = Alignment.CenterHorizontally,) {

            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },

                ) {
                Text(
                    text = "upload"
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun Form2Preview(){
    Form2(rememberNavController())
}