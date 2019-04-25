package com.lyrcs.presentation.ui.searchresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.lyrcs.domain.common.ResultState
import com.lyrcs.presentation.R
import com.lyrcs.presentation.display.LyricsDisplay
import com.lyrcs.presentation.ui.adapter.SearchResultAdapter
import com.lyrcs.presentation.ui.base.BaseFragment
import com.lyrcs.presentation.ui.displaylyrics.FragmentDisplayLyrics
import kotlinx.android.synthetic.main.fragment_search_result.*
import org.jetbrains.anko.bundleOf
import javax.inject.Inject

class FragmentSearchResult: BaseFragment() {
    companion object {
        const val DISPLAY_KEY = "DISPLAY"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModelSearchResult: ViewModelSearchResult by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ViewModelSearchResult::class.java)
    }

    private lateinit var searchResultAdapter: SearchResultAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
        = inflater.inflate(R.layout.fragment_search_result, container, false)

    override fun initView() {
        super.initView()
        setEnabledBackButton(true)
        viewModelSearchResult.getSearchLyricsLiveData().observe(viewLifecycleOwner,
            Observer { result -> handleResult(result, {
                hideLoading()
                if(result is ResultState.Success<LyricsDisplay>) {
                    bundleOf(FragmentDisplayLyrics.DISPLAY_KEY to result.data)
                        .run {
                            putParcelable(FragmentDisplayLyrics.DISPLAY_KEY, result.data)
                            findNavController().navigate(R.id.nav_to_display_lyrics, this)
                        }
                }
            }, {
                hideLoading()
                showErrorDialog()
            }) }
        )
        arguments?.apply {
            searchResultAdapter = SearchResultAdapter(getParcelableArrayList(DISPLAY_KEY))
            { searchResultDisplay ->
                viewModelSearchResult.getLyrics(searchResultDisplay.trackId,
                    searchResultDisplay.trackName,
                    searchResultDisplay.artistName)
            }
            searchResultRecyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            searchResultRecyclerView.adapter = searchResultAdapter
        }
    }
}