package presencial;

public class Persona {
    private String nombre;
    private Integer edad;

    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Boolean esMayorQue(){
        //debería volver si la persona es mayor o no
        return edad>=18; //por default retorna true si la edad es mayor o igual a 18
    }

    public Boolean checkEdad(){
        return edad>0&&edad<=120;
    }

    public Boolean cantidadDeLetras(){
        return nombre.length()>=4;
    }

    public Boolean checkAZ(){
        return nombre.matches("[a-zA-Z]*");
    }

    public String getNombre() {
        return nombre;
    }
}
