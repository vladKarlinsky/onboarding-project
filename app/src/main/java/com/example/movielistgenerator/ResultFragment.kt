package com.example.movielistgenerator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.movielistgenerator.adapter.MovieListAdapter
import com.example.movielistgenerator.databinding.FragmentResultBinding
import com.example.movielistgenerator.model.RecommenderViewModel


class ResultFragment : Fragment() {

    private val sharedViewModel : RecommenderViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentResultBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = sharedViewModel
        binding.moviesList.adapter = MovieListAdapter()

        return binding.root
    }

}