//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Conjunto<TAlumno> curso1 = new Conjunto<>();
        Conjunto<TAlumno> curso2 = new Conjunto<>();

        TAlumno a1 = new TAlumno("Facundo", "Piriz",1001);
        TAlumno a2 = new TAlumno( "Thiago", "Garcia", 1002);
        TAlumno a3 = new TAlumno("Santiago", "Piriz", 1003);
        TAlumno a4 = new TAlumno("Agostina", "Etchebarren", 1004);

        curso1.insertar(a1, a1.ci);
        curso1.insertar(a2, a2.ci);
        curso2.insertar(a2, a2.ci);
        curso2.insertar(a3, a3.ci);
        curso2.insertar(a4, a4.ci);

        System.out.println("Alumnos en al menos un curso:");
        curso1.union(curso2).imprimir();

        System.out.println("");

        System.out.println("Alumnos en ambos cursos:");
        curso1.interseccion(curso2).imprimir();
    }
}