import java.util.Stack;

public class Expresion {
    public boolean controlCorhetes(Character[] listaDeEntrada){
        Stack<Character> pila = new Stack<>();
        for (char c : listaDeEntrada){
            if (c == '{'){
                pila.push(c);
            }
            else if (c == '}'){
                if (pila.isEmpty()){
                    return false;
                }
                pila.pop();
            }
        }

        return pila.isEmpty();
    }
}
