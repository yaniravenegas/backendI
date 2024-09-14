package com.example.ClinicaOdontologicaC3.Controller;

import com.example.ClinicaOdontologicaC3.Dto.TurnoDTO;
import com.example.ClinicaOdontologicaC3.Entity.Odontologo;
import com.example.ClinicaOdontologicaC3.Entity.Paciente;
import com.example.ClinicaOdontologicaC3.Entity.Turno;
import com.example.ClinicaOdontologicaC3.Service.OdontologoService;
import com.example.ClinicaOdontologicaC3.Service.PacienteService;
import com.example.ClinicaOdontologicaC3.Service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/turno")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/listar")
    public String listarTodos(Model model) {
        List<TurnoDTO> turnos = turnoService.listarTodos();
        model.addAttribute("turnos", turnos);
        return "listar_turnos"; // Nombre del archivo Thymeleaf en resources/templates
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        List<Paciente> pacientes = pacienteService.listarTodos();
        List<Odontologo> odontologos = odontologoService.listarTodos();
        model.addAttribute("turno", new Turno());
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("odontologos", odontologos);
        return "formulario_turno"; // Nombre del archivo Thymeleaf en resources/templates
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/guardar")
    public String guardarTurno(@ModelAttribute Turno turno) {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorId(turno.getPaciente().getId());
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarPorId(turno.getOdontologo().getId());
        if (pacienteBuscado.isPresent() && odontologoBuscado.isPresent()) {
            turno.setPaciente(pacienteBuscado.get());
            turno.setOdontologo(odontologoBuscado.get());
            turnoService.registrarTurno(turno);
            return "redirect:/turno/listar"; // Redirecciona a la lista después de guardar
        } else {
            return "error"; // Página de error o redireccionamiento
        }
    }
}
