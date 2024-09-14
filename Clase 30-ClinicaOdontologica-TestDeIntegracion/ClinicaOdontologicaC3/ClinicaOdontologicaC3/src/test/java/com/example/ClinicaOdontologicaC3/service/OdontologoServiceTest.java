package com.example.ClinicaOdontologicaC3.service;

import com.example.ClinicaOdontologicaC3.Entity.Odontologo;
import com.example.ClinicaOdontologicaC3.Service.OdontologoService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    public void testRegistrarOdontologo() {
        Odontologo odontologo = new Odontologo("Matias", "Torres", "1223");
        Odontologo odontologoGuardado = odontologoService.registrarOdontologo(odontologo);
        assertNotNull(odontologoGuardado.getId());  // Verifica que se haya guardado con ID
        assertEquals("Matias", odontologoGuardado.getNombre());
    }

    @Test
    @Order(2)
    public void testBuscarOdontologoPorId() {
        // Crear un odontólogo antes de buscarlo
        Odontologo odontologo = new Odontologo("Carlos", "Perez", "4567");
        odontologo = odontologoService.registrarOdontologo(odontologo);
        Long id = odontologo.getId();

        Optional<Odontologo> odontologoBuscado = odontologoService.buscarPorId(id);
        assertTrue(odontologoBuscado.isPresent(), "Odontólogo no encontrado por ID");
    }

    @Test
    @Order(3)
    public void testActualizarOdontologo() {
        // Crear y registrar un odontólogo antes de actualizarlo
        Odontologo odontologo = new Odontologo("Juan", "Lopez", "7890");
        odontologo = odontologoService.registrarOdontologo(odontologo);
        Long id = odontologo.getId();

        Optional<Odontologo> odontologoBuscado = odontologoService.buscarPorId(id);
        if (odontologoBuscado.isPresent()) {
            Odontologo o = odontologoBuscado.get();
            o.setApellido("Martinez");
            odontologoService.registrarOdontologo(o); // Guarda los cambios

            // Verificar los cambios
            Optional<Odontologo> odontologoActualizado = odontologoService.buscarPorId(id);
            assertTrue(odontologoActualizado.isPresent());
            assertEquals("Martinez", odontologoActualizado.get().getApellido());
        } else {
            fail("Odontólogo no encontrado para actualizar");
        }
    }

    @Test
    @Order(4)
    public void testListarTodosOdontologos() {
        // Asegúrate de que haya odontólogos en la base de datos
        List<Odontologo> odontologos = odontologoService.listarTodos();
        assertFalse(odontologos.isEmpty(), "No se encontraron odontólogos");
    }

    @Test
    @Order(5)
    public void testEliminarOdontologo() {
        // Crear y registrar un odontólogo antes de eliminarlo
        Odontologo odontologo = new Odontologo("Ana", "Gomez", "1357");
        odontologo = odontologoService.registrarOdontologo(odontologo);
        Long id = odontologo.getId();

        odontologoService.eliminarOdontologo(id);
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarPorId(id);
        assertFalse(odontologoBuscado.isPresent(), "Odontólogo no eliminado");
    }
}