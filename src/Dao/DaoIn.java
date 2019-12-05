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
import static jdk.nashorn.internal.runtime.Debug.id;
import vo.Administrador;
import vo.Estudiante;

/**
 *
 * @author je0azul5
 */
public class DaoIn implements Serializable {

    private static Conexion x = new Conexion();

    public Administrador buscar(String idB, String pssB) throws SQLException {
        x.conex();
        ResultSet rs = x.getCnx().createStatement().executeQuery("SELECT * from Administrador");
        Administrador e = null;
        while (rs.next()) {

            String id = rs.getString("id");
            String pss = rs.getString("pss");

            if (id.equals(idB) && pss.equals(pssB)) {
                e = new Administrador(id, pss);
                break;
            }
        }
        rs.close();
        x.cerrar();
        if (e == null) {
            JOptionPane.showMessageDialog(null, "Usuario no valido");
        }
        return e;
    }

    public void agregar(String id, String pss) throws SQLException {
        x.conex();
        PreparedStatement ps = x.getCnx().prepareStatement("insert into Administrador(id,pss)values (?,?)");
//        ResultSet rs = x.getCnx().createStatement().executeQuery("insert into Estudiante(id,nombre,apellido,edad,carrera,semestre,telefono,bloqueo)values (?,?,?,?,?,?,?,?)");
        ps.setString(1, id);
        ps.setString(2, pss);

        int in = ps.executeUpdate();
        if (in > 0) {
            JOptionPane.showMessageDialog(null, "Registrado");
        } else {
            JOptionPane.showMessageDialog(null, "No Registrado");
        }
        x.cerrar();
    }

    public void Saludo() throws SQLException {
        x.conex();
        String id ="";
        try (ResultSet rs = x.getCnx().createStatement().executeQuery("select Saludo();")) {
           
            while (rs.next()) {

              id   = rs.getString("Saludo()");
            }
        }
        x.cerrar();
        if (id.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, " no valido");
        }else{
            JOptionPane.showMessageDialog(null, id);
        }

    }/*
    public static void main(String[] args) throws SQLException {
        DaoIn d = new DaoIn();
        d.Saludo();
    }
*/
    }
