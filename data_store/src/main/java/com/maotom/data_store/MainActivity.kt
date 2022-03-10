package com.maotom.data_store

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.createDataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import com.maotom.data_store.databinding.ActivityMainBinding
import com.maotom.data_store.datastore.AppConfig
import com.maotom.data_store.proto_data.ConfigSerializer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(),CoroutineScope by MainScope() {

    lateinit var binding: ActivityMainBinding

    val dataStore: DataStore<Preferences>
        get() = createDataStore(name = "appConfig")

    val protoDataStore: DataStore<AppConfig> = createDataStore(fileName = "appProtoConfig",serializer = ConfigSerializer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.btnPreferencesDataStoreSave.setOnClickListener {


        }
        binding.btnPreferencesDataStoreGet.setOnClickListener {

        }
        binding.btnProtoDataStoreSave.setOnClickListener {
            launch {
                saveProtoStore()
            }
        }
        binding.btnProtoDataStoreGet.setOnClickListener {
            launch {
                getProtoStore()
            }
        }
    }



    suspend fun saveProtoStore(){
        protoDataStore.updateData {
            it.toBuilder().setShowCompleted(false).setContent(binding.etInputContent.text.toString().trim()).build()
        }
    }

    suspend fun getProtoStore(){
        protoDataStore.data.map {
            it.content
        }.collect {
            binding.tvShowProtoDataStore.text = it
        }
    }

}

