public class Farmaco {
    int id;
    String descripcion;

    public Farmaco(int id, String desc) {
        this.id = id;
        this.descripcion = desc;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }
}