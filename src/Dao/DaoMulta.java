/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import conection.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vo.Estudiante;
import vo.Multa;

/**
 *
 * @author je0azul5
 */
public class DaoMulta {
    
    private static Conexion x = new Conexion();
    
    public Multa buscar(int idB) throws SQLException {
        x.conex();
        ResultSet rs = x.getCnx().createStatement().executeQuery("SELECT * from Multa");
        Multa e = null;
        while (rs.next()) {
            int id = rs.getInt("id");
            double valor = rs.getDouble("valor");
            boolean blpagada = rs.getBoolean("blpagada");
            int estudiante = rs.getInt("idEstudiante");
            
            if (id == idB) {
                e = new Multa(id, valor, blpagada, estudiante);
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
    
    public void agregar(int id, double valor, boolean blpagada, int estudiante) throws SQLException {
        x.conex();
        PreparedStatement ps = x.getCnx().prepareStatement("insert into Multa(id,valor,blpagada,idEstudiante)values (?,?,?,?)");
//        ResultSet rs = x.getCnx().createStatement().executeQuery("insert into Estudiante(id,nombre,apellido,edad,carrera,semestre,telefono,bloqueo)values (?,?,?,?,?,?,?,?)");
        ps.setInt(1, id);
        ps.setDouble(2, valor);
        ps.setBoolean(3, blpagada);
        ps.setInt(4, estudiante);
        
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
            int in = 0;
            if (buscar(idB) != null) {
                
                Multa c = buscar(idB);
                //    System.out.println(c.toString());
                // ResultSet rs = (ResultSet) x.getCnx().prepareStatement("delete from Estudiante where id = " + idB);
                // Statement s = x.getCnx().executeUpdate("delete from Estudiante where id ="+idB);
                //  PreparedStatement ps = x.getCnx().prepareStatement("insert into Estudiante(id,nombre,apellido,edad,carrera,semestre,telefono,bloqueo)values (?,?,?,?,?,?,?,?)");
                try {
                    System.out.println(x.conex());
                    
                    PreparedStatement ps = x.getCnx().prepareStatement("delete from Multa where id = " + c.getId());
                    in = ps.executeUpdate();
                } catch (Exception e) {
                    System.out.println("algo " + e);
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
    
    public void actualizar(int id, double valor, boolean blpagada, int estudiante) throws SQLException {
        Multa c = buscar(id);
        c.setValor(valor);
        c.setBlpagada(blpagada);
        c.setEstudiante(estudiante);
        // PreparedStatement ps = x.getCnx().prepareStatement("UPDATE Estudiante SET nombre = ?,apellido = ?,edad = ?,carrera = ?,semestre = ?,telefono = ?,bloqueo = ? WHERE id = ?");
        PreparedStatement ps = x.conex().prepareStatement("UPDATE Multa SET valor = " + c.getValor() + ",blpagada = " + c.isBlpagada() + ",idEstudiante =" + c.getEstudiante()+ " WHERE id =" + c.getId() + ";");
        
        int in = ps.executeUpdate();
        
        if (in > 0) {
            JOptionPane.showMessageDialog(null, "Actualizado");
        } else {
            JOptionPane.showMessageDialog(null, "No Actualizado");
        }
        x.cerrar();
    }
   
 
  /*  public static void main(String[] args) throws SQLException {
        
        DaoMulta xx = new DaoMulta();
        //xx.agregar(0, 2000, true, 12);
        // xx.buscar(0);
        //xx.actualizar(0, 4000, true, 123);
        //xx.borrar(0);
    }
    */        
    
}
