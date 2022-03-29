package com.maotom.livedata_viewmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.maotom.livedata_viewmodule.databinding.ActivityMainBinding
import com.maotom.livedata_viewmodule.life.MyLifeCycle
import com.maotom.livedata_viewmodule.life.MyLifeCycleObserver
import com.maotom.livedata_viewmodule.viewmodule.MyViewModule
import com.orhanobut.logger.Logger

class MainActivity : AppCompatActivity() {

    var myLifeCycle: MyLifeCycle? = null
    var myLifeCycleObserver: MyLifeCycleObserver? = null

    lateinit var binding: ActivityMainBinding

    lateinit var mViewModel: MyViewModule


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        myLifeCycle = MyLifeCycle()
        myLifeCycleObserver = MyLifeCycleObserver()
        myLifeCycle?.lifecycle?.addObserver(myLifeCycleObserver!!)
        myLifeCycle?.onCreate()
        mViewModel = ViewModelProvider(this)[MyViewModule::class.java]
        mViewModel.getData()

        binding.myViewModel = mViewModel

        mViewModel.myLiveData.observe(this,{
            Logger.d("接收到LiveData数据::"+it.name)
        })

    }



}