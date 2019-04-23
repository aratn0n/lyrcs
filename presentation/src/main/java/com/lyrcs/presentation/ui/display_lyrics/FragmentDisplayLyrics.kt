package com.lyrcs.presentation.ui.display_lyrics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lyrcs.presentation.R
import com.lyrcs.presentation.ui.base.BaseFragment

class FragmentDisplayLyrics: BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
        = inflater.inflate(R.layout.fragment_display_lyrics, container, false)

    override fun initView() {
        super.initView()
        setEnabledBackButton(true)
    }
}