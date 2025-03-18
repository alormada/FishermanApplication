package com.example.myfishermanapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class GalleryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColumnWithInput()
        }
    }
}

// ✅ Move this function OUTSIDE the class to avoid "Unresolved reference" error
@Composable
fun ColumnWithInput() {
    val context: Context = LocalContext.current
    val intentList = Intent(context, ListActivity::class.java)
    val intentGallery = Intent(context, GalleryActivity::class.java)
    val intentMain = Intent(context, MainActivity::class.java)

    // State to store input text
    var textState by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Co dzisiaj złowiłeś?", style = MaterialTheme.typography.headlineSmall)
        Text(text = "Ekran BBB!")

        // Input Field
        OutlinedTextField(
            value = textState,
            onValueChange = { textState = it },
            label = { Text("Enter some data") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input Field
        OutlinedTextField(
            value = textState,
            onValueChange = { textState = it },
            label = { Text("Enter some data") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input Field
        OutlinedTextField(
            value = textState,
            onValueChange = { textState = it },
            label = { Text("Enter some data") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input Field
        OutlinedTextField(
            value = textState,
            onValueChange = { textState = it },
            label = { Text("Enter some data") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input Field
        OutlinedTextField(
            value = textState,
            onValueChange = { textState = it },
            label = { Text("Enter some data") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to process input
        Button(onClick = { /* Handle input submission */ }) {
            Text("Submit")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = {
                    context.startActivity(intentList)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.List, contentDescription = "list icon"
                )
            }
            Button(
                onClick = {
                    context.startActivity(intentMain)
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Home, contentDescription = "home icon"
                )
            }
            Button(
                onClick = {
                    context.startActivity(intentGallery)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.AccountBox, contentDescription = "account icon"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    ColumnWithInput()
}
