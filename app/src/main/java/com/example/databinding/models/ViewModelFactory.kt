package com.example.databinding.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ViewModelClass::class.java)){
            return ViewModelClass() as T
        }
        throw IllegalArgumentException("unkownviewmodel")
    }

}