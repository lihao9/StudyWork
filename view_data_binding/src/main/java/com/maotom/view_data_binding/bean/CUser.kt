package com.maotom.view_data_binding.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

/**
 *   @author:  Mao Tom
 *   @date:  2022/3/11 0011
 *   @description: todo
 *
 */
class CUser: BaseObservable() {


    @get:Bindable
    var name:String = ""
        set(value) {
            field = value
            notifyChange()
        }


    var age: Int = 0

    fun format(name: String,age:Int): String{
        return name+age
    }

}