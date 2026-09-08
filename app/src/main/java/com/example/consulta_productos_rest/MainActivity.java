package com.example.consulta_productos_rest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductoAdapter adapter;
    private TextInputEditText editTextNombre, editTextPrecio, editTextCategoria;
    private Button buttonAdd;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerViewProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        adapter = new ProductoAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextPrecio = findViewById(R.id.editTextPrecio);
        editTextCategoria = findViewById(R.id.editTextCategoria);
        buttonAdd = findViewById(R.id.buttonAdd);

        apiService = RetrofitClient.getClient().create(ApiService.class);

        buttonAdd.setOnClickListener(v -> agregarProducto());

        obtenerProductos();
    }

    private void obtenerProductos() {
        Call<List<Producto>> call = apiService.getProductos();

        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setProductos(response.body());
                } else {
                    Toast.makeText(MainActivity.this, "Error en la respuesta", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void agregarProducto() {
        String nombre = editTextNombre.getText().toString().trim();
        String precioStr = editTextPrecio.getText().toString().trim();
        String categoria = editTextCategoria.getText().toString().trim();

        if (nombre.isEmpty() || precioStr.isEmpty() || categoria.isEmpty()) {
            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        double precio = Double.parseDouble(precioStr);
        Producto nuevoProducto = new Producto(0, nombre, precio, categoria);

        Call<Producto> call = apiService.addProducto(nuevoProducto);
        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.addProducto(response.body());
                    Toast.makeText(MainActivity.this, "Producto agregado con éxito", Toast.LENGTH_SHORT).show();
                    limpiarCampos();
                    recyclerView.scrollToPosition(0);
                } else {
                    Toast.makeText(MainActivity.this, "Error al agregar producto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void limpiarCampos() {
        editTextNombre.setText("");
        editTextPrecio.setText("");
        editTextCategoria.setText("");
        editTextNombre.requestFocus();
    }
}
