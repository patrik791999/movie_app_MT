package com.example.movie_skuska1.viewModel

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.movie_skuska1.R


class HomeViewModel : ViewModel() {

    val videoUri: Uri = Uri.parse("android.resource://com.example.movie_skuska1/" + R.raw.popcorn)
}