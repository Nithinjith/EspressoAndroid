package com.np.espressotestapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), LoginFragment.ILoginFragmentCallBack,
    HomeFragment.IHomeCallBack , ListFragment.IListCallBack,ImageFragment.IImageCallBack{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadLoginFragment()
    }

    private fun loadLoginFragment() {
        var fragment = LoginFragment()
        loadGeneralFragment(fragment, LoginFragment::class.java.name)
    }

    private fun loadHomeFragment() {
        var fragment = HomeFragment()
        loadGeneralFragment(fragment, HomeFragment::class.java.name)
    }

    private fun loadListFragment() {
        var fragment = ListFragment()
        loadGeneralFragment(fragment, ListFragment::class.java.name)
    }

    private fun loadImageFragment() {
        var fragment = ImageFragment()
        loadGeneralFragment(fragment, ImageFragment::class.java.name)
    }

    private fun loadGeneralFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_fragment_container, fragment)
            .addToBackStack(tag)
            .commit()
    }

    override fun loginClickCallBack() {
        loadHomeFragment()
    }

    override fun listClickCallBack() {
        loadListFragment()
    }

    override fun detailClickCallBack() {
        loadImageFragment()
    }

    override fun exitFromAppCallBack() {
        this.finish()
    }

}
