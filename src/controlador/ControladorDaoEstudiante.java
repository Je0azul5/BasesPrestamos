/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import vista.CrearEstudiante;
import vista.General;
import Dao.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import vo.Estudiante;

/**
 *
 * @author je0azul5
 */
public class ControladorDaoEstudiante implements ActionListener, Serializable {

    private CrearEstudiante ce;

    public ControladorDaoEstudiante(CrearEstudiante ce) {
        this.ce = ce;
        ce.jButton1.addActionListener(this);
        ce.jButton2.addActionListener(this);
        ce.jButton3.addActionListener(this);
        ce.jButton4.addActionListener(this);
        ce.jButton5.addActionListener(this);
        ce.jButton6.addActionListener(this);
        ce.setVisible(true);
    }

    public void limpiar() {
        ce.jTextField1.setText("");
        ce.jTextField2.setText("");
        ce.jTextField3.setText("");
        ce.jTextField4.setText("");
        ce.jTextField5.setText("");
        ce.jTextField6.setText("");
        ce.jTextField7.setText("");
        ce.jTextField8.setText("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DaoEstudiante x = new DaoEstudiante();
        if (e.getActionCommand().equalsIgnoreCase("volver")) {
            ControladorGeneral g = new ControladorGeneral(new General());
            ce.dispose();
        }
        if (e.getActionCommand().equalsIgnoreCase("crear")) {
            boolean f = true;
            if (ce.jTextField8.getText().equalsIgnoreCase("true")) {
                f = true;
            } else {
                f = false;
            }
            try {
                //  x.agregar(, ce.jTextField2.getText(), ce.jTextField3.getText(), Integer.parseInt(ce.jTextField4.getText()),Integer.parseInt(ce.jTextField5.getText()) ,ce.jTextField6.getText() , Integer.parseInt(ce.jTextField7.getText()),f);
                x.agregar(Integer.parseInt(ce.jTextField1.getText()), ce.jTextField2.getText(), ce.jTextField3.getText(), Integer.parseInt(ce.jTextField4.getText()), ce.jTextField6.getText(), Integer.parseInt(ce.jTextField7.getText()), Integer.parseInt(ce.jTextField5.getText()), f);
            limpiar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Revise los datos");
            }

        }
        if (e.getActionCommand().equalsIgnoreCase("eliminar")) {

            try {
                x.borrar(Integer.parseInt(ce.jTextField1.getText()));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Revise el numero de documento");
            }
        }
        if (e.getActionCommand().equalsIgnoreCase("actualizar")) {

            boolean f = true;
            if (ce.jTextField8.getText().equalsIgnoreCase("true")) {
                f = true;
            } else {
                f = false;
            }

            try {
                x.actualizar(Integer.parseInt(ce.jTextField1.getText()), ce.jTextField2.getText(), ce.jTextField3.getText(), Integer.parseInt(ce.jTextField4.getText()), ce.jTextField6.getText(), Integer.parseInt(ce.jTextField7.getText()), Integer.parseInt(ce.jTextField5.getText()), f
                );
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Revise el numero de documento");

            }
        }
        if (e.getActionCommand().equalsIgnoreCase("buscar")) {
            try {
                Estudiante er = null;
                er = x.buscar(Integer.parseInt(ce.jTextField1.getText()));

                ce.jTextField2.setText(er.getNombre());
                ce.jTextField3.setText(er.getApellido());
                ce.jTextField4.setText(String.valueOf(er.getEdad()));
                ce.jTextField5.setText(String.valueOf(er.getTelefono()));
                ce.jTextField6.setText(er.getCarrera());
                ce.jTextField7.setText(String.valueOf(er.getSemestre()));
                ce.jTextField8.setText(String.valueOf(er.isBloqueo()));

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Revise el numero de documento");
            }

        }

        if (e.getActionCommand().equalsIgnoreCase("limpiar")) {
            limpiar();
        }

    }

}
