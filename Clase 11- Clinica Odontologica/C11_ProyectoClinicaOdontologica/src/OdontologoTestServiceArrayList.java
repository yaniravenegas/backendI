import Service.OdontologoServiceArrayList;
import Model.Odontologo;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OdontologoTestServiceArrayList {
    private OdontologoServiceArrayList odontologoService;

    @Before
    public void setUp() {
        odontologoService = new OdontologoServiceArrayList();
    }

    @Test
    public void agregarOdontologo() {
        // Agregar un nuevo odontólogo
        Odontologo odontologo1 = odontologoService.add("M1234", "Juan", "Perez");
        Odontologo odontologo2 = odontologoService.add("M5678", "Ana", "Gomez");

        // Verificar que los odontólogos fueron agregados correctamente
        assertNotNull(odontologo1);
        assertNotNull(odontologo2);
        assertEquals("M1234", odontologo1.getMatricula());
        assertEquals("Juan", odontologo1.getNombre());
        assertEquals("Perez", odontologo1.getApellido());
        assertEquals("M5678", odontologo2.getMatricula());
        assertEquals("Ana", odontologo2.getNombre());
        assertEquals("Gomez", odontologo2.getApellido());
    }

    @Test
    public void buscarTodos() {
        // Agregar odontólogos
        odontologoService.add("M1234", "Juan", "Perez");
        odontologoService.add("M5678", "Ana", "Gomez");

        // Buscar y verificar todos los odontólogos
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        assertNotNull(odontologos);
        assertEquals(2, odontologos.size());

        System.out.println("Lista de odontólogos:");
        for (Odontologo o : odontologos) {
            System.out.println("Matrícula: " + o.getMatricula() + ", Nombre: " + o.getNombre() + ", Apellido: " + o.getApellido());
        }
    }
}
