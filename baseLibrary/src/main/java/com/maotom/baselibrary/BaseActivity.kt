package com.maotom.baselibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.blankj.utilcode.util.ToastUtils

abstract class BActivity<T:ViewBinding>: AppCompatActivity() {

    lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingXml()
        setContentView(binding.root)
        initView(savedInstanceState)
    }

    abstract fun getViewLayout(): Int
    abstract fun bindingXml()
    abstract fun initView(savedInstanceState: Bundle?)



    fun showLoading(){


    }



}