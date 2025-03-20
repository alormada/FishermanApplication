package com.example.myfishermanapplication.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column()
        }
    }
    @Composable
    fun Column() {
        val context: Context = LocalContext.current
        val intent_list: Intent = Intent(context, ListActivity::class.java)
        val intent_gallety: Intent = Intent(context, GalleryActivity::class.java)
        val intent_main: Intent = Intent(context, MainActivity::class.java)

        androidx.compose.foundation.layout.Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "witaj w androidzie!")
            Text(text = "Ekran AAA!")



            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 10.dp, start = 5.dp, end = 5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom
            ) {
                Button(
                    onClick = {
                        startActivity(intent_list)
                        finish()
                    }
                ){
                    Icon(
                        imageVector = Icons.Default.List, contentDescription = "list icon"
                    )
                }
                Button(
                    onClick = {
                    }
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Home, contentDescription = "home icon"
                    )
                }
                Button (
                    onClick = {
                        startActivity(intent_gallety)
                        finish()
                    }
                ){
                    Icon(
                        imageVector = Icons.Default.AccountBox, contentDescription = "account icon",
                    )
                }
            }
        }
    }
}

@Composable
@Preview (showBackground = true)
fun AAA() {
}
