package com.maotom.data_store

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.createDataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.createDataStore
import com.maotom.data_store.databinding.ActivityMainBinding
import com.maotom.data_store.datastore.AppConfig
import com.maotom.data_store.proto_data.ConfigSerializer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(),CoroutineScope by MainScope() {

    lateinit var binding: ActivityMainBinding

    val TAG = "MainActivity"

    val dataStore: DataStore<Preferences> = createDataStore(name = "appConfig")

    val protoDataStore: DataStore<AppConfig> =
        createDataStore(fileName = "appProtoConfig", serializer = ConfigSerializer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListener()

    }

    private fun setOnClickListener() {
        binding.btnPreferencesDataStoreSave.setOnClickListener {
            Log.d(TAG, "setOnClickListener: ")
            launch {
                savePreferencesData1(binding.etInputContent.text.toString())
            }
        }
        binding.btnPreferencesDataStoreGet.setOnClickListener {

        }
        binding.btnProtoDataStoreSave.setOnClickListener {
            launch {
//                saveProtoStore()
            }
        }
        binding.btnProtoDataStoreGet.setOnClickListener {
            launch {
                savePreferencesData1(binding.etInputContent.text.trim().toString())
            }
        }
        binding.btnPreferencesDataStoreGet.setOnClickListener {
            launch {
                val EXAMPLE_COUNTER = stringPreferencesKey("str")
                dataStore.data
                    .catch { exception ->
                        Log.e(TAG, Thread.currentThread().name)
                        Log.e(TAG, "setOnClickListener: " + exception.message)
                    }.map {
                        Log.e(TAG, Thread.currentThread().name)
                        it[EXAMPLE_COUNTER]
                    }.collect {
                        binding.tvShowPreferencesDataStore.text = it?:"没有数据"
                    }
            }
        }
        binding.btnProtoDataStoreSave.setOnClickListener {
            launch {
                protoDataStore.updateData {
                 it.toBuilder().setContent(binding.etInputContent.text.toString()).build()
                }
            }
        }
        binding.btnProtoDataStoreGet.setOnClickListener {
            launch {
                protoDataStore.data.map {
                    it.content
                }.collect {
                    binding.tvShowProtoDataStore.text = it
                }
            }
        }
    }


    suspend fun savePreferencesData1(value: String) {

        val EXAMPLE_COUNTER = stringPreferencesKey("str")
        dataStore.edit {
            it[EXAMPLE_COUNTER] = value as String
        }
    }
}



