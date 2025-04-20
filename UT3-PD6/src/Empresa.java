public class Empresa extends Lista<String>{
    public String name;
    private Lista sucursal;

    public Empresa(String name){
        this.name = name;
        this.sucursal = new Lista<String>();
    }

    public void addSucursal(String sucursalA, Comparable etiqueta){
        this.sucursal.insertar(sucursalA,etiqueta);
    }

    public void removeSucursal(String sucursalA){
        this.sucursal.eliminar(sucursalA);
    }

    /*public void getSucursal() { // O(n)
        getSucursal(null);
    }*/

    public void getSucursal(String separador) { // O(n)
        String resultado;
        if (!separador.equals("")) {
            resultado = this.sucursal.imprimir(separador);
        } else {
            resultado = this.sucursal.imprimir();
        }
        System.out.println(resultado);
    }

    public void searchSucursal(String sucursalA){
        if (sucursal.buscar(sucursalA) != null) {
            System.out.println("La sucursal " + sucursal + " existe en la empresa " + this.name);
        } else {
            System.out.println("La sucursal " + sucursal + " no existe en la empresa " + this.name);
        }
    }

    public void countSucursal(){
        System.out.println("La empresa " + this.name + " tiene " + this.sucursal.cantElementos() + " sucursales.");
    }

    public boolean isEmpty(){
        return this.sucursal.esVacia();
    }
}