package com.example.databinding.models

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.databinding.user.UserData

class ViewModelClass : ViewModel(),Observable {
    val isStringEmpty = MutableLiveData<Boolean>()
    @Bindable
    val inputTitle = MutableLiveData<String>()
    @Bindable
    val inputDescription = MutableLiveData<String>()
    val list = MutableLiveData<ArrayList<UserData>>()
    private val arraylst = ArrayList<UserData>()
   init {
        isStringEmpty.value = false
    }
    fun addData() {
        val title = inputTitle.value!!
        val description = inputDescription.value!!
        if(title.isBlank()|| description.isBlank()){
            isStringEmpty.value = true
        }else{
            inputTitle.value = " "
            inputDescription.value = " "
            var noteItem =UserData(title, description)
            arraylst.add(noteItem)
            list.value = arraylst
        }

    }
    fun clearData(){
        arraylst.clear()
        list.value = arraylst
    }
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}