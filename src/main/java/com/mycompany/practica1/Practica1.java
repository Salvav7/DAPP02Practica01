package com.mycompany.practica1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Practica1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DAOVenta dao = new DAOVenta();
        int opcion;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Guardar");
            System.out.println("2. Actualizar");
            System.out.println("3. Eliminar");
            System.out.println("4. Buscar Id");
            System.out.println("5. Buscar todo");
            System.out.println("0. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    guardarVenta(scanner, dao);
                    break;
                case 2:
                    actualizarVenta(scanner, dao);
                    break;
                case 3:
                    eliminarVenta(scanner, dao);
                    break;
                case 4:
                    buscarVentaPorId(scanner, dao);
                    break;
                case 5:
                    mostrarTodasLasVentas(dao);
                    break;
                case 0:
                    break;
            }
        } while (opcion != 0);
    }

    private static void guardarVenta(Scanner scanner, DAOVenta dao) {
        System.out.println("Nueva Venta:");
        System.out.print("Cliente: ");
        String cliente = scanner.nextLine();
        System.out.print("Total: ");
        double total = scanner.nextDouble();
        scanner.nextLine();
        Venta venta = new Venta();
        venta.setCliente(cliente);
        venta.setTotal(total);
        venta.setFechaventa(new java.sql.Date(new Date().getTime()));
        System.out.println("Detalle Venta:");
        List<DetalleVenta> detalles = new ArrayList<>();
        while (true) {
            System.out.print("Producto: ");
            String producto = scanner.nextLine();
            if (producto.equals("0")) {
                break;
            }
            System.out.print("Cantidad: ");
            double cantidad = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Precio: ");
            double precio = scanner.nextDouble();
            scanner.nextLine();
            DetalleVenta detalle = new DetalleVenta();
            detalle.setProducto(producto);
            detalle.setCantidad(cantidad);
            detalle.setPrecio(precio);
            detalle.setVenta(venta);
            detalles.add(detalle);
        }
        venta.setDetalleventa(detalles);
        dao.guardar(venta);
        System.out.println("Exito");

    }

    private static void actualizarVenta(Scanner scanner, DAOVenta dao) {
        System.out.print("Ingrese el ID de la venta que desea actualizar: ");
        long idVenta = scanner.nextLong();
        scanner.nextLine();
        Venta venta = dao.findById(idVenta);
        if (venta == null) {
            System.out.println("No se encontró una venta con ese ID.");
            return;
        }
        System.out.print("Cliente: ");
        String nuevoCliente = scanner.nextLine();
        System.out.print("Total: ");
        double nuevoTotal = scanner.nextDouble();
        scanner.nextLine();
        venta.setCliente(nuevoCliente);
        venta.setTotal(nuevoTotal);
        dao.actualizar(venta);

        System.out.println("Actualizado exitosamente");
    }

    private static void eliminarVenta(Scanner scanner, DAOVenta dao) {
        System.out.print("Ingrese el ID de la venta que desea eliminar: ");
        long idVenta = scanner.nextLong();
        scanner.nextLine();

        Venta venta = dao.findById(idVenta);
        if (venta == null) {
            System.out.println("No se encontró una venta con ese ID.");
            return;
        }

        dao.eliminar(venta);
        System.out.println("Venta eliminada exitosamente.");
    }

    private static void buscarVentaPorId(Scanner scanner, DAOVenta dao) {
        System.out.println("Ingrese el ID de la venta:");
        long id = scanner.nextLong();
        scanner.nextLine();

        Venta venta = dao.findById(id);
        if (venta != null) {
            System.out.println("ID: " + venta.getIdVenta());
            System.out.println("Cliente: " + venta.getCliente());
            System.out.println("Fecha: " + venta.getFechaventa());
            System.out.println("Total: " + venta.getTotal());
        } else {
            System.out.println("No se encontró ninguna venta con ese ID.");
        }
    }

    private static void mostrarTodasLasVentas(DAOVenta dao) {
        List<Venta> ventas = dao.findAll();
        if (!ventas.isEmpty()) {
            System.out.println("Ventas:");
            for (Venta venta : ventas) {
                System.out.println("ID: " + venta.getIdVenta());
                System.out.println("Cliente: " + venta.getCliente());
                System.out.println("Fecha: " + venta.getFechaventa());
                System.out.println("Total: " + venta.getTotal());
                List<DetalleVenta> detalles = venta.getDetalleventa();
                for (DetalleVenta detalle : detalles) {
                    System.out.println("   ID detalle :" + detalle.getId());
                    System.out.println("   Producto :" + detalle.getProducto());
                    System.out.println("   Cantidad :" + detalle.getCantidad());
                    System.out.println("   Precio :" + detalle.getPrecio());
                }
            }
        } else {
            System.out.println("No hay ventas");
        }

        
    }

}
