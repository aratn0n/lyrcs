package com.lyrcs.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.lyrcs.presentation.R
import com.lyrcs.presentation.databinding.SearchResultItemBinding
import com.lyrcs.presentation.display.SearchResultDisplay

class SearchResultAdapter(private val searchResultDisplays: List<SearchResultDisplay>,
                          private val clickListener: (SearchResultDisplay) -> Unit)
    : RecyclerView.Adapter<SearchResultAdapter.SearchResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        val bind: SearchResultItemBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.search_result_item, parent, false) as SearchResultItemBinding
        return SearchResultViewHolder(bind)
    }

    override fun getItemCount(): Int = searchResultDisplays.size

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        searchResultDisplays[position].run {
            holder.bind(this)
        }
    }

    inner class SearchResultViewHolder(private val bind: SearchResultItemBinding)
        : RecyclerView.ViewHolder(bind.root) {

        fun bind(searchDisplay: SearchResultDisplay) {
            bind.trackNameTextView.text = searchDisplay.trackName
            bind.artistNameTextView.text = searchDisplay.artistName
            bind.root.setOnClickListener { clickListener(searchDisplay) }
        }
    }
}