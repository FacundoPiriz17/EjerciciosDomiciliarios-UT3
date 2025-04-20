public class Pila<T> extends Lista<T> {
    private Lista<T> lista;

    public Pila() {
        this.lista = new Lista<>();
    }

    public void push(T dato) {
        lista.insertar(dato, lista.cantElementos());
    }

    public T pop() {
        if (lista.esVacia()) {
            return null;
        }
        Nodo<T> ultimo = lista.getUltimo();
        lista.eliminar(ultimo.getEtiqueta());
        return ultimo.getDato();
    }

    public T tope(){
        return lista.getUltimo().getDato();
    }

    public boolean isEmpty() {
        return lista.esVacia();
    }

    public int size() {
        return lista.cantElementos();
    }

}
