package com.maotom.view_data_binding

import android.view.View
import com.blankj.utilcode.util.ToastUtils

/**
 * 作者  Acer
 * 时间  2022/3/14
 * 作用
 * 更新作者
 * 更新说明
 * 版本
 * 类作用
 **/
class ClickListenerInterface {

    fun methodReferences(view: View){
        ToastUtils.showShort("方法引用")

    }

    fun listenerBindings(view: View,runnable: Runnable){

        ToastUtils.showShort("监听器绑定")
        runnable.run()
    }
}