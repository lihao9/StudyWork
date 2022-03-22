package com.maotom.livedata_viewmodule.viewmodule

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maotom.livedata_viewmodule.livedata.User
import kotlinx.coroutines.launch

/**
 *   @author:  Mao Tom
 *   @date:  2022/3/22 0022
 *   @description: todo
 *
 */
class MyViewModule: ViewModel() {



    val myLiveData by lazy { MutableLiveData<User>() }


    fun doOnCoroutines(block: suspend () -> Unit){
        viewModelScope.launch {
            block()
        }
    }

    fun getData(){
        viewModelScope.launch {
            myLiveData.postValue(User().apply {
                name = "xiaoli"
                location = "shenz"
                age
            })
        }
    }

    fun changeData(){
        Transformations.map(myLiveData){
            it.name = "newxl"
            it.location = "newzhenz"
            it.age = 30
        }

    }



}