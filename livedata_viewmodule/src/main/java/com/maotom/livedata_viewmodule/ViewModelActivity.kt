package com.maotom.livedata_viewmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelStore
import com.maotom.baselibrary.BaseActivity
import com.maotom.livedata_viewmodule.databinding.ActivityViewModelBinding
import com.maotom.livedata_viewmodule.viewmodule.CustomViewModel

class ViewModelActivity : BaseActivity<ActivityViewModelBinding, CustomViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
    }

    override fun getViewLayout(): Int {
        TODO("Not yet implemented")
    }

    override fun bindViewData() {
        TODO("Not yet implemented")
    }

    override fun initView(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun initViewModel(): CustomViewModel {

    }
}