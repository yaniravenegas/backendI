package mesas;

import presencial.Computadora;

public class Negocio {
    public static void main(String[] args) {
        ArbolFactory arbolFactory = new ArbolFactory();
        Arbol arbol1 = arbolFactory.plantarArbol(200, 400, "verde", "ornamental");
        Arbol arbol2 = arbolFactory.plantarArbol(200, 400, "verde", "ornamental");
        Arbol arbol3 = arbolFactory.plantarArbol(500, 300, "rojo", "frutales");
        Arbol arbol4 = arbolFactory.plantarArbol(500, 300, "rojo", "frutales");
        Arbol arbol5 = arbolFactory.plantarArbol(100, 200, "celeste", "florales");
        Arbol arbol6 = arbolFactory.plantarArbol(100, 200, "celeste", "florales");
        System.out.println("arboles plantados y no instanciados: " + Arbol.getContador());
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() -
                runtime.freeMemory()) / (1024 * 1024));
    }
}
