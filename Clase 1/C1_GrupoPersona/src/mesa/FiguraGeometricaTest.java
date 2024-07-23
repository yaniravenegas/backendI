package mesa;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FiguraGeometricaTest {
    @Test
    public void calculaAreaFiguraInputNoEs0(){
        //Dado
        Cuadrado cuadrado1 = new Cuadrado("cuadrado", 5);
        Circulo circulo1 = new Circulo("circulo", 3);
        //Cuando
        double areaCuadrado = cuadrado1.CalcularArea();
        double areaCirculo = circulo1.CalcularArea();
        //Entonces
        Assertions.assertEquals(25.0, areaCuadrado);
        Assertions.assertEquals(28.274333882308138, areaCirculo);
    }

    @Test
    public void calculaAreaFiguraInputEs0(){
        //Dado
        Cuadrado cuadrado1 = new Cuadrado("cuadrado", 0);
        Circulo circulo1 = new Circulo("circulo", 0);
        //Cuando
        double areaCuadrado = cuadrado1.CalcularArea();
        double areaCirculo = circulo1.CalcularArea();
        //Entonces
        Assertions.assertEquals(25.0, areaCuadrado);
        Assertions.assertEquals(28.274333882308138, areaCirculo);
    }
}
