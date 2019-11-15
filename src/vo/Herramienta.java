package vo;

/**
 *
 * @author je0azul5
 */

public class Herramienta {

    private int id;
    private String nombre;
    private int cantidad;
    private boolean bloqueo;
    private int estudiante;

    public Herramienta(int id, String nombre, int cantidad, boolean bloqueo, int estudiante) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.bloqueo = bloqueo;
        this.estudiante = estudiante;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isBloqueo() {
        return bloqueo;
    }

    public void setBloqueo(boolean bloqueo) {
        this.bloqueo = bloqueo;
    }

    public int getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(int estudiante) {
        this.estudiante = estudiante;
    }

    
    
    
}
