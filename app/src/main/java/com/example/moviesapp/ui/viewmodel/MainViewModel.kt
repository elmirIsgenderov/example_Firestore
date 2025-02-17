package com.example.moviesapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.data.entity.Movies
import com.example.moviesapp.data.repository.MoviesResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var frepo: MoviesResponse) : ViewModel() {


    var moviesList = MutableLiveData<List<Movies>>()


    init {
        movieUpload()
    }

    fun movieUpload() {
        moviesList = frepo.movieUpload()
    }
}