package clase3;

public class CompruebaCalidad {
    private Control inicial;

    public CompruebaCalidad(){
        //crear los eslabones
        inicial = new ControlEnvase();
        Control lote = new ControlLote();
        Control peso = new ControlPeso();
        //unir los eslabones
        inicial.setSiguienteControl(lote);
        lote.setSiguienteControl(peso);
    }

    public String validarCalidadDelProducto(Producto producto) {
        return inicial.validarCalidadDelProducto(producto);
    };
}
