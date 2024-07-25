package clase3;

public class Producto {
    private String nombre;
    private int lote;
    private int peso;
    private String envasado;

    public Producto(int lote, int peso, String envasado) {
        this.lote = lote;
        this.peso = peso;
        this.envasado = envasado;
    }

    public int getLote() {
        return lote;
    }

    public int getPeso() {
        return peso;
    }

    public String getEnvasado() {
        return envasado;
    }

}
