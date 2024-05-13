package com.example.starshineacdemy.ui.theme.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.starshineacademy.navigation.ABOUT_URL
import com.example.starshineacademy.navigation.CONTACT_URL
import com.example.starshineacademy.navigation.GALLERY_URL
import com.example.starshineacademy.navigation.STUDENTSCREEN_URL


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(navController: NavHostController) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
    ) {
        
        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
                .size(450.dp, height = 100.dp)
        ) {
            Spacer(modifier = Modifier.width(20.dp))
            Row(
                modifier = Modifier.padding(15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dashboardicon),
                    contentDescription = "dashboardicon",
                    modifier = Modifier.size(70.dp)
                )

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = "STARSHINE",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 45.sp
                )
            }


        }

        Text(text = "Welcome to Starshine Academy,the best Content provider",
            fontSize = 25.sp,
            fontFamily = FontFamily.Cursive,
            modifier = Modifier.padding(20.dp, end = 20.dp),
            textAlign = TextAlign.Justify)
        
        Spacer(modifier = Modifier.height(25.dp))
        
        Card (modifier = Modifier.size(500.dp, height = 200.dp)){
            
            Column(modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

                Row {

                    Image(painter = painterResource(id = R.drawable.x1), contentDescription = "dis",
                        modifier = Modifier.size(200.dp))
                    Spacer(modifier = Modifier.width(15.dp))
                    Image(painter = painterResource(id = R.drawable.x2), contentDescription = "dis",
                        modifier = Modifier.size(200.dp))
                    Spacer(modifier = Modifier.width(15.dp))
                    Image(painter = painterResource(id = R.drawable.x3), contentDescription = "dis",
                        modifier = Modifier.size(200.dp))
                    Spacer(modifier = Modifier.width(15.dp))
                    Image(painter = painterResource(id = R.drawable.x4), contentDescription = "dis",
                        modifier = Modifier.size(200.dp))
                    Spacer(modifier = Modifier.width(15.dp))
                    Image(painter = painterResource(id = R.drawable.x5), contentDescription = "dis",
                        modifier = Modifier.size(200.dp))
                    Spacer(modifier = Modifier.width(15.dp))

                }
            }
            
        }


        Spacer(modifier = Modifier.height(40.dp))
//Row1
        Row {
            //card1
            Spacer(modifier = Modifier.padding(10.dp))
            Card (modifier = Modifier.size(170.dp, height = 80.dp),
                ){
                Row(modifier = Modifier
                    .clickable {
                        navController.navigate(STUDENTSCREEN_URL)
                    }
                    .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    
                    Image(painter = painterResource(id = R.drawable.students), contentDescription = "Student")

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(text = "Student",
                        fontSize = 20.sp)

                }
            }
            
            //End of card1

            //card1
            Spacer(modifier = Modifier.width(20.dp))
            Card (modifier = Modifier
                .clickable {
                    navController.navigate(GALLERY_URL)
                }
                .size(170.dp, height = 80.dp),
            ){
                Row(modifier = Modifier.padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {

                    Image(painter = painterResource(id = R.drawable.gal), contentDescription = "gallery")

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(text = "School Gallery",
                        fontSize = 20.sp)

                }
            }

            //End of card1

        }
//End of row1

Spacer(modifier = Modifier.height(25.dp))



//End of row2

        Spacer(modifier = Modifier.height(25.dp))

        //Row3
        Row {
            //card1
            Spacer(modifier = Modifier.padding(10.dp))

            Card (modifier = Modifier
                .clickable {
                    navController.navigate(ABOUT_URL)
                }
                .size(170.dp, height = 80.dp),
            ){
                Row(modifier = Modifier
                    .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {

                    Image(painter = painterResource(id = R.drawable.ab), contentDescription = "about")

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(text = "About",
                        fontSize = 20.sp)

                }
            }

            //End of card1

            //card2
            Spacer(modifier = Modifier.width(20.dp))
            Card (modifier = Modifier
                .clickable {
                    navController.navigate(CONTACT_URL)
                }
                .size(170.dp, height = 80.dp)
            ){
                Row(modifier = Modifier.padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {

                    Image(painter = painterResource(id = R.drawable.contact), contentDescription = "contact")

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(text = "Contact",
                        fontSize = 20.sp)

                }
            }

            //End of card2

        }
//End of row3




    }
}

@Preview(showBackground = true)
@Composable
fun DashboardPreview(){
    Dashboard(rememberNavController())
}

