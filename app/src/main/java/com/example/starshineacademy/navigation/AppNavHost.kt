package com.example.starshineacademy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.starshineacademy.ui.theme.screens.Form1.Form1
import com.example.starshineacademy.ui.theme.screens.Form2.Form2
import com.example.starshineacademy.ui.theme.screens.Form3.Form3
import com.example.starshineacademy.ui.theme.screens.Form4.Form4
import com.example.starshineacademy.ui.theme.screens.Screens.WelcomeScreen
import com.example.starshineacademy.ui.theme.screens.about.Biography
import com.example.starshineacademy.ui.theme.screens.contactscreen.Contact
import com.example.starshineacademy.ui.theme.screens.form1records.Form1Records
import com.example.starshineacademy.ui.theme.screens.form3records.Form3Records
import com.example.starshineacademy.ui.theme.screens.form4records.Form4Records
import com.example.starshineacademy.ui.theme.screens.form2records.Form2Records
import com.example.starshineacademy.ui.theme.screens.login.LoginScreen
import com.example.starshineacademy.ui.theme.screens.schoolgallery.SchoolGallery
import com.example.starshineacademy.ui.theme.screens.signup.SignupScreen
import com.example.starshineacademy.ui.theme.screens.splashascreen.SplashScreen
import com.example.starshineacademy.ui.theme.screens.studentpage.StudentScreen
import com.example.starshineacdemy.ui.theme.screens.dashboard.Dashboard

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = SPLASHSCREEN_URL
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier){
        composable(LOGIN_URL){
            LoginScreen(navController = navController)
        }
        composable(SIGNUP_URL){
            SignupScreen(navController = navController)
        }

        composable(SPLASHSCREEN_URL){
            SplashScreen(navController = navController)
        }
        composable(DASHBOARD_URL){
            Dashboard(navController = navController)
        }
        composable(WELCOME_URL){
            WelcomeScreen(navController = navController)
        }
        composable(CONTACT_URL){
            Contact(navController = navController)
        }
        composable(STUDENTSCREEN_URL){
            StudentScreen(navController = navController)
        }
        composable(FORM1_URL){
            Form1(navController = navController)
        }
        composable(FORM2_URL){
            Form2(navController = navController)
        }
        composable(FORM3_URL){
            Form3(navController = navController)
        }
        composable(FORM4_URL){
            Form4(navController = navController)
        }
        composable(FORM1RECORDS_URL){
            Form1Records(navController = navController)
        }
        composable(route = FORM2RECORDS_URL){
            Form2Records(navController = navController)
        }
        composable(FORM3RECORDS_URL){
            Form3Records(navController = navController)
        }
        composable(FORM4RECORDS_URL){
            Form4Records(navController = navController)
        }
        composable(ABOUT_URL){
            Biography(navController = navController)
        }
        composable(GALLERY_URL){
            SchoolGallery(navController = navController)
        }
    }
}