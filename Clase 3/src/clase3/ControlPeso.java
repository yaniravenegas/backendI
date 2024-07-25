package clase3;

public class ControlPeso extends Control{
    @Override
    public String validarCalidadDelProducto(Producto producto) {
        if (producto.getPeso()>=1200&&producto.getPeso()>=1300) {
            System.out.println("El peso del producto fue aceptado");
        } else{
            System.out.println("El producto fue rechazado");
        }

        return getSiguienteControl().validarCalidadDelProducto(producto);
    }
}
