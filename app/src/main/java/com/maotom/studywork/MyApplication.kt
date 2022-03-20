package com.maotom.studywork

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 * 作者  Acer
 * 时间  2022/3/15
 * 作用
 * 更新作者
 * 更新说明
 * 版本
 * 类作用
 **/
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())
    }

}