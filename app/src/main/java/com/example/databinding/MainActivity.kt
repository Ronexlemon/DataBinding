package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.databinding.databinding.ActivityMainBinding
import com.example.databinding.models.ViewModelClass
import com.example.databinding.models.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var  databinding : ActivityMainBinding
    private   lateinit var  viewmodel : ViewModelClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val factory = ViewModelFactory()
        viewmodel = ViewModelProvider(this, factory).get(ViewModelClass::class.java)
        databinding.notesViewModel = viewmodel
        databinding.lifecycleOwner = this
        viewmodel.list.observe(this, Observer{
            databinding.content.text = it.toString()
        })
        viewmodel.isStringEmpty.observe(this, Observer{
            if(it==true){
                Toast.makeText(this, "No Notes Detected",Toast.LENGTH_SHORT).show();
            }
        })
    }
}