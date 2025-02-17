package com.example.moviesapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.data.entity.Movies
import com.example.moviesapp.databinding.CardViewBinding
import com.example.moviesapp.ui.fragment.MainFragmentDirections
import com.google.android.material.snackbar.Snackbar

class MoviesAdapter(private var context: Context, private var moviesList: List<Movies>) :
    RecyclerView.Adapter<MoviesAdapter.cardHolder>() {

    inner class cardHolder(var view: CardViewBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardHolder {
        val binding = CardViewBinding.inflate(LayoutInflater.from(context), parent, false)
        return cardHolder(binding)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: cardHolder, position: Int) {
        val movies = moviesList[position]
        val holder1 = holder.view

        val url = "http://kasimadalan.pe.hu/filmler_yeni/resimler/${movies.picture}"
        Glide.with(context).load(url).override(500, 750).into(holder1.imgMovie)

        holder1.txtPrice.text = "${movies.price}"

        holder1.btnBasket.setOnClickListener {
            Snackbar.make(it, "Sepete Eklendi", Snackbar.LENGTH_SHORT).show()
        }
        holder1.movieCard.setOnClickListener {
            val transition = MainFragmentDirections.transitionDetail(movies)
            Navigation.findNavController(it).navigate(transition)
        }
    }
}