package com.maotom.view_data_binding

import android.widget.TextView
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods

/**
 * 作者  Acer
 * 时间  2022/3/20
 * 作用
 * 更新作者
 * 更新说明
 * 版本
 * 类作用
 **/


@BindingMethods(
    value = [
        BindingMethod(
            type = MyTextView::class,
            attribute = "oneText",
            method = "setTempText",
        ),
    ],
)
class BindingMethod {





}