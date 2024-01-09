package com.example.movie_skuska1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.example.movie_skuska1.viewModel.HomeViewModel
import com.example.movie_skuska1.databinding.HomeActivityLayoutBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton



class HomeActivity : AppCompatActivity() {

    private lateinit var binding : HomeActivityLayoutBinding
    private lateinit var homeViewModel: HomeViewModel

    // declaring a null variable for VideoView
    var simpleVideoView: VideoView? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        //splashscreen new bez dalsej aktivity
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = HomeActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        setSupportActionBar(binding.myToolbarHome.myToolbar)

        val fab1: FloatingActionButton = binding.myToolbarHome.fab1
        val fab2: FloatingActionButton = binding.myToolbarHome.fab2
        val fab3: FloatingActionButton = binding.myToolbarHome.fab3

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
        binding.textView2.setOnClickListener{
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.simpleVideoView.setVideoURI(homeViewModel.videoUri)
        binding.simpleVideoView.requestFocus()
        binding.simpleVideoView.start()

        binding.simpleVideoView.setOnPreparedListener {
            it.isLooping = true
        }

    }

}