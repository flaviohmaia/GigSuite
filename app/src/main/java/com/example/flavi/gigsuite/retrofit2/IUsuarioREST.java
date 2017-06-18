package com.example.flavi.gigsuite.retrofit2;

import com.example.flavi.gigsuite.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by lucasnascimento on 17/06/17.
 */

public interface IUsuarioREST {

    @GET("get")
    Call<List<Usuario>> listarTodosUsuarios();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://gigsuiteapi.esy.es/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}