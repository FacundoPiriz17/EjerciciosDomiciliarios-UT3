public class ProgramaPD12 {

    public static void main(String[] args) {

        // instanciar curso BasicoIng...
        Conjunto<Alumno> BasicoIng = new Conjunto<>();
        // cargar alumnos del curso BasicoIng desde el archivo “basico-ing.txt”
       String[] lineasIng = ManejadorArchivosGenerico.leerArchivo("basico-ing.txt");

        for (String linea1 : lineasIng) {
            String[] datos1 = linea1.split(",");
            int codigo = Integer.parseInt(datos1[0]);
            String nombre = datos1[1];
            Alumno a1 = new Alumno(codigo, nombre);
            Nodo<Alumno> nodo = new Nodo<>(codigo, a1);
            BasicoIng.insertar(nodo);
        }

        // instanciar curso BasicoEmp...
        Conjunto<Alumno> BasicoEmp = new Conjunto<>();
        // cargar alumnos del curso BasicoEmp desde el archivo “basico-emp.txt”
        String[] lineasEmp = ManejadorArchivosGenerico.leerArchivo("basico-emp.txt");
        for (String linea2 : lineasEmp) {
            String[] datos2 = linea2.split(",");
            int codigo = Integer.parseInt(datos2[0]);
            String nombre = datos2[1];
            Alumno a = new Alumno(codigo, nombre);
            Nodo<Alumno> nodo = new Nodo<>(codigo, a);
            BasicoEmp.insertar(nodo);
        }

        // generar el curso "integrador101" con los alumnos que están en condiciones de cursarlo  
        // guardar en un archivo "integrador101.txt"- IDEALMENTE ordenados por código de alumno -

        Conjunto<Alumno> integrador101 = BasicoIng.union(BasicoEmp);
        System.out.println(integrador101.imprimir());
        String[] lineasIntegrador = integrador101.imprimir().split("\n");
        ManejadorArchivosGenerico.escribirArchivo("integrador101.txt", lineasIntegrador);


        
        // generar el curso "exigente102" con los alumnos que están en condiciones de cursarlo 
        // guardar en un archivo "exigente102.txt" - IDEALMENTE ordenados por código de alumno -

        Conjunto<Alumno> exigente102 = BasicoIng.interseccion(BasicoEmp);
        System.out.println(exigente102.imprimir());
        String[] lineasExigente = exigente102.imprimir().split("\n");
        ManejadorArchivosGenerico.escribirArchivo("exigente102.txt", lineasExigente);
    }

}
