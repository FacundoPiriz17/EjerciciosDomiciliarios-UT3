public class Cola<T> extends Lista<T> {
    private Lista<T> lista;

    public Cola() {
        this.lista = new Lista<>();
    }

    public void PoneEnCola(T dato) {
        lista.insertar(dato, lista.cantElementos()); // Agrega al final
    }

    public T QuitaDeCola() {
        if (lista.esVacia()) return null;

        Nodo<T> primero = lista.getPrimero();
        lista.eliminar(primero.getEtiqueta()); // Elimina el primero
        return primero.getDato();
    }

    public T Frente() {
        if (lista.esVacia()) return null;
        return lista.getPrimero().getDato();
    }

    public boolean IsEmpty() {
        return lista.esVacia();
    }

    public int size() {
        return lista.cantElementos();
    }
}
