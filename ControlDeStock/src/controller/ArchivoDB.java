package controller;

import model.Producto;
import java.io.*;
import java.util.List;

public class ArchivoDB {
    private static final String FILE_NAME = "inventario.txt";

    public static void guardarInventario(Inventario inventario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Producto producto : inventario.getProductos()) {
                writer.write(producto.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cargarInventario(Inventario inventario) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String nombre = parts[1];
                int cantidad = Integer.parseInt(parts[2]);
                double precio = Double.parseDouble(parts[3]);
                Producto producto = new Producto(id, nombre, cantidad, precio);
                inventario.agregarProducto(producto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
