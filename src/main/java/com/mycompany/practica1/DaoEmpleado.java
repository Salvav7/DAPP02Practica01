///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.practica1;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author Ville
// */
//public class DaoEmpleado implements IDao<PojoEmpleado> {
//
//    @Override
//    public boolean guardar(PojoEmpleado p) {
//        Conexion cn = Conexion.getInstancia();
//        TransactionDB t = new TransactionDB(p) {
//            @Override
//            public boolean execute(Connection cn) {
//                try {
//                    String sql = "INSERT INTO empleados (nombre, direccion, telefono) VALUES (?,?,?)";
//                    PreparedStatement pstm = cn.prepareStatement(sql);
//                    pstm.setString(2, p.getNombre());
//                    pstm.setString(3, p.getDireccion());
//                    pstm.setString(4, p.getTelefono());
//                    pstm.execute();
//                    return true;
//                } catch (Exception e) {
//
//                    System.out.println("Error al ejecutar la consulta SQL: " + e);
//                    return false;
//                }
//
//            }
//
//        };
//        return cn.execute(t);
//    }
//
//    @Override
//    public boolean actualizar(PojoEmpleado p) {
//        Conexion cn = Conexion.getInstancia();
//        TransactionDB t = new TransactionDB(p) {
//            @Override
//            public boolean execute(Connection cn) {
//                try {
//                    String sql = "UPDATE empleados SET nombre = ?, direccion = ?, telefono = ? WHERE id = ?";
//                    PreparedStatement pstm = cn.prepareStatement(sql);
//                    pstm.setString(1, p.getNombre());
//                    pstm.setString(2, p.getDireccion());
//                    pstm.setString(3, p.getTelefono());
//                    pstm.execute();
//                    return true;
//                } catch (Exception e) {
//
//                    System.out.println("Error al ejecutar la consulta SQL: " + e);
//                    return false;
//                }
//            }
//        };
//        return cn.execute(t);
//
//    }
//
//    @Override
//    public boolean eliminar(PojoEmpleado p) {
//        Conexion cn = Conexion.getInstancia();
//        TransactionDB t = new TransactionDB(p) {
//            @Override
//            public boolean execute(Connection cn) {
//                try {
//                    String sql = "DELETE FROM empleados WHERE id = ?";
//                    PreparedStatement pstm = cn.prepareStatement(sql);
//                    pstm.setInt(1, p.getId());
//                    pstm.execute();
//                    return true;
//                } catch (Exception e) {
//
//                    System.out.println("Error al ejecutar la consulta SQL: " + e);
//                    return false;
//                }
//            }
//        };
//        return cn.execute(t);
//    }
//
//    @Override
//    public PojoEmpleado findById(long id) {
//        Conexion cn = Conexion.getInstancia();
//        String sql = "SELECT * FROM empleados WHERE id = ?";
//        try {
//            PreparedStatement preparedStatement = cn.getConexion().prepareStatement(sql);
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                return new PojoEmpleado(
//                        resultSet.getString("nombre"),
//                        resultSet.getString("direccion"),
//                        resultSet.getString("telefono")
//                );
//            }
//        } catch (SQLException e) {
//            System.out.println("Error al ejecutar la consulta SQL: " + e);
//        }
//        return null;
//    }
//
//    @Override
//    public List<PojoEmpleado> findAll() {
//        Conexion cn = Conexion.getInstancia();
//        String sql = "SELECT * FROM empleados";
//        List<PojoEmpleado> empleados = new ArrayList<>();
//        try {
//            PreparedStatement preparedStatement = cn.getConexion().prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                PojoEmpleado empleado = new PojoEmpleado(
//                        resultSet.getString("nombre"),
//                        resultSet.getString("direccion"),
//                        resultSet.getString("telefono")
//                );
//                empleados.add(empleado);
//            }
//        } catch (SQLException e) {
//            System.out.println("Error al ejecutar la consulta SQL: " + e);
//        }
//        return empleados;
//    }
//
//}
