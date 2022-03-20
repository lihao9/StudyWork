package com.maotom.view_data_binding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.maotom.view_data_binding.databinding.ItemMyAdapterBinding
import com.orhanobut.logger.Logger
import java.util.zip.Inflater

/**
 * 作者  Acer
 * 时间  2022/3/15
 * 作用
 * 更新作者
 * 更新说明
 * 版本
 * 类作用
 **/
class MyAdapter<T:ViewDataBinding>(@Nullable var layoutId:Int): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var data: ArrayList<String> = arrayListOf("tom1","tom2","tom3")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = DataBindingUtil.inflate<T>(LayoutInflater.from(parent.context),
            layoutId,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.btn.setOnClickListener {
            Logger.e("点击")
        }
        holder.tv.text = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class MyViewHolder(var binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root ) {
        val btn = (binding as ItemMyAdapterBinding).itemBtn
        val tv = (binding as ItemMyAdapterBinding).itemTv
    }

}

