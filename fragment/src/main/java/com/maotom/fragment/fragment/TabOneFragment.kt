package com.maotom.fragment.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maotom.fragment.R

/**
 * A simple [Fragment] subclass.
 * Use the [TabOneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TabOneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_one, container, false)
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
            TabOneFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}