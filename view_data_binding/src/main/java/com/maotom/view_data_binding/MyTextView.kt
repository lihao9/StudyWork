package com.maotom.view_data_binding

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import com.blankj.utilcode.util.ToastUtils
import com.orhanobut.logger.Logger

/**
 * 作者  Acer
 * 时间  2022/3/20
 * 作用
 * 更新作者
 * 更新说明
 * 版本
 * 类作用
 **/


@SuppressLint("AppCompatCustomView")
class MyTextView@JvmOverloads constructor(context:Context,attrs: AttributeSet? = null, defStyleAttr: Int = 0): TextView(context,attrs,defStyleAttr) {

    init {

        initAttribute(attrs)

    }

    private fun initAttribute(attrs: AttributeSet?) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.AttrMyTextView)
    }

    fun setTempText(str:String){
        setText(str)
    }






}