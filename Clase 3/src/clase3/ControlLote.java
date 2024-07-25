package clase3;

public class ControlLote extends Control{
    @Override
    public String validarCalidadDelProducto(Producto producto) {
        if (producto.getLote()>=1000&&producto.getLote()<=2000) {
            if (getSiguienteControl() != null) {
                return getSiguienteControl().validarCalidadDelProducto(producto);
            } else {
                return "El producto fue aceptado";
            }
        } return "El producto fue rechazado";
    }
}


//producto.getLote()>=1000&&producto.getLote()<=2000