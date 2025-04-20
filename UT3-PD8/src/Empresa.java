import java.util.ArrayList;
import java.util.List;

// El consumo de memoria es diferente ya que ArrayList usa un arreglo dinámico y LinkedList usa nodos enlazados.

public class Empresa{ 
    public String name;
    private List<String> sucursal;

    public Empresa(String name){ // O(1)
        this.name = name;
        this.sucursal = new ArrayList<String>();
    }

    public void addSucursal(String sucursal) {  // O(n)
        this.sucursal.add(sucursal);
    }

    public void removeSucursal(String sucursal) { // O(n)
        this.sucursal.remove(sucursal);
    }

    public void getSucursal() { // O(n)
        getSucursal(null);
    }

    public void getSucursal(String separador) { // O(n)
        for (int i = 0; i < this.sucursal.size(); i++) {
            if (separador != null) {
                System.out.print(this.sucursal.get(i) + separador);
            } else {
                System.out.print(this.sucursal.get(i) + "\n");
            }
        }
        System.out.println();
    }

    public void searchSucursal(String sucursal) {  // O(n)
        if (this.sucursal.contains(sucursal)) {
            System.out.println("La sucursal " + sucursal + " existe en la empresa " + this.name);
        } else {
            System.out.println("La sucursal " + sucursal + " no existe en la empresa " + this.name);
        }
    }

    public void countSucursal() {  // O(1)
        System.out.println("La empresa " + this.name + " tiene " + this.sucursal.size() + " sucursales.");
    }

    public boolean isEmpty() {  // O(1)
        return this.sucursal.isEmpty();
    }
}
