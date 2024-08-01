package presencial;

import java.util.List;

public class Cliente {
    public static void main(String[] args) {
        App listado= new App();
        App listado2= new App();
        App listado3= new App();
        App listado4= new App();
        //se crea listado para la primera instrucción
        for (int i=0; i<5;i++){
         listado.agregarEnterosAlaLista(i);
        }
        //se crea listado para la segunda instrucción
        for (int i=0; i<10;i++){
            listado2.agregarEnterosAlaLista(i);
        }
        //se crea listado para la tercera instrucción
        for (int i=0; i<10;i++){
            listado3.agregarEnterosAlaLista(i);
        }
        listado.calcularPromedio(listado3);
        //se crea listado para la cuarta instrucción
        for (int i=0; i<0;i++){
            listado4.agregarEnterosAlaLista(i);
        }
        listado4.verificarListaVacia();
    }
}
