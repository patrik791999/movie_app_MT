package com.example.movie_skuska1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movie_skuska1.adapter.MovieAdapter
import com.example.movie_skuska1.databinding.MovieActivityLayoutBinding
import com.example.movie_skuska1.viewModel.MovieViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

    //Movie page logic
class MovieActivity : AppCompatActivity() {
    private lateinit var binding : MovieActivityLayoutBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter : MovieAdapter


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = MovieActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Switching light/night mode based on system
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

        //Supporting Action Bar
        setSupportActionBar(binding.myToolbarMovie.myToolbar)

        //Initializing FA buttons to binding objects
        val fab1: FloatingActionButton = binding.myToolbarMovie.fab1
        val fab2: FloatingActionButton = binding.myToolbarMovie.fab2
        val fab3: FloatingActionButton = binding.myToolbarMovie.fab3

        //Set click listeners for starting Intent for new Activity (navigation through app)
        fab1.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        fab2.setOnClickListener{
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }
        fab3.setOnClickListener{
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        //Initializing MovieAdapter
        prepareRecyclerView()

        //Initializing ViewModel, call on getPopularMovies and observe movie LiveData to movieList
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        viewModel.getPopularMovies()
        viewModel.observeMovieLiveData().observe(this, Observer { movieList ->
            movieAdapter.setMovieList(movieList)
        })
    }

        //Function for initializing Movie Adapter for RecViewMovies and setting layout manager
    private fun prepareRecyclerView() {
        movieAdapter = MovieAdapter()
        binding.rvMovies.apply {
            layoutManager = GridLayoutManager(applicationContext,2)
            adapter = movieAdapter
        }
    }
}

