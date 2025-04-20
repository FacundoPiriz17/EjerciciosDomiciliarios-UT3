/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Josse
 */
public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista<Suero> sueros = cargarSueros("sueros.txt");
        Lista<Farmaco> farmacos = cargarFarmacos("farmacos.txt");
        Lista<Integer> listaBlanca = cargarListaBlanca("listablanca.txt");
        Lista<ParejaSueroFarmaco> listaNegra = cargarListaNegra("listanegra.txt");

        ControladorPreparado control = new ControladorPreparado(sueros, farmacos, listaBlanca, listaNegra);

        int idSuero = 2;
        Lista<Integer> idsFarmacos = new Lista<>();
        idsFarmacos.insertar(10, 10);
        idsFarmacos.insertar(20, 20);
        Nodo<Suero> sueroNodo = sueros.buscar(idSuero);
        StringBuilder salida = new StringBuilder();

        if (sueroNodo != null) {
            Suero s = sueroNodo.getDato();
            salida.append("Suero ").append(s.getId()).append(": ").append(s.getDescripcion()).append("\n");
        }

        Nodo<Integer> f = idsFarmacos.getPrimero();
        while (f != null) {
            Nodo<Farmaco> nodoFarmaco = farmacos.buscar(f.getEtiqueta());
            if (nodoFarmaco != null) {
                Farmaco fa = nodoFarmaco.getDato();
                salida.append("Fármaco ").append(fa.getId()).append(": ").append(fa.getDescripcion()).append("\n");
            }
            f = f.getSiguiente();
        }

        boolean esViable = control.preparadoViable(idSuero, idsFarmacos);
        if (esViable) {
            salida.append("VIABLE");
        }
        else {
            salida.append("NO VIABLE");
        }

        System.out.println(salida.toString());

        ManejadorArchivosGenerico.escribirArchivo("consulta.txt", salida.toString().split("\n"));
    }

    private static Lista<Suero> cargarSueros(String archivo) {
        Lista<Suero> sueros = new Lista<>();
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(archivo);
        for (String linea : lineas) {
            String[] partes = linea.split(",");
            int id = Integer.parseInt(partes[0].trim());
            String desc = partes[1].trim();
            sueros.insertar(id, new Suero(id, desc));
        }
        return sueros;
    }

    private static Lista<Farmaco> cargarFarmacos(String archivo) {
        Lista<Farmaco> lista = new Lista<>();
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(archivo);
        for (String linea : lineas) {
            String[] partes = linea.split(",");
            if (partes.length >= 2) {
                Integer id = Integer.parseInt(partes[0].trim());
                String desc = partes[1].trim();
                Farmaco f = new Farmaco(id, desc);
                lista.insertar(id, f);
            }
        }
        return lista;
    }

    private static Lista<Integer> cargarListaBlanca(String archivo) {
        Lista<Integer> lista = new Lista<>();
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(archivo);
        for (String linea : lineas) {
            Integer id = Integer.parseInt(linea.trim());
            lista.insertar(id, id);
        }
        return lista;
    }

    private static Lista<ParejaSueroFarmaco> cargarListaNegra(String archivo) {
        Lista<ParejaSueroFarmaco> lista = new Lista<>();
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(archivo);
        for (String linea : lineas) {
            String[] partes = linea.split(",");
            if (partes.length >= 2) {
                Integer idSuero = Integer.parseInt(partes[0].trim());
                Integer idFarmaco = Integer.parseInt(partes[1].trim());
                ParejaSueroFarmaco pareja = new ParejaSueroFarmaco(idSuero, idFarmaco);
                String etiqueta = idSuero + "-" + idFarmaco;
                lista.insertar(etiqueta, pareja);
            }
        }
        return lista;
    }
}
