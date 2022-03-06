package com.maotom.fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.maotom.baselibrary.BActivity
import com.maotom.fragment.activity.BMainActivity
import com.maotom.fragment.activity.FragmentBottomNavigationViewActivity
import com.maotom.fragment.adapter_click_interface.AdapterItemChildClickListener
import com.maotom.fragment.adapter_click_interface.AdapterItemClickListener
import com.maotom.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { MainAdapter() }

    val data = arrayListOf("Fragment+RadiaButton","Fragment+BottomNavigationView","FragmentT")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initView()

        setEventListener()
    }



    private fun initView() {
        binding.run {
            rvMain.layoutManager = LinearLayoutManager(this@MainActivity)
            adapter.data = data
            rvMain.adapter = adapter
        }
    }

    private fun setEventListener() {
        adapter.adapterItemClickListener = object : AdapterItemClickListener {
            override fun onItemClickListener(position: Int) {
                doWork(position)
            }
        }

        adapter.adapterItemChildClickListener = object : AdapterItemChildClickListener{
            override fun onItemChildClickListener(position: Int) {
                doWork(position)
            }
        }
    }

    fun doWork(position: Int){
        var intent = Intent()
        when(adapter.data[position]){
            "Fragment+RadiaButton" ->
                intent.setClass(this@MainActivity,BMainActivity::class.java)
            "Fragment+BottomNavigationView" ->
                intent.setClass(this@MainActivity,FragmentBottomNavigationViewActivity::class.java)
        }
        startActivity(intent)

    }
}