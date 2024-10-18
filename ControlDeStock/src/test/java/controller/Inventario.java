package controller;

import model.Producto;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> listaProductos;

    public Inventario() {
        this.listaProductos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public void eliminarProducto(String id) {
        listaProductos.removeIf(p -> p.getId().equals(id));
    }

    public void actualizarProducto(Producto productoActualizado) {
        for (Producto p : listaProductos) {
            if (p.getId().equals(productoActualizado.getId())) {
                p.setNombre(productoActualizado.getNombre());
                p.setCantidad(productoActualizado.getCantidad());
                p.setPrecio(productoActualizado.getPrecio());
                break;
            }
        }
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }
}
