package com.example.starshineacademy.ui.theme.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.starshineacademy.R
import com.example.starshineacademy.data.AuthViewModel
import com.example.starshineacademy.navigation.DASHBOARD_URL
import com.example.starshineacademy.navigation.SIGNUP_URL


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController:NavHostController){
    Column(
        modifier = Modifier
            .paint(
                painterResource(id = R.drawable.cop2),
                contentScale = ContentScale.FillBounds
            )
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        
        painterResource(id = R.drawable.pic3)
        Text(
            text = "Login Form",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )
        Spacer(modifier = Modifier.height(30.dp))

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text(text = "Email Address",
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp
            )},
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription ="lock " ) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Password",
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp
            )},
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription ="lock " )},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )

        Spacer(modifier = Modifier.height(150.dp))
        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)

 
        Card {
            Column (modifier = Modifier.size(300.dp, height = 200.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){

                Button(onClick = {
                    authViewModel.login(email, password)
                    navController.navigate(DASHBOARD_URL)

                },
                    Modifier.size(250.dp, height = 50.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(Color.LightGray)
                ) {
                    Text(text = "Login",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(40.dp))

                Button(onClick = {
                    navController.navigate(SIGNUP_URL)
                },
                    Modifier.size(250.dp, height = 50.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(Color.LightGray)) {
                    Text(text = "Click to create an Account",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                }
            }

        }

    }
}

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview(){

        LoginScreen(navController = rememberNavController())

}