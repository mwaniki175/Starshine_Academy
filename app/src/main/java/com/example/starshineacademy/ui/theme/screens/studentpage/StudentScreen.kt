package com.example.starshineacademy.ui.theme.screens.studentpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.starshineacademy.R
import com.example.starshineacademy.navigation.FORM1RECORDS_URL
import com.example.starshineacademy.navigation.FORM2RECORDS_URL
import com.example.starshineacademy.navigation.FORM3RECORDS_URL
import com.example.starshineacademy.navigation.FORM4RECORDS_URL
import com.example.starshineacademy.navigation.LOGIN_URL


@Composable
fun StudentScreen(navController: NavHostController){
    Column(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier
            .size(400.dp, height = 250.dp)
            .fillMaxWidth()
            .paint(
                painterResource(id = R.drawable.img),
                contentScale = ContentScale.FillBounds
            )) {



        }




        Card(modifier = Modifier.size(400.dp, height = 700.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){

                Card(modifier = Modifier.size(300.dp, height = 100.dp),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Column(modifier = Modifier.clickable {
                        navController.navigate(FORM1RECORDS_URL)
                    }
                        .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        ) {


                        Text(text = "Form One",
                            fontSize = 40.sp,
                            fontFamily = FontFamily.SansSerif)

                    }

                }

                Spacer(modifier = Modifier.height(20.dp))

                Card(modifier = Modifier.size(300.dp, height = 100.dp),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Column(modifier = Modifier.clickable { navController.navigate(FORM2RECORDS_URL) }
                        .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {


                        Text(text = "Form Two",
                            fontSize = 40.sp,
                            fontFamily = FontFamily.SansSerif)

                    }

                }
                Spacer(modifier = Modifier.height(20.dp))

                Card(modifier = Modifier.size(300.dp, height = 100.dp),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Column(modifier = Modifier.clickable {
                        navController.navigate(FORM3RECORDS_URL)

                    }
                        .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {


                        Text(text = "Form Three",
                            fontSize = 40.sp,
                            fontFamily = FontFamily.SansSerif)

                    }

                }

                Spacer(modifier = Modifier.height(20.dp))
                Card(modifier = Modifier.size(300.dp, height = 100.dp),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Column(modifier = Modifier.clickable { navController.navigate(FORM4RECORDS_URL) }
                        .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {


                        Text(text = "Form Four",
                            fontSize = 40.sp,
                            fontFamily = FontFamily.SansSerif)

                    }

                }






            }

        }







    }
}

@Preview(showBackground = true)
@Composable
fun StudentScreenPreview(){
    StudentScreen(rememberNavController())
}