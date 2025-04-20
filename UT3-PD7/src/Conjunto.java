public class Conjunto<T> extends Lista<T> implements IConjunto<T> {

    @Override
    public IConjunto<T> union(IConjunto<T> otroConjunto) {
        Conjunto<T> resultado = new Conjunto<>();

        Nodo<T> nodo1 = this.getPrimero();
        Nodo<T> nodo2 = ((Lista<T>) otroConjunto).getPrimero();

        while (nodo1 != null && nodo2 != null) {
            int comparador = nodo1.getEtiqueta().compareTo(nodo2.getEtiqueta());

            if (comparador < 0) {
                resultado.insertar(nodo1.getDato(), nodo1.getEtiqueta());
                nodo1 = nodo1.getSiguiente();
            } else if (comparador > 0) {
                resultado.insertar(nodo2.getDato(), nodo2.getEtiqueta());
                nodo2 = nodo2.getSiguiente();
            } else {
                resultado.insertar(nodo1.getDato(), nodo1.getEtiqueta());
                nodo1 = nodo1.getSiguiente();
                nodo2 = nodo2.getSiguiente();
            }
        }

        while (nodo1 != null) {
            resultado.insertar(nodo1.getDato(), nodo1.getEtiqueta());
            nodo1 = nodo1.getSiguiente();
        }

        while (nodo2 != null) {
            resultado.insertar(nodo2.getDato(), nodo2.getEtiqueta());
            nodo2 = nodo2.getSiguiente();
        }

        return resultado;
    }

    @Override
    public IConjunto<T> interseccion(IConjunto<T> otroConjunto) {
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
                resultado.insertar(nodo1.getDato(), nodo1.getEtiqueta());
                nodo1 = nodo1.getSiguiente();
                nodo2 = nodo2.getSiguiente();
            }
        }

        return resultado;
    }
}