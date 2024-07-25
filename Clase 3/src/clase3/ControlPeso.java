package clase3;

public class ControlPeso extends Control{
    @Override
    public String validarCalidadDelProducto(Producto producto) {
        if (producto.getPeso()>=1200&&producto.getPeso()<=1300) {
            if (getSiguienteControl() != null) {
                return getSiguienteControl().validarCalidadDelProducto(producto);
            } else {
                return "El producto fue aceptado";
            }
        } return "El producto fue rechazado";
    }
}


