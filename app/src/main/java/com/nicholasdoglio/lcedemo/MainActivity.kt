package com.nicholasdoglio.lcedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nicholasdoglio.lcedemo.ui.EpoxyListFragment

/**
 * @author Nicholas Doglio
 */
class MainActivity : AppCompatActivity() {

    //TODO add more comments
    // TODO tests?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, EpoxyListFragment())
            .commit()
    }
}
