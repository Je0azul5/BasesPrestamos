/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import conection.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vo.Estudiante;
import vo.Herramienta;

/**
 *
 * @author je0azul5
 */
public class DaoHerrmienta implements Serializable {

    private static Conexion x = new Conexion();

    public Herramienta buscar(int idB) throws SQLException {
        x.conex();
        ResultSet rs = x.getCnx().createStatement().executeQuery("SELECT * from Herramienta");
        Herramienta e = null;
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            boolean bloqueo = rs.getBoolean("bloqueo");
            int idEstudiante = rs.getInt("idEstudiante");

            if (id == idB) {
                e = new Herramienta(id, nombre, bloqueo, idEstudiante);
                break;
            }
        }
        rs.close();
        x.cerrar();
        if (e == null) {
            JOptionPane.showMessageDialog(null, "Herramienta No encontrada");
        } else {
            JOptionPane.showMessageDialog(null, "Herramienta  encontrada");
        }

        return e;
    }

    public void agregar(int id, String nombre, boolean bloqueo, int idEstudiante) throws SQLException {

        Herramienta f = buscar(id);
        try {

            x.conex();
            PreparedStatement ps = x.getCnx().prepareStatement("insert into Herramienta(id,nombre,bloqueo,idEstudiante)values (?,?,?,?)");
//        ResultSet rs = x.getCnx().createStatement().executeQuery("insert into Estudiante(id,nombre,apellido,edad,carrera,semestre,telefono,bloqueo)values (?,?,?,?,?,?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setBoolean(3, bloqueo);
            ps.setInt(4, idEstudiante);

            int in = ps.executeUpdate();
            if (in > 0) {
                JOptionPane.showMessageDialog(null, "Registrado");
            } else {
                JOptionPane.showMessageDialog(null, "No Registrado");
            }
            x.cerrar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registre de nuevo");

        }
    }

    public void borrar(int idB) throws SQLException {
        try {
            int in = 0;
            if (buscar(idB) != null) {

                Herramienta c = buscar(idB);
                //    System.out.println(c.toString());
                // ResultSet rs = (ResultSet) x.getCnx().prepareStatement("delete from Estudiante where id = " + idB);
                // Statement s = x.getCnx().executeUpdate("delete from Estudiante where id ="+idB);
                //  PreparedStatement ps = x.getCnx().prepareStatement("insert into Estudiante(id,nombre,apellido,edad,carrera,semestre,telefono,bloqueo)values (?,?,?,?,?,?,?,?)");
                try {
                    System.out.println(x.conex());

                    PreparedStatement ps = x.getCnx().prepareStatement("delete from Herramienta where id = " + c.getId());
                    in = ps.executeUpdate();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Problema al borrar");
                }

            }
            if (in > 0) {
                JOptionPane.showMessageDialog(null, "Borrado");
            }
            x.cerrar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Borrado");

        }

    }

    public void actualizar(int id, String nombre, boolean bloqueo, int idEstudiante) throws SQLException {
        Herramienta c = buscar(id);
        c.setNombre(nombre);
        c.setBloqueo(bloqueo);
        c.setIdEstudiante(idEstudiante);

        // PreparedStatement ps = x.getCnx().prepareStatement("UPDATE Estudiante SET nombre = ?,apellido = ?,edad = ?,carrera = ?,semestre = ?,telefono = ?,bloqueo = ? WHERE id = ?");
        try {

            PreparedStatement ps = x.conex().prepareStatement("UPDATE Herramienta SET nombre = '" + c.getNombre() + "',bloqueo =" + c.isBloqueo() + ",idEstudiante =" + c.getIdEstudiante() + " WHERE id =" + c.getId() + ";");
            int in = ps.executeUpdate();

            if (in > 0) {
                JOptionPane.showMessageDialog(null, "Actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "No Actualizado");
            }
            x.cerrar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Actualizado +" + e);
        }

    }
    /*
     public static void main(String[] args) throws SQLException {
     DaoHerrmienta xx = new DaoHerrmienta();
     //xx.agregar(4, "Martillo", false, 0);
     //xx.borrar(4);
     //xx.actualizar(2, "Martillo", true, 123);
     //   xx.buscar(2);
     }
     */
}
