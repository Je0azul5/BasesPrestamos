/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Dao.DaoEstudiante;
import Dao.DaoHerrmienta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.CrearHerramienta;
import vista.General;
import vo.Herramienta;

/**
 *
 * @author je0azul5
 */
public class ControladorDaoHeramienta implements ActionListener, Serializable {

    private CrearHerramienta h;

    public ControladorDaoHeramienta(CrearHerramienta h) {
        this.h = h;
        h.jButton1.addActionListener(this);
        h.jButton2.addActionListener(this);
        h.jButton3.addActionListener(this);
        h.jButton4.addActionListener(this);
        h.jButton5.addActionListener(this);
        h.jButton6.addActionListener(this);
        h.setVisible(true);
    }

    public void limpiar() {
        h.jTextField1.setText("");
        h.jTextField2.setText("");
        h.jTextField3.setText("");
        h.jTextField4.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DaoHerrmienta a = new DaoHerrmienta();
        if (e.getActionCommand().equalsIgnoreCase("volver")) {
            ControladorGeneral g = new ControladorGeneral(new General());
            h.dispose();
        }

        if (e.getActionCommand().equalsIgnoreCase("Limpiar")) {
            limpiar();
        }
        if (e.getActionCommand().equalsIgnoreCase("crear")) {
            boolean f = true;
            if (h.jTextField2.getText().equalsIgnoreCase("true")) {
                f = true;
            } else {
                f = false;
            }
            try {
                a.agregar(Integer.parseInt(h.jTextField3.getText()), h.jTextField1.getText(), f, Integer.parseInt(h.jTextField4.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(ControladorDaoHeramienta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getActionCommand().equalsIgnoreCase("buscar")) {
            try {
                Herramienta ff = null;
                ff = a.buscar(Integer.parseInt(h.jTextField3.getText()));
                h.jTextField1.setText(ff.getNombre());
                h.jTextField2.setText(String.valueOf(ff.isBloqueo()));
                h.jTextField4.setText(String.valueOf(ff.getIdEstudiante()));

            } catch (SQLException ex) {
                Logger.getLogger(ControladorDaoHeramienta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getActionCommand().equalsIgnoreCase("actualizar")) {
            try {
                 boolean f = true;
            if (h.jTextField2.getText().equalsIgnoreCase("true")) {
                f = true;
            } else {
                f = false;
            }
            
                    DaoEstudiante d = new DaoEstudiante();
                if (d.buscar(Integer.parseInt(h.jTextField4.getText())) != null || h.jTextField4.getText().equals("0") ) {
                       a.actualizar(Integer.parseInt(h.jTextField3.getText()), h.jTextField1.getText(), f, Integer.parseInt(h.jTextField4.getText()));
            
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(ControladorDaoHeramienta.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getActionCommand().equalsIgnoreCase("eliminar")) {
            try {
                a.borrar(Integer.parseInt(h.jTextField3.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(ControladorDaoHeramienta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
