package com.maotom.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.maotom.fragment.adapter_click_interface.AdapterItemChildClickListener
import com.maotom.fragment.adapter_click_interface.AdapterItemClickListener
import com.maotom.fragment.databinding.ItemMainBinding

/**
 *   @author:  Mao Tom
 *   @date:  2022/3/5 0005
 *   @description: todo
 *
 */
class MainAdapter: RecyclerView.Adapter<MainViewHolder>(){

    lateinit var data: ArrayList<String>

    var adapterItemClickListener: AdapterItemClickListener? = null

    var adapterItemChildClickListener: AdapterItemChildClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.tv.text = data[position]
        holder.itemView.setOnClickListener {
            adapterItemClickListener?.onItemClickListener(position)
        }

        holder.tv.setOnClickListener {
            adapterItemChildClickListener?.onItemChildClickListener(position)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

}


class MainViewHolder(binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root) {

    val tv = binding.tvItemMain

}