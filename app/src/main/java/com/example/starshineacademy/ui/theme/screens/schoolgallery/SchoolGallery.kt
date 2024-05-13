package com.example.starshineacademy.ui.theme.screens.schoolgallery

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.starshineacademy.R

@Composable
fun SchoolGallery(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {

        Text(
            text = "Gallery",
            fontSize = 45.sp,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(45.dp))

        Text(
            text = "Students",
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier
                .padding(15.dp, end = 15.dp)
                .size(300.dp, height = 170.dp)
        ) {
            Column(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.teachers7),
                        contentDescription = "st"
                    )

                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.teachers8),
                        contentDescription = "st"
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.teacher),
                        contentDescription = "te"
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.teachers13),
                        contentDescription = "st"
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.teachers14),
                        contentDescription = "st"
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                }

            }
        }


        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Teaching Staff",
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .size(350.dp, height = 100.dp)
        ) {
            Card(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .size(300.dp, height = 170.dp)
            ) {
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.teachers2),
                            contentDescription = "st"
                        )

                        Spacer(modifier = Modifier.width(10.dp))
                        Image(
                            painter = painterResource(id = R.drawable.teachers15),
                            contentDescription = "st"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Image(
                            painter = painterResource(id = R.drawable.teachers16),
                            contentDescription = "te"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Image(
                            painter = painterResource(id = R.drawable.teachers3),
                            contentDescription = "st"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Image(
                            painter = painterResource(id = R.drawable.teachers4),
                            contentDescription = "st"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }

            }
        }


    Spacer(modifier = Modifier.height(25.dp))

        Text(text = "School Compound",
            fontSize = 25.sp,
            textAlign = TextAlign.Center)

    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .size(350.dp, height = 100.dp)
    ) {
        Card(
            modifier = Modifier
                .padding(start = 15.dp)
                .size(300.dp, height = 170.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.images1),
                        contentDescription = "st"
                    )

                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.images13),
                        contentDescription = "st"
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                }
            }

        }
    }

}

}







@Preview(showBackground = true)
@Composable
fun SchoolGalleryPreview(){
    SchoolGallery(rememberNavController())
}