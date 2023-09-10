package com.example.kinopoiskmyversion.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kinopoiskmyversion.R
import com.example.kinopoiskmyversion.api.search.Data
import com.example.kinopoiskmyversion.databinding.ItemForRecycleViewBinding

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
        val binding = ItemForRecycleViewBinding.inflate(inflater, parent, false)
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
            titleRuRecycler.text = searchMovieData.name
            titleEnRecycler.text = searchMovieData.alternativeName
            ratingRecycler.text = searchMovieData.rating.toString()
            yearOfProductionRecycler.text = searchMovieData.year.toString()
            searchMovieData.poster.let {
                Glide.with(context)
                .load(searchMovieData.poster)
                .centerCrop()
                .placeholder(R.drawable.background_gradient)
                .into(posterRecycler)
            }
            root.setOnClickListener{
                onClick(searchMovieData)
            }
        }

    }

    class MovieViewHolder(
        val binding: ItemForRecycleViewBinding
    ) : RecyclerView.ViewHolder(binding.root)

}