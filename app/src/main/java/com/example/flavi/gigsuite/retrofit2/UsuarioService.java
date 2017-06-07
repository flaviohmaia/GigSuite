package com.example.flavi.gigsuite.retrofit2;

import com.example.flavi.gigsuite.Entity.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by root on 06/06/17.
 */

public interface UsuarioService {

    @GET("usuario")
    Call<List<Usuario>> getUsuarios();
}
