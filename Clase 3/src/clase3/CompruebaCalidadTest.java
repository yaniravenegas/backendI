package clase3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompruebaCalidadTest {
    @Test
    public void RechazaProductoPorEnvasado(){
        //dado
        Producto producto1 = new Producto(2000, 1250, "defectuoso");
        CompruebaCalidad compruebaCalidad = new CompruebaCalidad();
        String respEsp = "El producto fue rechazado";
        //cuando
        String respAct = compruebaCalidad.validarCalidadDelProducto(producto1);
        //entonces
        Assertions.assertEquals(respEsp, respAct);
    }

    @Test
    public void RechazaProductoPorLote(){
        //dado
        Producto producto2 = new Producto(5000, 1250, "sano");
        CompruebaCalidad compruebaCalidad = new CompruebaCalidad();
        String respEsp = "El producto fue rechazado";
        //cuando
        String respAct = compruebaCalidad.validarCalidadDelProducto(producto2);
        //entonces
        Assertions.assertEquals(respEsp, respAct);
    }

    @Test
    public void RechazaProductoPorPeso(){
        //dado
        Producto producto3 = new Producto(2000, 3000, "sano");
        CompruebaCalidad compruebaCalidad = new CompruebaCalidad();
        String respEsp = "El producto fue rechazado";
        //cuando
        String respAct = compruebaCalidad.validarCalidadDelProducto(producto3);
        //entonces
        Assertions.assertEquals(respEsp, respAct);
    }
}

