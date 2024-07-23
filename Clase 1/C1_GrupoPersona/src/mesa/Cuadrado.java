package mesa;

public class Cuadrado extends FiguraGeometrica{
    private String tipoFigura;
    private double lado;
    private double area;

    @Override
    public double CalcularArea() {
        area = lado*lado;
        if (lado > 0) {
            System.out.println("El area de " +tipoFigura+" es "+area+" unidades.");
        } else {
            System.out.println("El valor del radio o lado debe ser mayor que cero");
        }
        return area;
    }

    public Cuadrado(String tipoFigura, double lado) {
        this.tipoFigura = tipoFigura;
        this.lado = lado;
    }
}
