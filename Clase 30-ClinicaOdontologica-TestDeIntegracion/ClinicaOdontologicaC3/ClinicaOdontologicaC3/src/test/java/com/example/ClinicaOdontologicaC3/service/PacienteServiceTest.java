package com.example.ClinicaOdontologicaC3.service;

import com.example.ClinicaOdontologicaC3.Entity.Domicilio;
import com.example.ClinicaOdontologicaC3.Entity.Paciente;
import com.example.ClinicaOdontologicaC3.Service.PacienteService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    @Test
    @Order(1)
    public void testGuardarPaciente() {
        Paciente paciente = new Paciente("Jorgito", "Pereyra", "11111", LocalDate.of(2024, 9, 9), 
                    new Domicilio("Calle siempre viva", 123, "Springfield", "USA"), "jorge.pereyra@digitalhouse.com");
        Paciente pacienteGuardado = pacienteService.registrarPaciente(paciente);
        assertEquals("Jorgito", pacienteGuardado.getNombre());
    }

    @Test
    @Order(2)
    public void testBuscarPacientePorId() {
        Long id = 1L;
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorId(id);
        assertTrue(pacienteBuscado.isPresent());
    }

    @Test
    @Order(3)
    public void testActualizarPaciente() {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorId(1L);
        if (pacienteBuscado.isPresent()) {
            pacienteBuscado.get().setApellido("Perez");
            pacienteService.actualizarPaciente(pacienteBuscado.get());
        }
        assertEquals("Perez", pacienteBuscado.get().getApellido());
    }

    @Test
    @Order(4)
    public void testBuscarPorEmail() {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorEmail("jorge.pereyra@digitalhouse.com");
        assertTrue(pacienteBuscado.isPresent());
    }

    @Test
    @Order(5)
    public void testListarTodos() {
        List<Paciente> pacientes = pacienteService.listarTodos();
        assertTrue(pacientes.size() > 0);
    }

    @Test
    @Order(6)
    public void testEliminarPaciente() {
        pacienteService.eliminarPaciente(1L);
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorId(1L);
        assertFalse(pacienteBuscado.isPresent());
    }
}
