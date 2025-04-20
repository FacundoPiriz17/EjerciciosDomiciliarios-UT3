/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 * @param <T>
 */
public class ListaOrdenada<T> extends Lista<T> {

    @Override
    public void insertar(Nodo<T> unNodo) {
        if (esVacia() || getPrimero().getEtiqueta().compareTo(unNodo.getEtiqueta()) > 0) {
            unNodo.setSiguiente(getPrimero());
            setPrimero(unNodo);
        } else {
            Nodo<T> actual = getPrimero();

            while (actual.getSiguiente() != null &&
                    actual.getSiguiente().getEtiqueta().compareTo(unNodo.getEtiqueta()) < 0) {
                actual = actual.getSiguiente();
            }

            unNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(unNodo);
        }
    }
}