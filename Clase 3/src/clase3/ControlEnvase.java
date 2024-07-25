package clase3;

public class ControlEnvase extends Control{
    @Override
    public String validarCalidadDelProducto(Producto producto) {
        if(producto.getEnvasado().equalsIgnoreCase("sano") || producto.getEnvasado().equalsIgnoreCase("casi sano")){
            return "El envasado del producto fue aceptado";
        }else{
            System.out.println("El producto fue rechazado");
        }

        return getSiguienteControl().validarCalidadDelProducto(producto);
    }
}





