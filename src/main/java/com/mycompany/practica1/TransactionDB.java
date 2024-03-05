/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1;

import java.sql.Connection;

/**
 *
 * @author Ville
 */
public abstract class TransactionDB<T> {

    protected T pojo;

    public TransactionDB(T pojo) {
        this.pojo = pojo;
    }
    
    
    public abstract boolean execute (Connection cn); 

}
