package mesas;

import presencial.Computadora;

public class Negocio {
    public static void main(String[] args) {
        for (int i = 0; i < 500000; i++) {
            ArbolFactory.plantarArbol(200, 400, "verde", "ornamental");
            ArbolFactory.plantarArbol(500, 300, "rojo", "frutales");
        }
        System.out.println("arboles plantados y no instanciados: " + Arbol.getContador());
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() -
                runtime.freeMemory()) / (1024 * 1024));
    }
}
