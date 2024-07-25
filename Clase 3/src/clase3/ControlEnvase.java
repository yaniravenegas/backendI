package clase3;

public class ControlEnvase extends Control{
    @Override
    public String validarCalidadDelProducto(Producto producto) {
        if (producto.getEnvasado().equalsIgnoreCase("sano") || producto.getEnvasado().equalsIgnoreCase("casi sano")) {
            if (getSiguienteControl() != null) {
                return getSiguienteControl().validarCalidadDelProducto(producto);
            } else {
                return "El producto fue aceptado";
            }
        } return "El producto fue rechazado";
    }
}



