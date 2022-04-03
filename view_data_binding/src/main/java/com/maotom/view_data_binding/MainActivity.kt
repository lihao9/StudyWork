package com.maotom.view_data_binding

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.MotionEvent
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.blankj.utilcode.util.ResourceUtils
import com.blankj.utilcode.util.ToastUtils
import com.bumptech.glide.Glide
import com.maotom.baselibrary.BaseActivity
import com.maotom.view_data_binding.bean.CUser
import com.maotom.view_data_binding.bean.User
import com.maotom.view_data_binding.databinding.ActivityMainBinding
import com.orhanobut.logger.Logger
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<ActivityMainBinding>() {

    val TAG = "MainActivity"

    var cUser: CUser? = null
    var user: User? = null

    override fun getViewLayout(): Int {
        return R.layout.activity_main
    }

    override fun bindViewData() {

        binding = ActivityMainBinding.inflate(layoutInflater)

//        binding = DataBindingUtil.setContentView(this,getViewLayout())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ClickableViewAccessibility", "ResourceAsColor", "NewApi", "ResourceType")
    override fun initView(savedInstanceState: Bundle?) {

        binding.myTv.setTextColor(ContextCompat.getColorStateList(this,R.drawable.selector_color))
        binding.myTv.isPressed = true

//        binding.myTv.setTextSelectHandle(ResourceUtils.getDrawable(R.drawable.selector_color))

//        binding.myTv.setOnTouchListener { v, event ->
//            when(event.action){
//
//                MotionEvent.ACTION_DOWN -> {
//                    Logger.d("down")
//                }
//                MotionEvent.ACTION_MOVE -> {
//                    Logger.d("move")
//                }
//            }
//
//            true
//        }

        binding.user = User("tom",26)
        user = User("tom",15)
        cUser = CUser()

        binding.user = user
        binding.cuser = cUser?.apply {
            name = "ctom"
            age = 27
        }

        launch {
            val async = async {
                delay(5000)
                cUser?.apply {
                    name = "ctom"
                    age = 28
                }
            }
            async.await()
        }

        binding.myRunnable = Runnable {
            runOnUiThread {
                Log.e(TAG, "runOnUiThread")
                startActivity(Intent(this@MainActivity,AdapterActivity::class.java))
            }
        }

        Glide.with(this@MainActivity)
            .load("https://fileupload.tg3.fun/file/download/31878a89-f20a-4516-af14-d7eba8596a0b.png")
            .into(binding.ivImg)


        binding.click = ClickListenerInterface()

        binding.btnShowData.setOnClickListener {

            user?.apply {
                name = "ntom"
                age = 115
            }

            cUser?.apply {
                name = "ctom"
                age = 29
            }

            ToastUtils.showShort(binding.tvName.text.toString() + binding.tvAge.text.toString())
        }

    }


    fun changeCUserValue(view: View){

        binding.myTv.text = "lh"
        Logger.d(cUser?.name)

//        cUser?.apply {
//            name = "ctom"
//            age = 28
//        }
    }

}