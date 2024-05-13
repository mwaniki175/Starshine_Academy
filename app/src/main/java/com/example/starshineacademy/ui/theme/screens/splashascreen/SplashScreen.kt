package com.example.starshineacademy.ui.theme.screens.splashascreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.starshineacademy.R.raw.splash
import com.example.starshineacademy.navigation.LOGIN_URL
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreen(navController: NavHostController){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {




        //Animation
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(splash),)
        val progress by animateLottieCompositionAsState(composition)
        LottieAnimation(composition, progress)

        val mContext = LocalContext.current

        LottieAnimation(composition , progress ,
            modifier = Modifier.size(80.dp))


        val coroutine = rememberCoroutineScope()
        coroutine.launch {
            delay(1100)
            navController.navigate(LOGIN_URL)

        }




    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    SplashScreen(rememberNavController())
}