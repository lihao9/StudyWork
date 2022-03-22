package com.maotom.livedata_viewmodule

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 *   @author:  Mao Tom
 *   @date:  2022/3/22 0022
 *   @description: todo
 *
 */
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())
    }

}