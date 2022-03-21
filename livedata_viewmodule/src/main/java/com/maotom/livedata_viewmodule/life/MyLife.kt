package com.maotom.livedata_viewmodule.life

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver

/**
 *   @author:  Mao Tom
 *   @date:  2022/3/21 0021
 *   @description: todo
 *
 */
//class MyLife: DefaultLifecycleObserver {
class MyLife: Lifecycle() {
    override fun addObserver(observer: LifecycleObserver) {
        TODO("Not yet implemented")
    }

    override fun removeObserver(observer: LifecycleObserver) {
        TODO("Not yet implemented")
    }

    override fun getCurrentState(): State {
        TODO("Not yet implemented")
    }


}