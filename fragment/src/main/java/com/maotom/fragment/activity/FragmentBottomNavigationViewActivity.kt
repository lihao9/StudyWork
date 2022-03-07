package com.maotom.fragment.activity


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.maotom.baselibrary.BActivity
import com.maotom.fragment.R
import com.maotom.fragment.databinding.ActivityFragmentBottomNavigationViewBinding
import com.maotom.fragment.fragment.TabOneFragment
import com.maotom.fragment.fragment.TabThreeFragment
import com.maotom.fragment.fragment.TabTwoFragment

class FragmentBottomNavigationViewActivity : BActivity<ActivityFragmentBottomNavigationViewBinding>() {

    val fragmentList = ArrayList<Fragment>()


    val FRAGMENT_ONE = "fragment_one"
    val FRAGMENT_TWO = "fragment_two"
    val FRAGMENT_THREE = "fragment_three"

    override fun getViewLayout(): Int {
        return R.layout.activity_fragment_bottom_navigation_view
    }

    override fun bindingXml() {
        binding = ActivityFragmentBottomNavigationViewBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.bnv.itemIconTintList = null

        addFragment(savedInstanceState)

        setClickListener()
    }



    private fun addFragment(savedInstanceState: Bundle?) {
        var tabOneFragment: Fragment?
        var tabTwoFragment: Fragment?
        var tabThreeFragment: Fragment?

        if (savedInstanceState!=null){
            tabOneFragment = supportFragmentManager.findFragmentByTag(FRAGMENT_ONE)?:TabOneFragment.newInstance()
            tabTwoFragment = supportFragmentManager.findFragmentByTag(FRAGMENT_ONE)?:TabTwoFragment.newInstance()
            tabThreeFragment = supportFragmentManager.findFragmentByTag(FRAGMENT_ONE)?:TabThreeFragment.newInstance()
        }else{
            tabOneFragment = TabOneFragment.newInstance()
            tabTwoFragment = TabTwoFragment.newInstance()
            tabThreeFragment = TabThreeFragment.newInstance()
        }


        if (!tabOneFragment.isAdded){
            fragmentList.add(tabOneFragment)
            supportFragmentManager.commit {
                add(R.id.fcv, tabOneFragment, FRAGMENT_ONE)
            }
        }

        if (!tabTwoFragment.isAdded){
            fragmentList.add(tabTwoFragment)
            supportFragmentManager.commit {
                add(R.id.fcv,tabTwoFragment,FRAGMENT_TWO)
            }
        }

        if (!tabThreeFragment.isAdded){
            fragmentList.add(tabThreeFragment)
            supportFragmentManager.commit {
                add(R.id.fcv,tabThreeFragment,FRAGMENT_THREE)
            }
        }

//        hideAllFragment()

        showFragment(fragmentList[0],true,FRAGMENT_ONE)
    }

    private fun showFragment(fragment: Fragment, addBackStack: Boolean = false, name: String = "") {


        supportFragmentManager.commit {

//            hideAllFragment()

            fragmentList.forEach {
                hide(it)
            }

            setCustomAnimations(
                R.anim.slide_in,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.slide_out
            )
            show(fragment)
            if (addBackStack){
                addToBackStack(name)
            }
        }
    }


    private fun hideAllFragment() {
        supportFragmentManager.commit {
            fragmentList.forEach {
                hide(it)
            }
        }
    }


    private fun setClickListener() {
        binding.bnv.setOnItemSelectedListener {
            hideAllFragment()
            when(it.itemId){
                R.id.tab_one ->
                    showFragment(fragmentList[0])
                R.id.tab_two ->
                    showFragment(fragmentList[1])
                R.id.tab_three ->
                    showFragment(fragmentList[2])
            }
            true
        }
    }


}