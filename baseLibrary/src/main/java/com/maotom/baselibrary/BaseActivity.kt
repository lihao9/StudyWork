package com.maotom.baselibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import com.blankj.utilcode.util.ToastUtils

abstract class BaseActivity<T:ViewDataBinding>: AppCompatActivity() {

    lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindViewData()
        setContentView(binding.root)
        initView(savedInstanceState)
    }

    abstract fun getViewLayout(): Int
    abstract fun bindViewData()
    abstract fun initView(savedInstanceState: Bundle?)



    fun showLoading(){


    }



}