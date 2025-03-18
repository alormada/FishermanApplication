package com.example.myfishermanapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfishermanapplication.ui.theme.MyFishermanApplicationTheme

class InputActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColumnWithInput()
        }
    }
}

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
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {

        Text(text = "Co dzisiaj złowiłeś?", style = MaterialTheme.typography.headlineSmall)
        Text(text = "Ekran BBB!")


        LazyColumn {

            items(20) { index ->
                // Input Field
                OutlinedTextField(
                    value = textState,
                    onValueChange = { textState = it },
                    label = { Text("Enter some data") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // Button to process input
        Button(onClick = { /* Handle input submission */ }) {
            Text("Submit")
        }

        Row(
            modifier = Modifier
                .fillMaxSize()
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
fun GreetingPreview() {
    ColumnWithInput()
}