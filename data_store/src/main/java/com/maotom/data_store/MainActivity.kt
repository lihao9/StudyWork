package com.maotom.data_store

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.createDataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.maotom.data_store.databinding.ActivityMainBinding
import com.maotom.data_store.datastore.AppConfig
import com.maotom.data_store.proto_data.ConfigSerializer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
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

    val dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
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
            Log.d(TAG, "setOnClickListener: ")
            launch {
                savePreferencesData1(binding.etInputContent.text.toString())
            }
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
        binding.btnPreferencesDataStoreGet.setOnClickListener {
            launch {
                val EXAMPLE_COUNTER = stringPreferencesKey("str")
                dataStore.data
                    .catch { exception ->
                        Log.e(TAG, Thread.currentThread().name )
                        Log.e(TAG, "setOnClickListener: " +exception.message)
                    }.map {
                        Log.e(TAG, Thread.currentThread().name )
                        it[EXAMPLE_COUNTER]
                    }.onEach {
                        binding.tvShowPreferencesDataStore.text = it?:"没有数据"
                        Log.e(TAG, it?:"没有数据" )
                    }.collect()
            }
        }
        binding.btnProtoDataStoreSave.setOnClickListener {  }
        binding.btnProtoDataStoreGet.setOnClickListener {  }
    }


    suspend fun savePreferencesData1(value:String){

        val EXAMPLE_COUNTER = stringPreferencesKey("str")
        dataStore.edit {
            it[EXAMPLE_COUNTER] = value as String
        }
    }

    suspend fun savePreferencesData(value:Any){
        when(value.javaClass){
            Int.javaClass,Short.javaClass ->{
                val EXAMPLE_COUNTER = intPreferencesKey("int")
                dataStore.edit {
                    it[EXAMPLE_COUNTER] = value as Int
                }
            }
            String.javaClass,Char.javaClass ->{
                val EXAMPLE_COUNTER = stringPreferencesKey("str")
                dataStore.edit {
                    it[EXAMPLE_COUNTER] = value as String
                }
            }
            Boolean.javaClass ->{
                val EXAMPLE_COUNTER = booleanPreferencesKey("boolean")
                dataStore.edit {
                    it[EXAMPLE_COUNTER] = value as Boolean
                }
            }
            Float.javaClass ->{
                val EXAMPLE_COUNTER = floatPreferencesKey("float")
                dataStore.edit {
                    it[EXAMPLE_COUNTER] = value as Float
                }
            }

    suspend fun saveProtoStore(){
        protoDataStore.updateData {
            it.toBuilder().setShowCompleted(false).setContent(binding.etInputContent.text.toString().trim()).build()
        }
    }
            Double.javaClass ->{
                val EXAMPLE_COUNTER = doublePreferencesKey("double")
                dataStore.edit {
                    it[EXAMPLE_COUNTER] = value as Double
                }
            }

            else ->{
                Log.e(TAG, "saveData: ", )

    suspend fun getProtoStore(){
        protoDataStore.data.map {
            it.content
        }.collect {
            binding.tvShowProtoDataStore.text = it
        }
    }

}

