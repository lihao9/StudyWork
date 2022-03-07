package com.maotom.fragment.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.maotom.fragment.R
import com.maotom.fragment.databinding.FragmentMyDialogBinding

/**
 *   @author:  Mao Tom
 *   @date:  2022/3/7 0007
 *   @description: todo
 *
 */
class MyDialogFragment: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return AlertDialog.Builder(requireContext())
            .setMessage("title")
            .setPositiveButton("ok") { _,_ ->
                dismiss()
            }
            .create()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }




}