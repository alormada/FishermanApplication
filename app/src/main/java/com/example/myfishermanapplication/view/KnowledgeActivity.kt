package com.example.myfishermanapplication.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.myfishermanapplication.model.Fish
import com.example.myfishermanapplication.viewmodel.KnowledgeViewModel
import kotlin.properties.ReadOnlyProperty
import com.example.myfishermanapplication.utils.getAssetImageUri
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import android.graphics.BitmapFactory
import coil.compose.AsyncImage
import java.io.IOException


class KnowledgeActivity : ComponentActivity() {

    private val viewModel by viewModels<KnowledgeViewModel> {
        object : ViewModelProvider.AndroidViewModelFactory(application) {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return KnowledgeViewModel(application) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val fishId = intent.getStringExtra("fish_id") ?: run {
            Log.e("KnowledgeActivity", "Nie przekazano ID ryby!")
            finish()
            return
        }
        Log.d("KnowledgeActivity", "Otrzymano fishId: $fishId")

        viewModel.loadFish(fishId)

        setContent {
            val fish by viewModel.fish.collectAsState()

            fish?.let {
                FishDetailsScreen(it)
            } ?: run {
                Text(text = "Ładowanie...", modifier = Modifier.padding(20.dp))
            }
        }
    }
}

@Composable
fun FishDetailsScreen(fish: Fish) {
    val context = LocalContext.current
    val bitmap = remember { loadBitmapFromAssets(context, fish.imageUri ?: "") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = fish.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            bitmap?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = fish.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            } ?: Text("Błąd wczytywania obrazu")

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Dorastają do: ${fish.length} cm", fontSize = 18.sp)
            Text(text = "Przynęta: ${fish.bait}", fontSize = 18.sp)
            Text(text = "Wymiar ochronny: ${fish.protectiveDimension} cm", fontSize = 18.sp)
            Text(text = "Opis: ${fish.description}", fontSize = 18.sp)
        }
    }
}


fun loadBitmapFromAssets(context: Context, filePath: String): android.graphics.Bitmap? {
    return try {
        val inputStream = context.assets.open(filePath)
        BitmapFactory.decodeStream(inputStream)
    } catch (e: IOException) {
        e.printStackTrace()
        null
    }
}
