package com.maotom.livedata_viewmodule.life

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.orhanobut.logger.Logger

/**
 *   @author:  Mao Tom
 *   @date:  2022/3/22 0022
 *   @description: todo
 *
 */
class MyLifeCycleObserver: DefaultLifecycleObserver {

    val TAG = "MyLifeCycleObserver"

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Logger.d(TAG+"::onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Logger.d(TAG+"::onStart")

    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Logger.d(TAG+"::onResume")

    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Logger.d(TAG+"::onPause")

    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Logger.d(TAG+"::owner")

    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Logger.d(TAG+"::onDestroy")
    }

}