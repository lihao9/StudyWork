package com.maotom.baselibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.blankj.utilcode.util.ToastUtils

abstract class BActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getViewLayout())
    }

    abstract fun getViewLayout(): Int

    fun showLoading(){

    }



}