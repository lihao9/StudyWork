package com.maotom.fragment.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.transition.TransitionInflater
import com.maotom.fragment.R
import com.maotom.fragment.databinding.FragmentShowImgBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ShowImgFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShowImgFragment : Fragment() {

    lateinit var binding: FragmentShowImgBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.share_img)

        sharedElementEnterTransition = sharedElementEnterTransition

//        val inflater = TransitionInflater.from(requireContext())
//        enterTransition = inflater.inflateTransition(R.transition.slide)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowImgBinding.inflate(layoutInflater,container,false)
//        ViewCompat.setTransitionName(binding.iv, "hero_image")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment ShowImgFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = ShowImgFragment()
    }
}