/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Ville
 */
@Entity
@Table(name = "venta")
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "venta_idventa_seq")
    @SequenceGenerator(name = "venta_idventa_seq",
            sequenceName = "venta_idventa_seq",
            allocationSize = 1,
            initialValue = 1)

    @Column(name = "idventa")
    private long idVenta;
    @Column(name = "cliente")
    private String cliente;
    @Column(name = "fecha")
    private Date fechaventa;
    @Column(name = "total")
    private double total;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<DetalleVenta> detalleventa;

    public List<DetalleVenta> getDetalleventa() {
        return detalleventa;
    }
    
    public Venta(){
        detalleventa=new ArrayList<>();
    }

    public void setDetalleventa(List<DetalleVenta> detalleventa) {
        this.detalleventa = detalleventa;
    }

    public long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(long idVenta) {
        this.idVenta = idVenta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
