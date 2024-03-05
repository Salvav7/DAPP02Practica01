/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.practica1;

import java.util.List;

/**
 *
 * @author Ville
 */
public interface IDao <T>{
    
    public boolean guardar(T p);
    public boolean actualizar(T p);
    public boolean eliminar(T p);
    public T findById(long id);
    public List<T> findAll();
    
}
