package com.maotom.fragment.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.maotom.baselibrary.BActivity
import com.maotom.fragment.R
import com.maotom.fragment.databinding.ActivityShowDialogBinding
import com.maotom.fragment.databinding.DialogShowBinding

class ShowDialogActivity : BActivity<ActivityShowDialogBinding>() {


    override fun getViewLayout(): Int {
        return R.layout.activity_show_dialog
    }

    override fun bindingXml() {
        binding = ActivityShowDialogBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {

        binding.btnShowDialog.setOnClickListener {

            val inflate = DialogShowBinding.inflate(layoutInflater)
            val create = AlertDialog.Builder(this@ShowDialogActivity).setView(inflate.root).create()
            inflate.btnCancel.setOnClickListener {
                create.dismiss()
            }
            create.show()

        }
    }
}