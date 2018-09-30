package SymbolTable;


import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class SymbolTable {

    private Hashtable<String, Symbol> tb;
    private Queue<String> productor;
    public SymbolTable(){
        tb = new Hashtable<>();
        productor = new LinkedList<>();
    }

    public void setSymbol(String lexema, int number) {
        if (!tb.containsKey(lexema)){
            Symbol token = new Symbol(lexema, number);
            tb.put(lexema, token);
            productor.add(lexema);
        }
        //debemos agregar un else para contemplar los casos donde el lexema ya existe pero es otro token
        // por ejemplo 25_i y '25_i' o _palabra y 'palabra' o 2.5F35 y '2.5F35'
        //donde albos token tienen el mismo lexema pero distinto tipo
        //como el probrema viene traido por las cadenas de caracteres, guardamos el primer ' como parte del lexema
    }

    public boolean existsSymbol(String lexema){
        return tb.containsKey(lexema);
    }

    public String getAtributosNextLexema(){
       return tb.get(productor.remove()).getAtributos();
    }
    public boolean isEmpty(){
        return productor.isEmpty();

    }

    public void setAtributo(String lexema, String atributo, Object valor){
        if (tb.containsKey(lexema))
            tb.get(lexema).setAtributos(atributo,valor);
    }

}
