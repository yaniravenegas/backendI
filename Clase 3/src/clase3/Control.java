package clase3;

public abstract class Control {
    private Control siguienteControl;

    public Control getSiguienteControl() {
        return siguienteControl;
    }

    public void setSiguienteControl(Control siguienteControl) {
        this.siguienteControl = siguienteControl;
    }
    public abstract String validarCalidadDelProducto(Producto producto);

    
}
