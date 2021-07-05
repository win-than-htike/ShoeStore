package com.winthan.shoestore.screens.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val title = MutableLiveData("")
    val company = MutableLiveData("")
    val shoeSize = MutableLiveData("")
    val description = MutableLiveData("")

    fun addShoe() {
        
    }

}