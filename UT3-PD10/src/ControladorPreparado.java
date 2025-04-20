public class ControladorPreparado {

    private Lista<Suero> sueros;
    private Lista<Farmaco> farmacos;
    private Lista<Integer> listaBlanca;
    private Lista<ParejaSueroFarmaco> listaNegra;

    public ControladorPreparado(Lista<Suero> sueros, Lista<Farmaco> farmacos,
                                Lista<Integer> blanca, Lista<ParejaSueroFarmaco> negra) {
        this.sueros = sueros;
        this.farmacos = farmacos;
        this.listaBlanca = blanca;
        this.listaNegra = negra;
    }

    public boolean preparadoViable(int idSuero, Lista<Integer> idsFarmacos) { //O(N al cuadrado)
        if (sueros.buscar(idSuero) == null) return false;

        Nodo<Integer> actual = idsFarmacos.getPrimero();
        while (actual != null) {
            Integer idFarmaco = actual.getDato();
            if (farmacos.buscar(idFarmaco) == null) return false;

            if (listaBlanca.buscar(idFarmaco) != null) {
                actual = actual.getSiguiente();
                continue;
            }

            Nodo<ParejaSueroFarmaco> nodoNegro = listaNegra.getPrimero();
            while (nodoNegro != null) {
                ParejaSueroFarmaco p = nodoNegro.getDato();
                if (p.getIdSuero() == idSuero && p.getIdFarmaco() == idFarmaco) {
                    return false;
                }
                nodoNegro = nodoNegro.getSiguiente();
            }
            actual = actual.getSiguiente();
        }

        return true;
    }
}