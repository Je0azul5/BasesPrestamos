/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import conection.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vista.Busqueda;
import vo.Estudiante;
import vo.Herramienta;

/**
 *
 * @author je0azul5
 */
public class DaoTabla {

    ArrayList<Herramienta> a = new ArrayList<>();

    public ArrayList llenar() throws SQLException {

        //-----------------------------------
        try {

            Conexion x = new Conexion();
            x.conex();
            ResultSet rs = x.getCnx().createStatement().executeQuery("SELECT * from Herramienta");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                boolean bloqueo = rs.getBoolean("bloqueo");
                int idEstudiante = rs.getInt("idEstudiante");

                a.add(new Herramienta(id, nombre, bloqueo, idEstudiante));
                //      System.out.println("q_ " + a.toString());
            }
            rs.close();
            x.cerrar();
            //    System.out.println("q_ " + a.toString());
        } catch (Exception e) {
        }

        //-----------------------------------
        return a;
    }

    public void mostrar(Busqueda b) {
        String m[][] = new String[a.size()][3];
        for (int i = 0; i < a.size(); i++) {
            m[i][0] = a.get(i).getNombre();
            m[i][1] = String.valueOf(a.get(i).getId());
            m[i][2] = String.valueOf(a.get(i).getNombre());

        }
        b.jTable2.setModel(new javax.swing.table.DefaultTableModel(
                m, new String[]{
                    "Estudiante", "Id", "nombre"
                }));

    }
    /*
     public static void main(String[] args) throws SQLException {
     DaoTabla x = new DaoTabla();
     ArrayList<Herramienta> f = x.llenar();
     System.out.println(f.toString());
     }
     */

}
