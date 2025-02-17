package com.example.moviesapp.data.datasource

import androidx.lifecycle.MutableLiveData
import com.example.moviesapp.data.entity.Movies
import com.google.firebase.firestore.CollectionReference

class MoviesDataSource(private var collection: CollectionReference) {

    fun movieUpload(): MutableLiveData<List<Movies>> {
        val moviesList = MutableLiveData<List<Movies>>()

        collection.get().addOnCompleteListener {
            val list = ArrayList<Movies>()
            for (i in it.result) {
                val movie = i.toObject(Movies::class.java)
                movie.id = i.id
                list.add(movie)
            }
            moviesList.value = list
        }
        return moviesList
    }


}