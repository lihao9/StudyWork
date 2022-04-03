package com.maotom.baselibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.blankj.utilcode.util.ToastUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

abstract class BaseActivity<T:ViewDataBinding,M:ViewModel>: AppCompatActivity(),CoroutineScope by MainScope() {

    lateinit var binding: T
    lateinit var mViewModel: M

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        bindViewData()
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), getViewLayout(), null, false)
        setContentView(binding.root)
        initView(savedInstanceState)
        mViewModel = initViewModel()

    }

    abstract fun getViewLayout(): Int
    abstract fun bindViewData()
    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun initViewModel():M





    fun showLoading(){


    }



}