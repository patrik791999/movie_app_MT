package com.example.movie_skuska1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.movie_skuska1.viewModel.AboutViewModel
import com.example.movie_skuska1.databinding.AboutActivityLayoutBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AboutActivity : AppCompatActivity() {
    private lateinit var binding : AboutActivityLayoutBinding
    private lateinit var aboutViewModel : AboutViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AboutActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.myToolbarAbout.myToolbar)

        val fab1: FloatingActionButton = binding.myToolbarAbout.fab1
        val fab2: FloatingActionButton = binding.myToolbarAbout.fab2
        val fab3: FloatingActionButton = binding.myToolbarAbout.fab3

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

        aboutViewModel = ViewModelProvider(this)[AboutViewModel::class.java]

        val textViewAbout : TextView = binding.textView
        aboutViewModel.aboutInfo.observe(this,) {
            textViewAbout.text = it
        }

    }
}