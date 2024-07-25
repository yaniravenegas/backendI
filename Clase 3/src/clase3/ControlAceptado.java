package clase3;

public class ControlAceptado extends Control{

    @Override
    public String validarCalidadDelProducto(Producto producto) {
        return "El producto fue aceptado";
    }
}
