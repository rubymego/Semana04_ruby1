package com.example.consulta_productos_rest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {

    private List<Producto> productos;

    public ProductoAdapter(List<Producto> productos) {
        this.productos = productos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto = productos.get(position);
        holder.textViewId.setText("ID: " + producto.getId());
        holder.textViewNombre.setText(producto.getNombre());
        holder.textViewPrecio.setText("Precio: $" + producto.getPrice());
        holder.textViewCategoria.setText("Categoría: " + producto.getCategory());
    }

    @Override
    public int getItemCount() {
        return productos != null ? productos.size() : 0;
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
        TextView textViewId, textViewNombre, textViewPrecio, textViewCategoria;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.textViewId);
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
            textViewPrecio = itemView.findViewById(R.id.textViewPrecio);
            textViewCategoria = itemView.findViewById(R.id.textViewCategoria);
        }
    }
}
