/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;
import java.sql.*;
/**
 *
 * @author je0azul5
 */
public class Conexion {
    private static Connection cnx = null;
   /*
    public static Connection obtener() throws SQLException, ClassNotFoundException {
      if (cnx == null) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProyectoBases", "root", "Itaita07");
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      }
      return cnx;
   }
  */ 
    public static Connection conex(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cnx=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ProyectoBases","root","Itaita07");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return cnx;
    }   
   
   public static void cerrar() throws SQLException {
      if (cnx != null) {
         cnx.close();
      }
   }
   
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(conex());
        
       
    }
}
