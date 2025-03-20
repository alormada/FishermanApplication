package com.example.myfishermanapplication.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfishermanapplication.model.Fish
import com.example.myfishermanapplication.viewmodel.KnowledgeViewModel
import kotlin.properties.ReadOnlyProperty

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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Ryba: ${fish.name}", fontSize = 24.sp)
            Text(text = "Opis: ${fish.description}", fontSize = 18.sp)
            Text(text = "Długość: ${fish.length}", fontSize = 18.sp)
            Text(text = "Przynęta: ${fish.bait}", fontSize = 18.sp)
            Text(text = "Wymiar ochronny: ${fish.protectiveDimension}", fontSize = 18.sp)
        }
    }
}
