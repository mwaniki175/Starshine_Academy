package com.example.starshineacademy.ui.theme.screens.contactscreen

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.starshineacademy.R

@Composable
fun Contact(navController: NavHostController){

    Column(modifier = Modifier.fillMaxSize()) {

        val mContext = LocalContext.current

        Card(modifier = Modifier.size(500.dp,
            height = 250.dp)) {
            Column (modifier = Modifier
                .fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.cont),
                    contentScale = ContentScale.FillBounds
                )) {
                Spacer(modifier = Modifier.height(20.dp))
            }




        }

        Text(text = "You can reach us through the following",
            fontFamily = FontFamily.Cursive,
            fontSize = 25.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(15.dp, end = 15.dp))
        
        Spacer(modifier = Modifier.height(35.dp))

        Card (modifier = Modifier
            .paint(
                painterResource(id = R.drawable.white),
                contentScale = ContentScale.FillBounds
            )
            .size(500.dp, height = 600.dp)){

                //Row1

            Spacer(modifier = Modifier.height(15.dp))

                Row {

                    //First division
                    Card (modifier = Modifier
                        .clickable {
                            val callIntent = Intent(Intent.ACTION_DIAL)
                            callIntent.data = "tel:0720245837".toUri()
                            mContext.startActivity(callIntent)
                        }
                        .padding(start = 10.dp)
                        .size(170.dp, height = 80.dp)){
                        Column (modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center){

                            Row {



                            Image(painter =  painterResource(id = R.drawable.phonecall), contentDescription = "call",
                                modifier = Modifier.size(35.dp)
                                )

                            Spacer(modifier =Modifier.width(20.dp))

                            Text(text = "Call",
                                fontSize = 25.sp,
                                fontFamily = FontFamily.SansSerif,
                                textAlign = TextAlign.Justify)
                        }
                        }
                    }

                    //End of first division

                    Spacer(modifier = Modifier.width(25.dp))


                    //Second division


                    Card (modifier = Modifier
                        .clickable {
                            val smsIntent = Intent(Intent.ACTION_SENDTO)
                            smsIntent.data = "smsto:0720245837".toUri()
                            smsIntent.putExtra("sms_body", "Hello this Starshine Academy.")
                            mContext.startActivity(smsIntent)
                        }
                        .size(170.dp, height = 80.dp)){
                        Column (modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center){

                            Row {



                                Image(painter =  painterResource(id = R.drawable.message), contentDescription = "message",
                                    modifier = Modifier.size(35.dp))

                                Spacer(modifier =Modifier.width(20.dp))

                                Text(text = "Message",
                                    fontSize = 25.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    textAlign = TextAlign.Justify)
                            }
                        }
                    }

                    //End of second division
                }

                //End of row1


                Spacer(modifier = Modifier.height(35.dp))


                //Row2

                Row {

                    //First division
                    Card (modifier = Modifier
                        .clickable {
                            val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(
                                Intent.EXTRA_EMAIL,
                                arrayOf("mwanikialexander51@gmail.com")
                            )
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "INQUIRY")
                            shareIntent.putExtra(
                                Intent.EXTRA_TEXT,
                                "I write to enquire on the following"
                            )
                            mContext.startActivity(shareIntent)
                        }
                        .padding(start = 10.dp)
                        .size(170.dp, height = 80.dp)){
                        Column (modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center){

                            Row {



                                Image(painter =  painterResource(id = R.drawable.mail), contentDescription = "mail",
                                    modifier = Modifier.size(35.dp)
                                )

                                Spacer(modifier =Modifier.width(20.dp))

                                Text(text = "Email",
                                    fontSize = 25.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    textAlign = TextAlign.Justify)
                            }
                        }
                    }

                    //End of first division

                    Spacer(modifier = Modifier.width(25.dp))


                    //Second division


                    Card (modifier = Modifier
                        .clickable {
                            val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(
                                Intent.EXTRA_TEXT,
                                "Download this Record checker application"
                            )
                            mContext.startActivity(Intent.createChooser(shareIntent, "Share"))
                        }
                        .size(170.dp, height = 80.dp)){
                        Column (modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center){

                            Row {



                                Image(painter =  painterResource(id = R.drawable.share), contentDescription = "share",
                                    modifier = Modifier.size(35.dp))

                                Spacer(modifier =Modifier.width(20.dp))

                                Text(text = "Share",
                                    fontSize = 25.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    textAlign = TextAlign.Justify)
                            }
                        }
                    }

                    //End of second division
                }

                //End of row2





                }


            }
        }



@Preview(showBackground = true)
@Composable
fun ContactPreview(){
    Contact(rememberNavController())
}