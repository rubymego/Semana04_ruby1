package com.example.consulta_productos_rest;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("products")
    Call<List<Producto>> getProductos();

    @POST("products")
    Call<Producto> addProducto(@Body Producto producto);
}
