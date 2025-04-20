
public class Main {
    public static void main(String[] args) {
    Lista<String> lista =  new Lista<>();

    lista.insertar("Luis", 1);
    lista.insertar("Luis", 1);
    lista.insertar("Luis", 1);
    lista.insertar("Facundo", 2);
    lista.insertar("Thiago", 3);
    lista.insertar("Luis", 1);
    lista.insertar("Santiago", 4);
    lista.insertar("Juan", 5);
    lista.insertar("Luis", 1);
    System.out.println("Original:");
    lista.imprimir();
    System.out.println(" ");
    lista.eliminarDuplicados();
    System.out.println("Después de eliminar los duplicados:");
    lista.imprimir();

    }
}