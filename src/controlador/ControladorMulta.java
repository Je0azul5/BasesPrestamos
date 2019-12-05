/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Dao.DaoEstudiante;
import Dao.DaoMulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.General;
import vista.GeneralMultas;
import vo.Multa;

/**
 *
 * @author je0azul5
 */
public class ControladorMulta implements ActionListener {

    private GeneralMultas x;

    public ControladorMulta(GeneralMultas x) {
        this.x = x;
        x.jButton1.addActionListener(this);
        x.jButton2.addActionListener(this);
        x.jButton3.addActionListener(this);
        x.jButton4.addActionListener(this);
        x.jButton5.addActionListener(this);
        x.jButton6.addActionListener(this);
        x.setVisible(true);
    }

    public void limpiar() {
        x.jTextField1.setText("");
        x.jTextField2.setText("");
        x.jTextField3.setText("");
        x.jTextField5.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DaoMulta dm = new DaoMulta();

        if (e.getActionCommand().equalsIgnoreCase("agregar")) {
          //  JOptionPane.showMessageDialog(null, "holi");
            boolean f = true;
            if (x.jTextField2.getText().equalsIgnoreCase("true")) {
                f = true;
            } else {
                f = false;
            }
            try {
                DaoEstudiante fw = new DaoEstudiante();
             //   if (fw.buscar(Integer.parseInt(x.jTextField1.getText())) != null) {

                    dm.agregar(Integer.parseInt(x.jTextField1.getText()), Double.parseDouble(x.jTextField2.getText()), f, Integer.parseInt(x.jTextField5.getText()));
                    limpiar();

               // }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorMulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getActionCommand().equalsIgnoreCase("actualizar")) {
            try {
                boolean f = true;
                if (x.jTextField2.getText().equalsIgnoreCase("true")) {
                    f = true;
                } else {
                    f = false;
                }
                DaoEstudiante fw = new DaoEstudiante();
                if (fw.buscar(Integer.parseInt(x.jTextField1.getText())) != null) {
                    dm.actualizar(Integer.parseInt(x.jTextField1.getText()), Double.parseDouble(x.jTextField2.getText()), true, Integer.parseInt(x.jTextField5.getText()));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorMulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getActionCommand().equalsIgnoreCase("borrar")) {
            try {
                dm.borrar(Integer.parseInt(x.jTextField1.getText()));
                limpiar();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorMulta.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getActionCommand().equalsIgnoreCase("volver")) {
            ControladorGeneral s = new ControladorGeneral(new General());
            x.dispose();
        }
        if (e.getActionCommand().equalsIgnoreCase("buscar")) {
            try {
                Multa ff = null;
                ff = dm.buscar(Integer.parseInt(x.jTextField1.getText()));
                x.jTextField2.setText(String.valueOf(ff.getValor()));
                x.jTextField3.setText(String.valueOf(ff.isBlpagada()));
                x.jTextField5.setText(String.valueOf(ff.getEstudiante()));

            } catch (SQLException ex) {
                Logger.getLogger(ControladorDaoHeramienta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getActionCommand().equalsIgnoreCase("Limpiar")) {
            limpiar();
        }

    }

}
