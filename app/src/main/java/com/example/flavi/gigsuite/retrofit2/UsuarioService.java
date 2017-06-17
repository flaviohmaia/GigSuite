package com.example.flavi.gigsuite.retrofit2;

import com.example.flavi.gigsuite.Entity.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UsuarioService {

    @GET("get")
    Call<List<Usuario>> listarTodosUsuarios();

    @GET("usuario/{id}")
    Call<Usuario> listarUsuario(@Path("id")int id);

    @POST("usuario/novo")
    Call<Boolean> inserirUsuario(@Body Usuario usuario);

    @DELETE("usuario/remover")
    Call<Usuario> removerUsuario();

    @PUT("usuario/perfil/atualizar")
    Call<Usuario> atualizarUsuario();

    @GET("login")
    Call<Usuario> login();
}
