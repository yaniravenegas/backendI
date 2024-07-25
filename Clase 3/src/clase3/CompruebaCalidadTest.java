package clase3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompruebaCalidadTest {
    @Test
public void RechazaProductoPorLote(){
        //dado
        Producto producto1 = new Producto(5000, 1250, "sano");
        CompruebaCalidad compruebaCalidad = new CompruebaCalidad();
        String respEsp = "El producto fue rechazado";
        //cuando
        String respAct = compruebaCalidad.validarCalidadDelProducto(producto1);
        //entonces
        Assertions.assertEquals(respEsp, respAct);
    }
}
