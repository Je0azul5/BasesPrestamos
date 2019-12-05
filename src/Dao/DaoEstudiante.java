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
import java.sql.Statement;
import javax.swing.JOptionPane;
import vo.Estudiante;

/**
 *
 * @author je0azul5
 */
public class DaoEstudiante implements Serializable {

    private static Conexion x = new Conexion();

    public Estudiante buscar(int idB) throws SQLException {
        x.conex();
        ResultSet rs = x.getCnx().createStatement().executeQuery("SELECT * from Estudiante");
        Estudiante e = null;
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            int edad = rs.getInt("edad");
            String carrera = rs.getString("carrera");
            int semestre = rs.getInt("semestre");
            int telefono = rs.getInt("telefono");
            boolean bloqueo = rs.getBoolean("bloqueo");

            if (id == idB) {
                e = new Estudiante(id, nombre, apellido, edad, carrera, semestre, telefono, bloqueo);
                break;
            }
        }
        rs.close();
        x.cerrar();
        if (e == null) {
            JOptionPane.showMessageDialog(null, "Estudiante No encontrado");
        }
        return e;
    }

    public void agregar(int id, String nombre, String apellido, int edad, String carrera, int semestre, int telefono, boolean bloqueo) throws SQLException {
        x.conex();
        PreparedStatement ps = x.getCnx().prepareStatement("insert into Estudiante(id,nombre,apellido,edad,carrera,semestre,telefono,bloqueo)values (?,?,?,?,?,?,?,?)");
//        ResultSet rs = x.getCnx().createStatement().executeQuery("insert into Estudiante(id,nombre,apellido,edad,carrera,semestre,telefono,bloqueo)values (?,?,?,?,?,?,?,?)");
        ps.setInt(1, id);
        ps.setString(2, nombre);
        ps.setString(3, apellido);
        ps.setInt(4, edad);
        ps.setString(5, carrera);
        ps.setInt(6, semestre);
        ps.setInt(7, telefono);
        ps.setBoolean(8, bloqueo);

        int in = ps.executeUpdate();
        if (in > 0) {
            JOptionPane.showMessageDialog(null, "Registrado");
        } else {
            JOptionPane.showMessageDialog(null, "No Registrado");
        }
        x.cerrar();
    }
  public void borrar(int idB) throws SQLException {
        try {
         int in=0;
           if (buscar(idB) != null) {
      
            Estudiante c = buscar(idB);
         //    System.out.println(c.toString());
             // ResultSet rs = (ResultSet) x.getCnx().prepareStatement("delete from Estudiante where id = " + idB);
             // Statement s = x.getCnx().executeUpdate("delete from Estudiante where id ="+idB);
             //  PreparedStatement ps = x.getCnx().prepareStatement("insert into Estudiante(id,nombre,apellido,edad,carrera,semestre,telefono,bloqueo)values (?,?,?,?,?,?,?,?)");
                try {
                    System.out.println(x.conex());
                    
                    PreparedStatement ps = x.getCnx().prepareStatement("delete from Estudiante where id = "+c.getId()); 
                    in=ps.executeUpdate();
                } catch (Exception e) {
                    System.out.println("algo "+e);
                }
            
        }
        if (in>0) {
            JOptionPane.showMessageDialog(null, "Borrado");
        }
        x.cerrar();
   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Borrado");
        
        }
        
    }
    public void actualizar(int id, String nombre, String apellido, int edad, String carrera, int semestre, int telefono, boolean bloqueo) throws SQLException {
        Estudiante c = buscar(id);
        c.setApellido(apellido);
        c.setCarrera(carrera);
        c.setEdad(edad);
        c.setNombre(nombre);
        c.setSemestre(semestre);
        c.setTelefono(telefono);
        c.setBloqueo(bloqueo);

        // PreparedStatement ps = x.getCnx().prepareStatement("UPDATE Estudiante SET nombre = ?,apellido = ?,edad = ?,carrera = ?,semestre = ?,telefono = ?,bloqueo = ? WHERE id = ?");
        PreparedStatement ps = x.conex().prepareStatement("UPDATE Estudiante SET nombre = '" + c.getNombre() + "',apellido = '" + c.getApellido() + "',edad =" + c.getEdad() + ",carrera = '" + c.getCarrera() + "',semestre = " + c.getSemestre() + ",telefono = " + c.getTelefono() + ",bloqueo =" + c.isBloqueo() + " WHERE id =" + c.getId() + ";");

        int in = ps.executeUpdate();

        if (in > 0) {
            JOptionPane.showMessageDialog(null, "Actualizado");
        } else {
            JOptionPane.showMessageDialog(null, "No Actualizado");
        }
        x.cerrar();
    }

  /*

    public static void main(String[] args) throws SQLException {
        DaoEstudiante xx = new DaoEstudiante();
   //     try {

        xx.agregar(133, "Laura", "Melo", 22, "artes", 3, 345323, false);
        //    System.out.println(xx.buscar(1000330460).toString());
           xx.actualizar(133, "jose", "luis", 22, "Graduado", 12, 3216564, false);
        
        xx.borrar(133);
        //   } catch (Exception e) {
        //    System.out.println("out");
        //    }
    }
*/
}
