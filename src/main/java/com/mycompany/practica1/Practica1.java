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
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        DAOVenta dven = new DAOVenta();

        long id = 1; 
        Venta ven = dven.findById(id);

        if (ven != null) {
            ven.setCliente("Salvador");
            ven.setFechaventa(new java.sql.Date(new Date().getTime()));
            ven.setTotal(2000);
            dven.actualizar(ven);
            System.out.println("Exito");

        } else {
            System.out.println("Error");
        }

    }

}
