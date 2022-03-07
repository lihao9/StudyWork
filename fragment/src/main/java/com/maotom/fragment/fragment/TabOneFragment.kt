package com.maotom.fragment.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.commit
import androidx.transition.TransitionInflater
import com.maotom.fragment.R
import com.maotom.fragment.databinding.FragmentTabOneBinding

/**
 * A simple [Fragment] subclass.
 * Use the [TabOneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TabOneFragment : Fragment() {
    lateinit var inflate: FragmentTabOneBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflate = FragmentTabOneBinding.inflate(layoutInflater,container,false)



        return inflate.root


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        exitTransition = inflater.inflateTransition(R.transition.fade)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewCompat.setTransitionName(inflate.iv, "item_image")

        inflate.iv.setOnClickListener {
            parentFragmentManager.commit {
                addSharedElement(inflate.iv,"item_image")
                replace(R.id.fcv,ShowImgFragment::class.java,null)
                addToBackStack("")
            }
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
            TabOneFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}