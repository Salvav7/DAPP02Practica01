package com.mycompany.practica1;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Practica1 {

    public static void main(String[] args) {

        //Guardar
//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session session = sf.getCurrentSession();
//        Venta ven = new Venta();
//        ven.setCliente("Salva");
//        ven.setTotal(190.00);
//        ven.setFechaventa(new java.sql.Date(new Date().getTime()));
//        for (int i = 0; i < 5; i++) {
//            DetalleVenta det = new DetalleVenta();
//            det.setPrecio(40);
//            det.setProducto("Jaboon" + (i + 1));
//            det.setCantidad(10);
//            det.setVenta(ven);
//
//            ven.getDetalleventa().add(det);
//        }
//        DAOVenta dao = new DAOVenta();
//        dao.guardar(ven);
//        System.out.println("Se guardo con el id:" + ven.getIdVenta());




        //Actualizar
//        DAOVenta dven = new DAOVenta();
//        long id = 3; 
//        Venta ven = dven.findById(id);
//        if (ven != null) {
//            ven.setCliente("Erick");
//            ven.setFechaventa(new java.sql.Date(new Date().getTime()));
//            ven.setTotal(200);
//            dven.actualizar(ven);
//            System.out.println("Exito");
//        } else {
//            System.out.println("Error");
//        }




        //Borrar
        DAOVenta dao = new DAOVenta();
        long id = 2;
        Venta ven = dao.findById(id);

        if (ven != null) {
            dao.eliminar(ven);
            System.out.println("Eliminado");

        } else {
            System.out.println("Error");
        }




          //FindById
//          DAOVenta dao=new DAOVenta();
//          long id = 3;
//          Venta ven=dao.findById(id);
//          if(ven !=null){
//            System.out.println("Id: " + ven.getIdVenta());
//            System.out.println("Cliente: " + ven.getCliente());
//            System.out.println("Fecha: " + ven.getFechaventa());
//            System.out.println("Total: " + ven.getTotal());
//              
//          }else{
//              System.out.println("No se encontro");
//          }
          
          
          
          //FindAll
//          DAOVenta dao=new DAOVenta();
//          List<Venta> ventas=dao.findAll();
//           if (!ventas.isEmpty()) {
//            System.out.println("Ventas:");
//            for (Venta venta : ventas) {
//                System.out.println("ID: " + venta.getIdVenta());
//                System.out.println("Cliente: " + venta.getCliente());
//                System.out.println("Fecha: " + venta.getFechaventa());
//                System.out.println("Total: " + venta.getTotal());
//                System.out.println("--------------------");
//            }
//        } else {
//            System.out.println("Error");
        }
          
        

    }

}
