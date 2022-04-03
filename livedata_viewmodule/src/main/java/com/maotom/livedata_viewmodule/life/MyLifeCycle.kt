package com.maotom.livedata_viewmodule.life

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.orhanobut.logger.Logger

/**
 *   @author:  Mao Tom
 *   @date:  2022/3/21 0021
 *   @description: todo
 *
 */
//class MyLife: DefaultLifecycleObserver {
class MyLifeCycle: LifecycleOwner {

    val TAG = "MyLifeCycle"

    val mFragmentLifecycleRegistry = LifecycleRegistry(this)


    override fun getLifecycle(): Lifecycle {
        return mFragmentLifecycleRegistry
    }

    fun onCreate(){
        Logger.d(TAG+"::onCreate")
        mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
    }

}