package com.example.ClinicaOdontologicaC3.service;

import com.example.ClinicaOdontologicaC3.Dto.TurnoDTO;
import com.example.ClinicaOdontologicaC3.Entity.Odontologo;
import com.example.ClinicaOdontologicaC3.Entity.Paciente;
import com.example.ClinicaOdontologicaC3.Entity.Turno;
import com.example.ClinicaOdontologicaC3.Service.OdontologoService;
import com.example.ClinicaOdontologicaC3.Service.PacienteService;
import com.example.ClinicaOdontologicaC3.Service.TurnoService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    public void testRegistrarTurno() {
        // Primero obtenemos un paciente y un odontólogo para el turno
        Paciente paciente = pacienteService.buscarPorId(1L).get();
        Odontologo odontologo = odontologoService.buscarPorId(1L).get();

        // Creamos el turno
        Turno turno = new Turno(paciente, odontologo, LocalDate.now(), LocalTime.now());

        // Registramos el turno
        TurnoDTO turnoDTO = turnoService.registrarTurno(turno);

        // Verificamos que el turno se registró correctamente
        assertNotNull(turnoDTO);
        assertEquals(turno.getFecha(), turnoDTO.getFecha());
        assertEquals(turno.getHora(), turnoDTO.getHora());
        assertEquals(paciente.getId(), turnoDTO.getPacienteId());
        assertEquals(odontologo.getId(), turnoDTO.getOdontologoId());
    }

    @Test
    @Order(2)
    public void testListarTodosTurnos() {
        // Listamos todos los turnos
        List<TurnoDTO> turnos = turnoService.listarTodos();

        // Verificamos que hay al menos un turno
        assertTrue(turnos.size() > 0);
    }
}