package com.maotom.view_data_binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.blankj.utilcode.util.ToastUtils
import com.maotom.baselibrary.BActivity
import com.maotom.baselibrary.BaseActivity
import com.maotom.view_data_binding.bean.CUser
import com.maotom.view_data_binding.bean.User
import com.maotom.view_data_binding.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    var cUser: CUser? = null

    override fun getViewLayout(): Int {
        return R.layout.activity_main
    }

    override fun bindViewData() {
        binding = DataBindingUtil.setContentView(this,getViewLayout())
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.user = User("tom",26)
        cUser = CUser()
        binding.cuser = cUser?.apply {
            name = "ctom"
            age = 27
        }

        cUser?.apply {
            name = "ctom"
            age = 28
        }

        binding.btnShowData.setOnClickListener {

            cUser?.apply {
                name = "ctom"
                age = 29
            }

            ToastUtils.showShort(binding.tvName.text.toString() + binding.tvAge.text.toString())
        }

    }
}