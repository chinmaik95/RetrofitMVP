package com.example.encryptdecryptex.data.source.remote;

import android.util.Log;

import com.example.encryptdecryptex.MainActivity;
import com.example.encryptdecryptex.data.Movie;
import com.example.encryptdecryptex.data.MoviesResponse;
import com.example.encryptdecryptex.data.source.MoviesDataSource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDatasource implements MoviesDataSource {


    private final static String API_KEY = "e9232c4d5fb0731fb6324700bf5e3a05";
    private static final String TAG = RemoteDatasource.class.getSimpleName();
    @Override
    public void getMovies(final MoviesCallBack moviesCallBack) {

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MoviesResponse> call = apiService.getTopRatedMovies(API_KEY);

        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                List<Movie> movies = response.body().getResults();
                moviesCallBack.onMoviesLoaded(movies);
                Log.d(TAG, "Number of movies received: " + movies.size());
                Log.i(TAG,"URL="+ call.request().url().toString());

            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

    }
}
