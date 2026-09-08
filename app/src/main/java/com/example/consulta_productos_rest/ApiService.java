package com.example.consulta_productos_rest;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("products")
    Call<List<Producto>> getProductos();
}
