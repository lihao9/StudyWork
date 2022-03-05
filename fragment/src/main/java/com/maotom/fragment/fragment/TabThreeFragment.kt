package com.maotom.fragment.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maotom.fragment.R

/**
 * A simple [Fragment] subclass.
 * Use the [TabThreeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TabThreeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab_three, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment BlankFragment.
         */

        @JvmStatic
        fun newInstance() =
            TabThreeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}