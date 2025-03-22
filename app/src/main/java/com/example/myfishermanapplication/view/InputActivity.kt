package com.example.myfishermanapplication.view

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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

        Column(
            modifier = Modifier
                .padding(top = 32.dp, start = 16.dp, end = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

        Text(text = "Co dzisiaj złowiłeś?", style = MaterialTheme.typography.headlineSmall, textAlign = TextAlign.Center)

        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
            Text(text = "Liczba złowionych ryb:", textAlign = TextAlign.Left)
            OutlinedTextField(
                value = textState,
                onValueChange = { textState = it },
                label = { Text("Podaj liczbe ryb, którą dzisiaj złowiłeś") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
            Text(text = "Łączna waga ryb:", textAlign = TextAlign.Left)
            OutlinedTextField(
                value = textState,
                onValueChange = { textState = it },
                label = { Text("Podaj całkowitą wagę złowionych ryb") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
            Text(text = "Miejsce połowu:", textAlign = TextAlign.Left)
            OutlinedTextField(
                value = textState,
                onValueChange = { textState = it },
                label = { Text("Podaj lokalizację połowu") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
            Text(text = "Notatki:", textAlign = TextAlign.Left)
            OutlinedTextField(
                value = textState,
                onValueChange = { textState = it },
                label = { Text("Wprowadź swoje notatki") },
                modifier = Modifier.fillMaxWidth()
            )
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
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ColumnWithInput()
}