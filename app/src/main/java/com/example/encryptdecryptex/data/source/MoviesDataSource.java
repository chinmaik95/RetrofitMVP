package com.example.encryptdecryptex.data.source;

import com.example.encryptdecryptex.data.Movie;

import java.util.List;

public interface MoviesDataSource {

    public void getMovies(MoviesCallBack moviesCallBack);
    interface MoviesCallBack{
        public void onMoviesLoaded(List<Movie> movieList);
    }
}
