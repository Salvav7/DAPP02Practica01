package com.mycompany.practica1;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DAOVenta implements IDao<Venta> {

    @Override
    public boolean guardar(Venta p) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();

        Transaction tran = session.beginTransaction();
        session.save(p);

        tran.commit();
        System.out.println("Se guardo con el id:" + p.getIdVenta());
        return true;

    }

    @Override
    public boolean actualizar(Venta p) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.update(p);
            session.getTransaction().commit();
            System.out.println("Actualizado");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(Venta p) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tran = session.beginTransaction();
        session.delete(p);

        tran.commit();
        System.out.println("Eliminado");
        return true;
    }

    @Override
    public Venta findById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Venta venta = session.get(Venta.class, id);
            session.getTransaction().commit();
            return venta;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Venta> findAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tran = session.beginTransaction();
        List<Venta> ventas = session.createQuery("FROM Venta", Venta.class).list();
        tran.commit();
        return ventas;
    }

}
