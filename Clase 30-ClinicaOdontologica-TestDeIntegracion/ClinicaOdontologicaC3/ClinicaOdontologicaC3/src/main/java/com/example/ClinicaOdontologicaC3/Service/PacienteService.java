package com.example.ClinicaOdontologicaC3.Service;


import com.example.ClinicaOdontologicaC3.Entity.Paciente;
import com.example.ClinicaOdontologicaC3.Repository.PacienteRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private static final Logger logger = LogManager.getLogger(PacienteService.class);

    @Autowired
    private PacienteRepository pacienteRepository;

    // Método para registrar un nuevo paciente
    public Paciente registrarPaciente(Paciente paciente) {
        try {
            return pacienteRepository.save(paciente);
        } catch (Exception e) {
            logger.error("Error al registrar el paciente", e);
            throw new RuntimeException("Error al registrar el paciente", e);
        }
    }

    // Método para actualizar un paciente existente
    public void actualizarPaciente(Paciente paciente) {
        try {
            pacienteRepository.save(paciente);
        } catch (Exception e) {
            logger.error("Error al actualizar el paciente", e);
            throw new RuntimeException("Error al actualizar el paciente", e);
        }
    }

    // Método para eliminar un paciente por su ID
    public void eliminarPaciente(Long id) {
        try {
            pacienteRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Error al eliminar el paciente con ID: " + id, e);
            throw new RuntimeException("Error al eliminar el paciente", e);
        }
    }

    // Método para buscar un paciente por su ID
    public Optional<Paciente> buscarPorId(Long id) {
        try {
            return pacienteRepository.findById(id);
        } catch (Exception e) {
            logger.error("Error al buscar el paciente por ID: " + id, e);
            throw new RuntimeException("Error al buscar el paciente por ID", e);
        }
    }

    // Método para buscar un paciente por su email
    public Optional<Paciente> buscarPorEmail(String email) {
        try {
            return pacienteRepository.findByEmail(email);
        } catch (Exception e) {
            logger.error("Error al buscar el paciente por email: " + email, e);
            throw new RuntimeException("Error al buscar el paciente por email", e);
        }
    }

    // Método para listar todos los pacientes
    public List<Paciente> listarTodos() {
        try {
            return pacienteRepository.findAll();
        } catch (Exception e) {
            logger.error("Error al listar todos los pacientes", e);
            throw new RuntimeException("Error al listar todos los pacientes", e);
        }
    }
}
