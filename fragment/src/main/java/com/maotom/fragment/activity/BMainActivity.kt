package com.maotom.fragment.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.maotom.baselibrary.BActivity
import com.maotom.fragment.R
import com.maotom.fragment.databinding.ActivityBmainBinding
import com.maotom.fragment.fragment.TabOneFragment
import com.maotom.fragment.fragment.TabThreeFragment
import com.maotom.fragment.fragment.TabTwoFragment

class BMainActivity : BActivity<ActivityBmainBinding>() {

    val tabOneFragment by lazy { TabOneFragment.newInstance() }
    val tabTwoFragment by lazy { TabTwoFragment.newInstance() }
    val tabThreeFragment by lazy { TabThreeFragment.newInstance() }

    var fragmentList: ArrayList<Fragment> = ArrayList()

    val FRAGMENT_ONE = "fragment_one"
    val FRAGMENT_TWO = "fragment_two"
    val FRAGMENT_THREE = "fragment_three"

    override fun getViewLayout(): Int {
        return R.layout.activity_bmain
    }

    override fun bindingXml() {
        binding = ActivityBmainBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.rg.setOnCheckedChangeListener { group, checkedId ->
            var currentFragment: Fragment = tabOneFragment
            when(checkedId){
                R.id.rb_one ->
                    currentFragment = tabOneFragment
                R.id.rb_two ->
                    currentFragment = tabTwoFragment
                R.id.rb_three ->
                    currentFragment = tabThreeFragment
            }

            changeFragment(currentFragment)
        }

//添加方式1一次所有fragment添加进去，通过show和hide控制显示与隐藏
//        addFragment(savedInstanceState)
//        supportFragmentManager.commit {
//            fragmentList.forEach {
//                hide(it)
//            }
//        }

        //添加方式二，通过replace替换显示的fragment
        changeFragment(tabOneFragment)

    }

    private fun addFragment(savedInstanceState: Bundle?) {
        if (!tabOneFragment.isAdded)
            fragmentList.add(tabOneFragment)
        if (!tabTwoFragment.isAdded)
            fragmentList.add(tabTwoFragment)
        if (!tabThreeFragment.isAdded)
            fragmentList.add(tabThreeFragment)
        supportFragmentManager.commit {
            add(R.id.fcv,tabOneFragment,FRAGMENT_ONE)
            add(R.id.fcv,tabTwoFragment,FRAGMENT_TWO)
            add(R.id.fcv,tabThreeFragment,FRAGMENT_THREE)
        }

    }

    private fun changeFragment(fragment:Fragment){
        var tag = if (fragment is TabOneFragment){
            FRAGMENT_ONE
        }else if (fragment is TabTwoFragment){
            FRAGMENT_TWO
        }else{
            FRAGMENT_THREE
        }

        if (!fragmentList.contains(fragment)){
            //fragment未添加
            fragmentList.add(fragment)
            supportFragmentManager.commit {

                replace(R.id.fcv,fragment,tag)
                addToBackStack(tag)
            }
        }else{
            supportFragmentManager.commit {
                replace(R.id.fcv,fragment,tag)
            }
        }
    }
}