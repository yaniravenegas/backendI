package presencial;

public class Computadora {
    private int memoriaRam;
    private int discoDuro;
    private static int contador;

    public Computadora(int memoriaRam, int discoDuro) {
        this.memoriaRam = memoriaRam;
        this.discoDuro = discoDuro;
        contador++;
    }

    public int getMemoriaRam() {
        return memoriaRam;
    }

    public int getDiscoDuro() {
        return discoDuro;
    }

    public static int getContador() {
        return contador;
    }
}
