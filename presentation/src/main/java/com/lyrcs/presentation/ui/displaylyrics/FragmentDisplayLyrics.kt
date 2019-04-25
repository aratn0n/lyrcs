package com.lyrcs.presentation.ui.displaylyrics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.lyrcs.domain.common.ResultState
import com.lyrcs.presentation.R
import com.lyrcs.presentation.display.LyricsDisplay
import com.lyrcs.presentation.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_display_lyrics.*
import javax.inject.Inject

class FragmentDisplayLyrics: BaseFragment() {
    companion object {
        const val DISPLAY_KEY = "DISPLAY"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModelDisplayLyrics: ViewModelDisplayLyrics by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ViewModelDisplayLyrics::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
        = inflater.inflate(R.layout.fragment_display_lyrics, container, false)

    override fun initView() {
        super.initView()
        setEnabledBackButton(true)
        viewModelDisplayLyrics.getDisplayLyricsLiveData().observe(viewLifecycleOwner,
            Observer {
                result -> handleResult(result,
                {
                    if(result is ResultState.Success<LyricsDisplay>) {
                        updateLyrics(result.data)
                    }
        }, {})
        })
        arguments?.run {
            if(containsKey(DISPLAY_KEY)) {
                viewModelDisplayLyrics.start(getParcelable(DISPLAY_KEY))
            }
        }
    }

    private fun updateLyrics(display: LyricsDisplay) {
        trackNameTextView.text = display.trackName
        artistTextView.text = display.artistName
        lyricsTextView.text = display.lyrics
    }
}