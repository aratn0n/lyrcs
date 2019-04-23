package com.lyrcs.presentation.ui.search_lyrics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.lyrcs.presentation.R
import com.lyrcs.presentation.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_search_lyrics.*

class FragmentSearchLyrics: BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_search_lyrics, container, false)

    override fun initView() {
        super.initView()
        setEnabledBackButton(false)
        searchButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.fragmentDisplayLyrics, null))
    }
}