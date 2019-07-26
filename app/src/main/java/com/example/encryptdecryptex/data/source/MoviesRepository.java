package com.example.encryptdecryptex.data.source;

import com.example.encryptdecryptex.data.source.remote.RemoteDatasource;

public class MoviesRepository implements MoviesDataSource {

    RemoteDatasource remoteDatasource;
    public MoviesRepository() {
        remoteDatasource = new RemoteDatasource();
    }

    @Override
    public void getMovies(MoviesCallBack moviesCallBack) {
        remoteDatasource.getMovies(moviesCallBack);
    }
}
