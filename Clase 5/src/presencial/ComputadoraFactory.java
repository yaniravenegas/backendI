package presencial;

import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {
    //existe la computadora, la retornamos
    private Map<Integer, Computadora> computadoraMap;
    //no existe, la creamos


    public ComputadoraFactory() {
        computadoraMap = new HashMap<>();
    }

    public Computadora getComputadora(int memoriaRam, int discoDuro){
        //el primer paso sería definir la clave
        Integer key = memoriaRam+discoDuro;
        //verificar en la colección si existe esa clave
        if(!computadoraMap.containsKey(key)){
            //si no existe la clave, se crea
            computadoraMap.put(key, new Computadora(memoriaRam, discoDuro));
            System.out.println("computadora creada con éxito");
        } return computadoraMap.get(key);
    }
}
