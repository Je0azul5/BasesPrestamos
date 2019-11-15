
package vo;

/**
 *
 * @author je0azul5
 */
public class Salon {
    
    private String nombre;
    private String bloque;
    private int estudiante;
    private int profesor;
    private boolean bloqueo;

    public Salon(String nombre, String bloque, int estudiante, int profesor, boolean bloqueo) {
        this.nombre = nombre;
        this.bloque = bloque;
        this.estudiante = estudiante;
        this.profesor = profesor;
        this.bloqueo = bloqueo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public int getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(int estudiante) {
        this.estudiante = estudiante;
    }

    public int getProfesor() {
        return profesor;
    }

    public void setProfesor(int profesor) {
        this.profesor = profesor;
    }

    public boolean isBloqueo() {
        return bloqueo;
    }

    public void setBloqueo(boolean bloqueo) {
        this.bloqueo = bloqueo;
    }

    
}
