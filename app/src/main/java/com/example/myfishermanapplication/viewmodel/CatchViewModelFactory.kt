package com.example.myfishermanapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfishermanapplication.database.CatchRepository

class CatchViewModelFactory(private val repository: CatchRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CatchViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CatchViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}