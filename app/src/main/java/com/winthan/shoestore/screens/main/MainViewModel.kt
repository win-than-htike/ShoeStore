package com.winthan.shoestore.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.winthan.shoestore.models.ShoeModel

class MainViewModel : ViewModel() {

    val title = MutableLiveData<String>()
    val company = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    private val _shoeList = MutableLiveData<MutableList<ShoeModel>>()
    val shoeList : LiveData<MutableList<ShoeModel>>
        get() = _shoeList

    private val _shoeCreated = MutableLiveData<Boolean>()
    val shoeCreated: LiveData<Boolean>
        get() = _shoeCreated

    fun addShoe() {
        val oldShoeList = _shoeList.value ?: mutableListOf()
        val shoe = ShoeModel(
            title = title.value ?: "",
            company = company.value ?: "",
            shoeSize = shoeSize.value ?: "",
            description = description.value ?: ""
        )
        oldShoeList.add(shoe)
        _shoeList.value = oldShoeList
        resetInput()
    }

    fun updateShoeCreated() {
        _shoeCreated.value = false
    }

    private fun resetInput() {
        title.value = ""
        company.value = ""
        shoeSize.value = ""
        description.value = ""
        _shoeCreated.value = true
    }

}