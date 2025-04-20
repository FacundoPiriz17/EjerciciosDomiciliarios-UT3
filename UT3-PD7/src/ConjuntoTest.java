import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ConjuntoTest {

    @Test
    void union() {
        Conjunto<TAlumno> curso1 = new Conjunto<>();
        Conjunto<TAlumno> curso2 = new Conjunto<>();

        TAlumno a1 = new TAlumno("Facundo", "Piriz",1001);
        TAlumno a2 = new TAlumno( "Thiago", "Garcia", 1002);
        TAlumno a3 = new TAlumno("Santiago", "Piriz", 1003);
        TAlumno a4 = new TAlumno("Agostina", "Etchebarren", 1004);

        curso1.insertar(a1, a1.ci);
        curso1.insertar(a2, a2.ci);
        curso2.insertar(a2, a2.ci);
        curso2.insertar(a3, a3.ci);
        curso2.insertar(a4, a4.ci);

        IConjunto<TAlumno> union = curso1.union(curso2);
        IConjunto<TAlumno> esperado = new Conjunto<>();
        esperado.insertar(a1, a1.ci);
        esperado.insertar(a2, a2.ci);
        esperado.insertar(a3, a3.ci);
        esperado.insertar(a4, a4.ci);

        Assert.assertEquals(union.cantElementos(), esperado.cantElementos());
    }

    @Test
    void interseccion() {
        Conjunto<TAlumno> curso3 = new Conjunto<>();
        Conjunto<TAlumno> curso4 = new Conjunto<>();

        TAlumno a5 = new TAlumno("Facundo", "Piriz",1001);
        TAlumno a6 = new TAlumno( "Thiago", "Garcia", 1002);
        TAlumno a7 = new TAlumno("Santiago", "Piriz", 1003);
        TAlumno a8 = new TAlumno("Agostina", "Etchebarren", 1004);

        curso3.insertar(a5, a5.ci);
        curso3.insertar(a6, a6.ci);
        curso4.insertar(a6, a6.ci);
        curso4.insertar(a7, a7.ci);
        curso4.insertar(a8, a8.ci);

        IConjunto<TAlumno> interseccion = curso3.interseccion(curso4);
        IConjunto<TAlumno> esperado2 = new Conjunto<>();
        esperado2.insertar(a6, a6.ci);
        Assert.assertEquals(interseccion.cantElementos(), esperado2.cantElementos());
    }
}