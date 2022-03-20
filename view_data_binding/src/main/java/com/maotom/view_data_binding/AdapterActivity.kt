package com.maotom.view_data_binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.maotom.baselibrary.BaseActivity
import com.maotom.view_data_binding.databinding.ActivityAdapterBinding
import com.maotom.view_data_binding.databinding.ItemMyAdapterBinding

class AdapterActivity : BaseActivity<ActivityAdapterBinding>() {

    val myAdapter by lazy { MyAdapter<ItemMyAdapterBinding>(R.layout.item_my_adapter) }

    override fun getViewLayout(): Int {
        return R.layout.activity_adapter
    }

    override fun bindViewData() {
        binding = ActivityAdapterBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.rv.layoutManager = LinearLayoutManager(this@AdapterActivity)
        binding.rv.adapter = myAdapter

    }
}