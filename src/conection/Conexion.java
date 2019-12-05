/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import java.io.Serializable;
import java.sql.*;

/**
 *
 * @author je0azul5
 */
public class Conexion implements Serializable{

   private Connection cnx = null;

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }
   
   
    public  Connection conex() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/proyecto", "root", "Itaita07");
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cnx;
    }

    public  void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }
/*
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       // System.out.println(conex());
        Conexion cx = new Conexion();
        cx.conex();
        
        Statement statement = cx.getCnx().createStatement();
        ResultSet rs = statement.executeQuery("SELECT * from Estudiante");

        while (rs.next()) {

            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String edad = rs.getString("edad");
            String carrera = rs.getString("carrera");
            String semestre = rs.getString("semestre");
            String telefono = rs.getString("telefono");
            String bloqueo = rs.getString("bloqueo");

            System.out.println(String.format("%d, %s %s, %s,%s, %s, %s,%s ", id, nombre, apellido, edad, carrera, semestre, telefono, bloqueo));
        }

        rs.close();
        statement.close();
        cx.cerrar();

    }
    */

  
}
