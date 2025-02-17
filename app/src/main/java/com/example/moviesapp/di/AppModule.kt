package com.example.moviesapp.di

import com.example.moviesapp.data.datasource.MoviesDataSource
import com.example.moviesapp.data.repository.MoviesResponse
import com.google.firebase.Firebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.firestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideMoviesDataSource(collection: CollectionReference): MoviesDataSource {
        return MoviesDataSource(collection)
    }

    @Provides
    @Singleton
    fun provideMoviesRepo(fds: MoviesDataSource): MoviesResponse {
        return MoviesResponse(fds)
    }

    @Provides
    @Singleton
    fun provideCollectionReference(): CollectionReference {
        return Firebase.firestore.collection("Filmler")
    }


}