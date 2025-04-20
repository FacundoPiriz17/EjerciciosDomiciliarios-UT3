import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpresionTest {
    @Test
    void testCorrecto() {
    Expresion exp = new Expresion();
        Character[] listaDeEntrada = new Character[] { '{', '}', '{', '{', '}', '}' };
    Assert.assertTrue(exp.controlCorhetes(listaDeEntrada));

    }

    @Test
    void testIncorrecto() {
        Expresion exp = new Expresion();
        Character[] listaDeEntrada = new Character[] {'{','{','}','{','{','}'};
        Assert.assertFalse(exp.controlCorhetes(listaDeEntrada));

    }
}
