//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.insertar(4,4);
        lista.insertar(71,71);
        lista.insertar(3,3);
        lista.insertar(6,6);
        lista.insertar(12,12);
        lista.insertar(8,8);
        lista.insertar(35,35);
        lista.insertar(11,11);
        lista.insertar(22,22);
        lista.insertar(17,17);


        lista.imprimir();
        Lista<Integer> listaOrdenada = lista.ordenarParesImpares();
        System.out.println("");
        listaOrdenada.imprimir();
    }
}