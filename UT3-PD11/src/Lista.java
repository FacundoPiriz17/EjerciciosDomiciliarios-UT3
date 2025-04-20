import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lista<T> implements ILista<T> {

    protected class Nodo<T> {

        private final Comparable etiqueta;
        private T dato;
        private Nodo<T> siguiente = null;

        public Nodo(Comparable etiqueta, T dato ) {
            this.etiqueta = etiqueta;
            this.dato = dato;
        }

        public Nodo<T> getSiguiente() {
            return siguiente;
        }

        public T getDato() {
            return dato;
        }
    }

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(T dato, Comparable clave) {
        Nodo<T> nuevoNodo = new Nodo<T>(clave, dato);

        if (primero == null) {
            primero = nuevoNodo;
        } else {
            Nodo<T> actual = primero;

            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    @Override
    public T buscar(Comparable clave) {
        int i = 0;
        Nodo<T> actual = primero;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
            i++;

            if (clave.equals(actual.dato)) {
                return actual.dato;
            }
        }

        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        int i = 0;
        Nodo<T> actual = primero;
        Nodo<T> anterior = null;
        while (actual != null) {
            if (((Comparable) actual.dato).compareTo(clave) == 0) {
                if (anterior == null) {
                    primero = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false;
        
    }

    @Override
    public String imprimir() {
        Nodo<T> actual = primero;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
        return null;
    }

    @Override
    public String imprimir(String separador) {
        Nodo<T> actual = primero;
        while (actual != null) {
            System.out.println(separador + actual.dato);
            actual = actual.siguiente;
        }
        return null;
    }

    @Override
    public int cantElementos() {
        if (primero == null) {
            return 0;
        }
        int i = 0;
        Nodo<T> actual = primero;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
            i++;
        }
        return i;
    }

    @Override
    public boolean esVacia() {
        if (primero == null) {
            return true;
        }
        return false;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public Lista<Integer> ordenarParesImpares() { //O(n log n)
        if (primero == null) return new Lista<>();
        List<Integer> impares = new ArrayList<>();
        List<Integer> pares = new ArrayList<>();
        Nodo<T> actual = primero;

        //O(n)
        while (actual != null) {
            Integer valor = (Integer) actual.getDato();
            if (valor % 2 != 0) {
                impares.add(valor);
            } else {
                pares.add(valor);
            }
            actual = actual.getSiguiente();
        }


        //O(n log n)  https://keepcoding.io/blog/que-es-collections-sort-en-java-y-como-usarlo/
        Collections.sort(impares);
        Collections.sort(pares);

        Lista<Integer> resultado = new Lista<>();

        //O(n)
        for (Integer val : impares) {
            resultado.insertar(val, val);
        }

        //O(n)
        for (Integer val : pares) {
            resultado.insertar(val, val);
        }

        return resultado;

    }

}
