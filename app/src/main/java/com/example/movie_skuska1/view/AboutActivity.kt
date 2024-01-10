package com.example.movie_skuska1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.movie_skuska1.viewModel.AboutViewModel
import com.example.movie_skuska1.databinding.AboutActivityLayoutBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

    //About page logic
class AboutActivity : AppCompatActivity() {
    private lateinit var binding : AboutActivityLayoutBinding
    private lateinit var aboutViewModel : AboutViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AboutActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Suporting Action Bar
        setSupportActionBar(binding.myToolbarAbout.myToolbar)

        //Initializing FA buttons to binding objects
        val fab1: FloatingActionButton = binding.myToolbarAbout.fab1
        val fab2: FloatingActionButton = binding.myToolbarAbout.fab2
        val fab3: FloatingActionButton = binding.myToolbarAbout.fab3

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

        //Initializing ViewModel
        aboutViewModel = ViewModelProvider(this)[AboutViewModel::class.java]

        //Observing data in about info
        val textViewAbout : TextView = binding.textView
        aboutViewModel.aboutInfo.observe(this,) {
            textViewAbout.text = it
        }

    }
}