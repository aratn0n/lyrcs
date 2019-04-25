package com.lyrcs.presentation.ui.searchlyrics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.lyrcs.domain.common.ResultState
import com.lyrcs.presentation.R
import com.lyrcs.presentation.display.SearchResultDisplay
import com.lyrcs.presentation.ui.base.BaseFragment
import com.lyrcs.presentation.ui.searchresult.FragmentSearchResult
import kotlinx.android.synthetic.main.fragment_search_lyrics.*
import org.jetbrains.anko.bundleOf
import javax.inject.Inject

class FragmentSearchLyrics: BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModelSearchTracks: ViewModelSearchTracks by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ViewModelSearchTracks::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_search_lyrics, container, false)

    override fun initView() {
        super.initView()
        setEnabledBackButton(false)
        viewModelSearchTracks.getSearchTracksLiveData().observe(viewLifecycleOwner,
            Observer { result -> handleResult(result, {
                hideLoading()
                if(result is ResultState.Success<List<SearchResultDisplay>>)
                {
                    bundleOf(FragmentSearchResult.DISPLAY_KEY to ArrayList(result.data))
                        .run {
                            putParcelableArrayList(FragmentSearchResult.DISPLAY_KEY, ArrayList(result.data))
                            findNavController().navigate( R.id.nav_to_search_result, this)
                        }
                }
            }, {
                hideLoading()
                showErrorDialog()
            }) }
        )
        searchButton.setOnClickListener{ clickSearch() }
    }

    private fun clickSearch() {
        showLoading()
        viewModelSearchTracks.searchLyrics(songTitileEditText.text.toString(),
            artistEditText.text.toString())
    }
}