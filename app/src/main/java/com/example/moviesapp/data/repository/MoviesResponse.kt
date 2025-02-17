package com.example.moviesapp.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.moviesapp.data.datasource.MoviesDataSource
import com.example.moviesapp.data.entity.Movies

class MoviesResponse(private var fds: MoviesDataSource) {

    fun movieUpload(): MutableLiveData<List<Movies>> = fds.movieUpload()
}