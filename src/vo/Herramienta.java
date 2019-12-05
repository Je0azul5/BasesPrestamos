package vo;

import java.io.Serializable;

/**
 *
 * @author je0azul5
 */

public class Herramienta implements Serializable{

    private int id;
    private String nombre;
    private boolean bloqueo;
    private int idEstudiante;

    public Herramienta(int id, String nombre, boolean bloqueo, int idEstudiante) {
        this.id = id;
        this.nombre = nombre;
        this.bloqueo = bloqueo;
        this.idEstudiante = idEstudiante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isBloqueo() {
        return bloqueo;
    }

    public void setBloqueo(boolean bloqueo) {
        this.bloqueo = bloqueo;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public String toString() {
        return "Herramienta{" + "id=" + id + ", nombre=" + nombre + ", bloqueo=" + bloqueo + ", idEstudiante=" + idEstudiante + "}\n";
    }
    

}
