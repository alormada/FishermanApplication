package com.example.myfishermanapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfishermanapplication.database.CatchRepository
import com.example.myfishermanapplication.model.Catch
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class CatchListViewModel(repository: CatchRepository) : ViewModel() {
    val allCatches: StateFlow<List<Catch>> = repository.allCatches
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
}
