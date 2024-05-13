package com.example.starshineacademy.ui.theme.screens.form2records

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
import com.example.starshineacademy.data.Form2ViewModel
import com.example.starshineacademy.models.Form2
import com.example.starshineacademy.ui.theme.StarshineAcademyTheme


@Composable
fun Form2Records(navController: NavHostController){
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {



        Spacer(modifier = Modifier.height(15.dp))

        var context = LocalContext.current
        var form2Repository = Form2ViewModel(navController, context)



        val emptyForm2State = remember { mutableStateOf(Form2()) }
        var emptyForm2sListState = remember { mutableStateListOf<Form2>() }

        var form2s = form2Repository.allForm2Students(emptyForm2State, emptyForm2sListState)

        Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){

            Text(text = "All Form Two Students",
                fontSize = 35.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black)

            Spacer(modifier = Modifier.height(20.dp))

            LazyRow() {
                items(form2s){
                    Form2Item(
                        fullname = it.fullname,
                        gender = it.gender,
                        kcpemarks = it.kcpemarks,
                        guardianname = it.guardianname,
                        guardianphonenumber = it.guardianphonenumber,
                        id = it.id,
                        navController = navController,
                        form2Repository = form2Repository,
                        form2Image = it.imageUrl
                    )



                }

            }

        }


    }
}

@Composable
fun Form2Item(fullname:String, guardianname:String, guardianphonenumber:String, gender:String, kcpemarks:String, id:String,
              navController: NavHostController,
              form2Repository: Form2ViewModel, form2Image:String){

    Row {
        Text(text = fullname)
        Text(text = guardianname)
        Text(text = guardianphonenumber)
        Text(text = gender)
        Text(text = kcpemarks)
        // Image(painter = remember,
        //contentDescription = null,
        //modifier = Modifier.size(150.dp))


        Button(onClick = {   form2Repository.deleteForm2(id) }) {

            Text(text = "Delete")


        }


    }

}





@Preview(showBackground = true)
@Composable
fun Form2RecordsPreview(){

    StarshineAcademyTheme {
        Form2Records(navController = rememberNavController())
    }
}