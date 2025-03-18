package com.example.myfishermanapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfishermanapplication.ui.theme.MyFishermanApplicationTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class ListActivity : ComponentActivity() {
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
            Text(text = "Ekran CCC!")
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
                        startActivity(intent_main)
                        finish()
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
fun BBB() {

}
