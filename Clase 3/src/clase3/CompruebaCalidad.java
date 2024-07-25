package clase3;

public class CompruebaCalidad {
    private Control inicial;

    public CompruebaCalidad(){
        //crear los eslabones
        inicial = new ControlLote();
        Control peso = new ControlPeso();
        Control envase = new ControlEnvase();
        Control aceptado = new ControlAceptado();
        //unir los eslabones
        inicial.setSiguienteControl(peso);
        peso.setSiguienteControl(envase);
        envase.setSiguienteControl(aceptado);
    }

    public String validarCalidadDelProducto(Producto producto) {
        return inicial.validarCalidadDelProducto(producto);
    }
}
