package com.example.kinopoiskmyversion.profile.tabfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kinopoiskmyversion.R
import com.example.kinopoiskmyversion.databinding.ItemForRecycleViewBinding

class TabRecyclerViewAdapter ( // адаптеры идентичны, но я пишу ещё один, так как тут будет слегка изменённый вид в будущем
    val onClick: (SavedCinemaData) -> Unit
):RecyclerView.Adapter<TabRecyclerViewAdapter.CinemaViewHolder>(){ // в конструктор лямбду onClick

    var data: List<SavedCinemaData> = emptyList() //можно ли для рума переиспользовать целиком dataclass cinemadata
        set(newValue){
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CinemaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemForRecycleViewBinding.inflate(inflater, parent, false)
        return CinemaViewHolder(binding)
    }

    override fun getItemCount(): Int = data.count()

    override fun onBindViewHolder(
        holder: CinemaViewHolder,
        position: Int
    ) {
        val savedCinemaData = data[position]
        val context = holder.itemView.context

        with(holder.binding) {
            titleRuRecycler.text = savedCinemaData.name
            titleEnRecycler.text = savedCinemaData.alternativeName
            ratingRecycler.text = savedCinemaData.rating.toString()
            yearOfProductionRecycler.text = savedCinemaData.year.toString()
            savedCinemaData.poster.let {
                Glide.with(context)
                    .load(savedCinemaData.poster)
                    .centerCrop()
                    .placeholder(R.drawable.background_gradient)
                    .into(posterRecycler)
            }
            root.setOnClickListener{
                onClick(savedCinemaData)
            }
        }
    }

    class CinemaViewHolder(
        val binding: ItemForRecycleViewBinding
    ): RecyclerView.ViewHolder(binding.root)

}