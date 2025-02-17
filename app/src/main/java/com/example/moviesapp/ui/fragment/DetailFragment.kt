package com.example.moviesapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)


        val bundle: DetailFragmentArgs by navArgs()
        val gelenDeyer = bundle.movie

        binding.movieObject = gelenDeyer
        binding.detailToolbar = gelenDeyer.name

        val url = "http://kasimadalan.pe.hu/filmler_yeni/resimler/${gelenDeyer.picture}"
        Glide.with(this).load(url).override(500, 750).into(binding.imgDetail)
        return binding.root
    }
}