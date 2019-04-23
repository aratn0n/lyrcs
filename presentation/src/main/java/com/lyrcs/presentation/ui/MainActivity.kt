package com.lyrcs.presentation.ui

import android.os.Bundle
import com.lyrcs.presentation.R
import com.lyrcs.presentation.ui.base.BaseActivity

class MainActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getNavControllerId() = R.id.activityMainHomeHostFragment
}