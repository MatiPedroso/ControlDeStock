package view;

import controller.Inventario;
import controller.ArchivoDB;
import model.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlDeStock {
    private Inventario inventario;

    public ControlDeStock() {
        inventario = new Inventario();
        ArchivoDB.cargarInventario(inventario);
        crearInterfaz();
    }

    public void crearInterfaz() {
        JFrame frame = new JFrame("Control de Stock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        colocarComponentes(panel);

        frame.setVisible(true);
    }

    private void colocarComponentes(JPanel panel) {
        panel.setLayout(null);

        JLabel etiquetaID = new JLabel("ID:");
        etiquetaID.setBounds(10, 20, 80, 25);
        panel.add(etiquetaID);

        JTextField campoID = new JTextField(20);
        campoID.setBounds(100, 20, 165, 25);
        panel.add(campoID);

        JLabel etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setBounds(10, 50, 80, 25);
        panel.add(etiquetaNombre);

        JTextField campoNombre = new JTextField(20);
        campoNombre.setBounds(100, 50, 165, 25);
        panel.add(campoNombre);

        JLabel etiquetaCantidad = new JLabel("Cantidad:");
        etiquetaCantidad.setBounds(10, 80, 80, 25);
        panel.add(etiquetaCantidad);

        JTextField campoCantidad = new JTextField(20);
        campoCantidad.setBounds(100, 80, 165, 25);
        panel.add(campoCantidad);

        JLabel etiquetaPrecio = new JLabel("Precio:");
        etiquetaPrecio.setBounds(10, 110, 80, 25);
        panel.add(etiquetaPrecio);

        JTextField campoPrecio = new JTextField(20);
        campoPrecio.setBounds(100, 110, 165, 25);
        panel.add(campoPrecio);

        JButton botonAgregar = new JButton("Agregar");
        botonAgregar.setBounds(10, 140, 150, 25);
        panel.add(botonAgregar);

        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(10, 170, 150, 25);
        panel.add(botonGuardar);

        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = campoID.getText();
                String nombre = campoNombre.getText();
                int cantidad = Integer.parseInt(campoCantidad.getText());
                double precio = Double.parseDouble(campoPrecio.getText());
                Producto producto = new Producto(id, nombre, cantidad, precio);
                inventario.agregarProducto(producto);
            }
        });

        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArchivoDB.guardarInventario(inventario);
            }
        });
    }

    public static void main(String[] args) {
        new ControlDeStock();
    }
}