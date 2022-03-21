package com.maotom.view_data_binding

import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.blankj.utilcode.util.ResourceUtils
import com.blankj.utilcode.util.ToastUtils
import com.bumptech.glide.Glide
import com.orhanobut.logger.Logger

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
    fun setText(myTextView: MyTextView,oldText:String?,newString:String){
        if (oldText != newString){
            myTextView.setTempText(newString?:"没数据")
            ToastUtils.showShort(newString?:"没数据")
        }
    }

    @BindingAdapter("myTextTitle")
    @JvmStatic
    fun setMyTextTitle(myTextView: MyTextView,oldTitle: String?,newTitle: String){
        if (newTitle != oldTitle){
            Logger.d("新旧值不同")
            myTextView.setTempText(newTitle)
        }else{
            Logger.d("新旧值相同")
        }
    }

    @InverseBindingAdapter(attribute = "myTextTitle")
    @JvmStatic
    fun getMyTextTitle(myTextView: MyTextView):String{
        return myTextView.text.toString()
    }

    @BindingAdapter("myTextTitleAttrChanged")
    @JvmStatic
    fun setAttrChangedListener(view: MyTextView,
                               attrChange: InverseBindingListener
    ){
        view.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                attrChange.onChange()
            }
        })

    }



}