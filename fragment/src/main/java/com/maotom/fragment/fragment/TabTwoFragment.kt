package com.maotom.fragment.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.maotom.fragment.R
import com.maotom.fragment.databinding.FragmentTabTwoBinding

/**
 * A simple [Fragment] subclass.
 * Use the [TabTwoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TabTwoFragment : Fragment() {

    lateinit var binding: FragmentTabTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTabTwoBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn.setOnClickListener {
            MyDialogFragment().show(parentFragmentManager,"")

//            parentFragmentManager.commit {
//                add(R.id.fcv,MyDialogFragment::class.java,null)
//            }
        }
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
            TabTwoFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}