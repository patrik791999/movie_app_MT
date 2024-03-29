package com.example.movie_skuska1.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movie_skuska1.network.RetrofitInstance
import com.example.movie_skuska1.data.Result
import com.example.movie_skuska1.data.Movies
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

    //Data for Movie page
class MovieViewModel : ViewModel() {
    private var movieLiveData = MutableLiveData<List<Result>>()

    //Function for getting popular movies from api endpoint using asynchronous request with Callback object
    //this object has successful and failure states
    fun getPopularMovies() {
        RetrofitInstance.api.getPopularMovies("d7bbaa8f2960958c6e0c067bd7a52b31").enqueue(object :
            Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.body()!=null){
                    movieLiveData.value = response.body()!!.results
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
    }

    //Observing live data in Results from api respond
    fun observeMovieLiveData() : LiveData<List<Result>> {
        return movieLiveData
    }
}
