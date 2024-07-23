package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrupoTest {
    @Test
    public void agregar2Personas(){
        // Dado las 5 personas
        Persona persona1 = new Persona("Juan", 18);
        Persona persona2 = new Persona("Pedro", 17);
        Persona persona3 = new Persona("Ana", 22);
        Persona persona4 = new Persona("Luz", 14);
        Persona persona5 = new Persona("Julian", 32);
        GrupoPersona grupoPersona = new GrupoPersona();
        // Cuando
        grupoPersona.agregarPersona(persona1);
        grupoPersona.agregarPersona(persona2);
        grupoPersona.agregarPersona(persona3);
        grupoPersona.agregarPersona(persona4);
        grupoPersona.agregarPersona(persona5);
        // Entonces
        Assertions.assertTrue(grupoPersona.getListaPersonas().size()==2);
    }
}
