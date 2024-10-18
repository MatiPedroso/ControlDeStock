package controller;

import model.Producto;
import java.io.*;
import java.util.List;

public class ArchivoDB {
    private static final String RUTA_ARCHIVO = "C:\\Users\\matyp\\Desktop\\ProyectoPOO\\Almacen.txt";

    public static void guardarInventario(Inventario inventario) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            oos.writeObject(inventario);
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar errores de escritura
        }
    }

    public static void cargarInventario(Inventario inventario) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA_ARCHIVO))) {
            Inventario inv = (Inventario) ois.readObject();
            inventario.getListaProductos().clear(); // Limpiar lista actual
            inventario.getListaProductos().addAll(inv.getListaProductos()); // Cargar productos
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            // Manejar errores de lectura o archivo no encontrado
        }
    }
}
