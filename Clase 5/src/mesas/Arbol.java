package mesas;

public class Arbol {
    private int alto;
    private int ancho;
    private String color;
    private String tipoArbol;
    private static int contador;

    public Arbol(int alto, int ancho, String color, String tipoArbol) {
        this.alto = alto;
        this.ancho = ancho;
        this.color = color;
        this.tipoArbol = tipoArbol;
        contador++ ;
    }

    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public String getColor() {
        return color;
    }

    public String getTipoArbol() {
        return tipoArbol;
    }

    public static int getContador() {
        return contador;
    }
}
