package com.example.logintoopen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import android.content.Context

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen1()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen1() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEbacbbb)) // Set your desired background color here
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo2),
                contentDescription = "Login Image",
                modifier = Modifier
                    .size(200.dp)
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        // Handle Login here
                    }
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Amazon Button
            WebsiteButton(
                context = context,
                url = "https://www.amazon.in/",
                logo = R.drawable.amazon_logo,
                text = "Sign in to Amazon",
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Flipkart Button
            WebsiteButton(
                context = context,
                url = "https://www.flipkart.com/",
                logo = R.drawable.flipkart,
                text = "Sign in to Flipkart",
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Google Button
            WebsiteButton(
                context = context,
                url = "https://www.google.com/",
                logo = R.drawable.google_logo,
                text = "Sign in to Google",
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Myntra Button
            WebsiteButton(
                context = context,
                url = "https://www.myntra.com/",
                logo = R.drawable.myntra_logo,
                text = "Sign in to Myntra",
            )
        }
    }
}

@Composable
fun WebsiteButton(
    context: Context,
    url: String,
    logo: Int,
    text: String,
) {
    Button(
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            val chooser = Intent.createChooser(intent, "Open with...")
            if (chooser.resolveActivity(context.packageManager) != null) {
                context.startActivity(chooser)
            } else {
                Toast.makeText(context, "No web browser is available", Toast.LENGTH_LONG).show()
            }
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = logo),
                contentDescription = "$text Logo",
                modifier = Modifier.size(24.dp)
            )
            Text(text = text, color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen1()
}
