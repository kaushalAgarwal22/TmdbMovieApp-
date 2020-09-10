package com.example.tmdbclient.presentation.movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityMovieBinding
import com.example.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

   @Inject
   lateinit var  viewModelFactory: MovieViewModelFactory
   private lateinit var  movieViewModel: MovieViewModel

    private lateinit var  movieBinding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieBinding = DataBindingUtil.setContentView(this,R.layout.activity_movie)

        (application as Injector).createMovieSubComponent().inject(movieActivity = MovieActivity())

         movieViewModel = ViewModelProvider(this,viewModelFactory).get(MovieViewModel::class.java)

          val responseLiveData = movieViewModel.getMovies()

           responseLiveData.observe(this, Observer {

               Log.i("Info",it.toString())
           })

        // DataBind
    }
}