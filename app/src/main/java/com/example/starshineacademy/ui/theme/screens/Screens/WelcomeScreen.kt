package com.example.starshineacademy.ui.theme.screens.Screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.starshineacademy.R
import com.example.starshineacademy.navigation.LOGIN_URL
import com.example.starshineacademy.navigation.SIGNUP_URL

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(navController: NavHostController){
    Column (modifier = Modifier
        .fillMaxSize()
        .paint(
            painterResource(id = R.drawable.cop5),
            contentScale = ContentScale.FillBounds,


            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        
        Image(painter = painterResource(id = R.drawable.pic1), contentDescription = "school logo",
            modifier = Modifier.clip(shape = CircleShape)
                .size(200.dp))
        Spacer(modifier = Modifier.height(150.dp))


        Card {

            Column(modifier = Modifier
                .size(300.dp, height = 200.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                Button(onClick = {
                    navController.navigate(LOGIN_URL)
                },
                    Modifier.size(250.dp, height = 45.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(Color.LightGray)) {
                    Text(text = "SIGN IN",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))

                Button(onClick = {
                    navController.navigate(SIGNUP_URL)
                },
                    Modifier.size(250.dp, height = 45.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(Color.LightGray)) {
                    Text(text = "SIGN UP",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                }
            }
        }




    }
}

@Preview
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen(rememberNavController())
}