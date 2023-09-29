package com.example.kinopoiskmyversion.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kinopoiskmyversion.R
import com.example.kinopoiskmyversion.api.search.Data
import com.example.kinopoiskmyversion.databinding.SearchItemForRecycleViewBinding

class SearchRecycleViewAdapter(
    val onClick: (Data) -> Unit
) : RecyclerView.Adapter<SearchRecycleViewAdapter.MovieViewHolder>() {

    var data: List<Data> = emptyList()
        set(newValue) {  // погуглить как устроено new value
            field = newValue
            notifyDataSetChanged() // поискать аналоги этой ф-ции
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SearchItemForRecycleViewBinding.inflate(inflater, parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = data.count()

    override fun onBindViewHolder(
        holder: MovieViewHolder,
        position: Int
    ) {
        val searchMovieData = data[position]
        val context = holder.itemView.context

        with(holder.binding) {
            titleRu.text = searchMovieData.name
            titleEn.text = searchMovieData.alternativeName
            rating.text = searchMovieData.rating.toString()
            yearOfProduction.text = searchMovieData.year.toString()
            searchMovieData.poster.let {
                Glide.with(context)
                .load(searchMovieData.poster)
                .centerCrop()
                .placeholder(R.drawable.background_gradient)
                .into(poster)
            }
            root.setOnClickListener{
                onClick(searchMovieData)
            }
        }

    }

    class MovieViewHolder(
        val binding: SearchItemForRecycleViewBinding
    ) : RecyclerView.ViewHolder(binding.root)

}