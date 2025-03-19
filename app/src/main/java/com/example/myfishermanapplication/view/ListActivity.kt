package com.example.myfishermanapplication.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

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


        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            val itemmList = remember { mutableStateListOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25) }


            LazyColumn (
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 10.dp)
                    .fillMaxHeight(0.93f)
                    .fillMaxWidth(1f),
                contentPadding = PaddingValues(top=20.dp)

            ){
                items(items = itemmList){ item ->
//                    Text(text = "$item")
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .padding(start = 5.dp, end = 5.dp, top = 2.dp)
                            .height(80.dp)
                            .fillMaxSize(),

                    ) {
                        Text(
                            text = "Ryba: $item",
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentSize()
                        )
                    }
                }
            }
            BottomRow()

        }
    }
    @Composable
    fun BottomRow() {
        val context: Context = LocalContext.current
        val intent_list: Intent = Intent(context, ListActivity::class.java)
        val intent_gallety: Intent = Intent(context, GalleryActivity::class.java)
        val intent_main: Intent = Intent(context, MainActivity::class.java)
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.dp, start = 5.dp, end = 5.dp, top = 0.dp),

            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom,

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



@Composable
@Preview (showBackground = true)
fun BBB() {

}
