public class TAlumno {

    public String nombre;
    public String apellido;
    public int ci;

    public TAlumno(String nombre, String apellido, int ci) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
    }



    public String toString() {
        return nombre + " " + apellido;
    }
}
