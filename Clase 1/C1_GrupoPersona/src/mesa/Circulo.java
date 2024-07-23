package mesa;

public class Circulo extends FiguraGeometrica {
    private String tipoFigura;
    private double radio;
    private double area;

    @Override
    public double CalcularArea() {
        area = radio*radio*Math.PI;
        if (radio > 0) {
            System.out.println("El area de " +tipoFigura+" es "+area+" unidades.");
        } else {
            System.out.println("El valor del radio o lado debe ser mayor que cero");
        }
        return area;
    }

    public Circulo(String tipoFigura, double radio) {
        this.tipoFigura = tipoFigura;
        this.radio = radio;
    }
}
