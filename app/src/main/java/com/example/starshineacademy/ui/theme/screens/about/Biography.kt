package com.example.starshineacademy.ui.theme.screens.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Biography(navController: NavHostController){

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Text(text = "MOTTO:",
            fontSize = 25.sp,
            fontFamily = FontFamily.SansSerif
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "Endeavour to Excel",
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Cursive,
            fontSize = 25.sp)

        Spacer(modifier = Modifier.height(25.dp))

        Text(text = "Mission:",
            fontSize = 25.sp,
            fontFamily = FontFamily.SansSerif)

        Spacer(modifier = Modifier.height(15.dp))

        Card(modifier = Modifier.size(320.dp, height = 250.dp)) {
            Column {
                Text(text =" " ,
                    textAlign = TextAlign.Justify,
                    fontFamily = FontFamily.Cursive,
                    fontSize = 20.sp)
            }
        }


        Spacer(modifier = Modifier.height(25.dp))

        Text(text = "Vision:",
            fontSize = 25.sp,
            fontFamily = FontFamily.SansSerif)

        Spacer(modifier = Modifier.height(15.dp))

        Card(modifier = Modifier.size(320.dp, height = 250.dp)) {
            Column {
                Text(text ="  " ,
                    textAlign = TextAlign.Justify,
                    fontFamily = FontFamily.Cursive,
                    fontSize = 20.sp)
            }
        }

        Box {
            Text(text = "About Institution",
                fontSize = 25.sp,
                fontFamily = FontFamily.SansSerif)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "",
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp)



    }

}

@Preview(showBackground = true)
@Composable
fun BiographyPreview(){

    Biography(rememberNavController())

}