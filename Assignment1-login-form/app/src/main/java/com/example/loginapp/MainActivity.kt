package com.example.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginapp.ui.theme.LoginappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginappTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                ) {
                    LoginForm()
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm()
{
    Column(modifier= Modifier.fillMaxSize().padding(horizontal = 16.dp), verticalArrangement= Arrangement.Center,horizontalAlignment= Alignment.CenterHorizontally){
    Text(text = "LOGIN FORM",fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Spacer(modifier=Modifier.height(16.dp))

        var username by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(value = username, onValueChange = { username =it}, label={Text(text="Username")},shape=MaterialTheme.shapes.small)
        Spacer(modifier=Modifier.height(5.dp))

        var password by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(value = password, onValueChange = { password =it}, label={Text(text="Password")},shape=MaterialTheme.shapes.small)
        Spacer(modifier=Modifier.height(10.dp))

        Button(modifier= Modifier.align(Alignment.CenterHorizontally),onClick={}, colors = buttonColors(
            Color.Black)){
            Text(text = "Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginFormPreview() {
    LoginappTheme {
        LoginForm()
    }
}