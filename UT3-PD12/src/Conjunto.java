
/**
 *
 * @author ernesto
 * @param <T>
 */
public class Conjunto<T> extends ListaOrdenada<T> implements IConjunto {
// MEJOR: public class Conjunto<T> extends ListaOrdenada<T> implements IConjunto {

    @Override
    public Conjunto union(Conjunto otroConjunto) {
        Conjunto<T> resultado = new Conjunto<>();

        Nodo<T> nodo1 = this.getPrimero();
        Nodo<T> nodo2 = ((Lista<T>) otroConjunto).getPrimero();

        while (nodo1 != null && nodo2 != null) {
            int comparador = nodo1.getEtiqueta().compareTo(nodo2.getEtiqueta());

            if (comparador < 0) {
                resultado.insertar(nodo1.clonar());
                nodo1 = nodo1.getSiguiente();
            } else if (comparador > 0) {
                resultado.insertar(nodo2.clonar());
                nodo2 = nodo2.getSiguiente();
            } else {
                resultado.insertar(nodo1.clonar());
                nodo1 = nodo1.getSiguiente();
                nodo2 = nodo2.getSiguiente();
            }
        }
        while (nodo1 != null) {
            resultado.insertar(nodo1.clonar());
            nodo1 = nodo1.getSiguiente();
        }

        while (nodo2 != null) {
            resultado.insertar(nodo2.clonar());
            nodo2 = nodo2.getSiguiente();
        }

        return resultado;
    }

    @Override
    public Conjunto interseccion(Conjunto otroConjunto) {
        Conjunto<T> resultado = new Conjunto<>();

        Nodo<T> nodo1 = this.getPrimero();
        Nodo<T> nodo2 = ((Lista<T>) otroConjunto).getPrimero();

        while (nodo1 != null && nodo2 != null) {
            int comparador = nodo1.getEtiqueta().compareTo(nodo2.getEtiqueta());

            if (comparador < 0) {
                nodo1 = nodo1.getSiguiente();
            } else if (comparador > 0) {
                nodo2 = nodo2.getSiguiente();
            } else {
                resultado.insertar(nodo1.clonar());
                nodo1 = nodo1.getSiguiente();
                nodo2 = nodo2.getSiguiente();
            }
        }

        return resultado;
    }
}
