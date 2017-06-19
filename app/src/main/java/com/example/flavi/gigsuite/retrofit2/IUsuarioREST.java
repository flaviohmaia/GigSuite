package com.example.flavi.gigsuite.retrofit2;

import com.example.flavi.gigsuite.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by lucasnascimento on 17/06/17.
 */

public interface IUsuarioREST {

    @GET("get/{uf}/{cidade}/{categoria}/{subcategoria}")
    Call<List<Usuario>> listarFiltroUsuario(
            @Path("uf") String uf,
            @Path("cidade") String cidade,
            @Path("categoria") String categoria,
            @Path("subcategoria") String subcategoria );

    @GET("login/{usuario}/{senha}")
    Call<Usuario> login(
            @Path("usuario") String usuario,
            @Path("senha") String senha );


    @GET("get")
    Call<List<Usuario>> listarTodosUsuarios();

    @GET("getid/{id}")
    Call<Usuario> listarUsuarioPorId(@Path("id") String id);

    @POST("usuario/novo")
    Call<Void> inserirUsuario(@Body Usuario usuario);

    @PUT("usuario/perfil/atualizar/{id}")
    Call<Void> alterarUsuario(@Path("id") String id, @Body Usuario usuario);

    @DELETE("usuario/remover/{id}")
    Call<Void> removerUsuario(@Path("id") String id);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://gigsuiteapi.esy.es/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
