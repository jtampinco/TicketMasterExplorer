package com.jtampinco.ticketmasterexplorer.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewAttractionViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val arguments = savedStateHandle.getLiveData<String>(ATTRACTION_URL)
    val attractionUrl = arguments.value ?: ""

    companion object {
        const val ATTRACTION_URL = "ATTRACTION_URL"
    }

}

