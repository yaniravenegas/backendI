package clase3;

public class ControlLote extends Control{
    @Override
    public String validarCalidadDelProducto(Producto producto) {
        if(producto.getLote()>=1000&&producto.getLote()<=2000){
            return "El lote del producto fue aceptado";
        }else{
            System.out.println("El producto fue rechazado");
        }

        return getSiguienteControl().validarCalidadDelProducto(producto);
    }
}
