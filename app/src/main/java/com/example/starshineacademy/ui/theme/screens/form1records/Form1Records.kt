package com.example.starshineacademy.ui.theme.screens.form1records

//import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.starshineacademy.data.Form1ViewModel
import com.example.starshineacademy.models.Form1
import com.example.starshineacademy.ui.theme.StarshineAcademyTheme


@Composable
fun Form1Records(navController: NavHostController){
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        

        Spacer(modifier = Modifier.height(15.dp))

        var context = LocalContext.current
        var form1Repository = Form1ViewModel(navController, context)


        
        val emptyForm1State = remember { mutableStateOf(Form1()) }
        var emptyForm1sListState = remember { mutableStateListOf<Form1>() }

        var form1s = form1Repository.allForm1Students(emptyForm1State, emptyForm1sListState)

        Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
            
            Text(text = "All Form One Students",
                fontSize = 35.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black)

            Spacer(modifier = Modifier.height(20.dp))

            LazyRow() {
                items(form1s){
                    Form1Item(
                        fullname = it.fullname,
                        gender = it.gender,
                        kcpemarks = it.kcpemarks,
                        guardianname = it.guardianname,
                        guardianphonenumber = it.guardianphonenumber,
                        id = it.id,
                        navController = navController,
                        form1Repository = form1Repository,
                        form1Image = it.imageUrl
                    )



                }

            }
            
        }


    }
}

@Composable
fun Form1Item(fullname:String,guardianname:String,guardianphonenumber:String,gender:String,kcpemarks:String,id:String,
              navController: NavHostController,
              form1Repository:Form1ViewModel,form1Image:String){

    Row {
        Text(text = fullname)
        Text(text = guardianname)
        Text(text = guardianphonenumber)
        Text(text = gender)
        Text(text = kcpemarks)
       // Image(painter = remember,
            //contentDescription = null,
            //modifier = Modifier.size(150.dp))


        Button(onClick = {   form1Repository.deletestudent(id) }) {

            Text(text = "Delete")


        }


    }

    }





@Preview(showBackground = true)
@Composable
fun Form1RecordsPreview(){

    StarshineAcademyTheme {
        Form1Records(navController = rememberNavController())
    }
}