package com.example.mangrove.Model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ViewModelProduct: ViewModel() {
    var productList = mutableStateListOf<product>()

    fun add(newTask: product){
        productList.add(newTask)
    }
    fun delete(newTask: product){
        productList.remove(newTask)
    }
}
