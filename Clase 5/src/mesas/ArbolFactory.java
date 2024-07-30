package mesas;

import presencial.Computadora;

import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {
    //creamos una colección para mapear los arboles ya instanciados
    private static Map<String, Arbol> arbolMap = new HashMap<>();

    public static Arbol plantarArbol(int alto, int ancho, String color, String tipoArbol) {
        //definir la clave
        String key = alto+ancho+color+tipoArbol;
        //verificar en la colección si existe esa clave
        if(!arbolMap.containsKey(key)){
            //si no existe la clave, se crea
            arbolMap.put(key, new Arbol(alto, ancho, color, tipoArbol));
            System.out.println("nuevo árbol plantado con éxito");
        } return arbolMap.get(key);
    }
}
