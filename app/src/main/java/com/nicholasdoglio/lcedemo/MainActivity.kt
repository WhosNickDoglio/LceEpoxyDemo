package com.nicholasdoglio.lcedemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nicholasdoglio.lcedemo.ui.EpoxyListFragment

//TODO add more comments
//TODO tests?
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, EpoxyListFragment())
            .commit()
    }
}
