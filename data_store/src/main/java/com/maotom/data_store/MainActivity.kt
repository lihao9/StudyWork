package com.maotom.data_store

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.maotom.data_store.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), {

    lateinit var binding: ActivityMainBinding

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setOnClickListener()

    }

    private fun setOnClickListener() {
        binding.btnPreferencesDataStoreSave.setOnClickListener {


        }
        binding.btnPreferencesDataStoreGet.setOnClickListener {  }
        binding.btnProtoDataStoreSave.setOnClickListener {  }
        binding.btnProtoDataStoreGet.setOnClickListener {  }
    }

    suspend fun saveData(value:Any){
        when(value.javaClass){
            Int.javaClass ->{
                val EXAMPLE_COUNTER = intPreferencesKey("example_counter")
                dataStore()


            }
            String.javaClass ->
            Boolean.javaClass ->
            Float.javaClass ->
            Char.javaClass ->
            Byte.javaClass ->
            Short.javaClass ->
            Double.javaClass ->

            else{

            }


        }

    }


}