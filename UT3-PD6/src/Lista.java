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
        public Comparable getEtiqueta() {
            return etiqueta;
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
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.getEtiqueta().equals(clave) || actual.getDato().equals(clave)) {
                return actual.getDato();
            }
            actual = actual.siguiente;
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
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = primero;
        while (actual != null) {
            sb.append(actual.dato).append("\n");
            actual = actual.siguiente;
        }
        return sb.toString();
    }

    @Override
    public String imprimir(String separador) {
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = primero;
        while (actual != null) {
            sb.append(actual.dato).append(separador);
            actual = actual.siguiente;
        }
        return sb.toString();
    }

    @Override
    public int cantElementos() {
        int i = 0;
        Nodo<T> actual = primero;
        while (actual != null) {
            i++;
            actual = actual.siguiente;
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
}
