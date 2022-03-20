package com.maotom.view_data_binding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.blankj.utilcode.util.ResourceUtils
import com.blankj.utilcode.util.ToastUtils
import com.bumptech.glide.Glide

/**
 * 作者  Acer
 * 时间  2022/3/16
 * 作用
 * 更新作者
 * 更新说明
 * 版本
 * 类作用
 **/
object BindingAdapter {

    @BindingAdapter(value =["imageUrl","placeholder"] ,requireAll = false)
    @JvmStatic
    fun setImageSrc(imgView: ImageView,url: String?,placeholder: Drawable? = ResourceUtils.getDrawable(R.drawable.ic_launcher)){
        url?.let {
            Glide.with(imgView).load(url).placeholder(placeholder).into(imgView)
        }

    }

    @BindingAdapter(value = ["twoText"],requireAll = false)
    @JvmStatic
    fun setText(myTextView: MyTextView,oldText:String,newString:String){
        if (oldText != newString){
            myTextView.setTempText(newString?:"没数据")
            ToastUtils.showShort(newString?:"没数据")
        }
    }



}