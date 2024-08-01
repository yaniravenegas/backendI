package presencial;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static final Logger logger= Logger.getLogger(App.class);
    private List<Integer> listaEnteros;

    public App() {
        listaEnteros= new ArrayList<>();
        logger.info("instancia creada");
    }

    public void agregarEnterosAlaLista(Integer numero){
        listaEnteros.add(numero);
        logger.info("elemento agregado");
        //La logica indica que debemos loguear cuando?
        if (listaEnteros.size()>10){
            //anotabamos en el registro(logueamos)
            logger.warn("La lista tiene mas de 10: "+listaEnteros.size()+" Elementos");
        }
        if (listaEnteros.size()>5){
            //anotabamos en el registro(logueamos)
            logger.warn("La lista tiene mas de 5: "+listaEnteros.size()+" Elementos");
        }

    }
    public double calcularPromedio(App listado){
        double promedio = listaEnteros.stream().mapToInt(a -> a).average().orElse(0);
        logger.info("El promedio de la lista es: "+ promedio);
        return promedio;
    }

    public void verificarListaVacia() {
        if (listaEnteros.isEmpty()){
            logger.error("La lista está vacía");
        }
    }
}
