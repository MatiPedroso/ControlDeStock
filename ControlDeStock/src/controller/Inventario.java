package controller;

import model.Producto;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String id) {
        productos.removeIf(producto -> producto.getId().equals(id));
    }

    public Producto buscarProducto(String id) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
