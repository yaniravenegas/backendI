package com.example.ClinicaOdontologicaC3.Controller;

import com.example.ClinicaOdontologicaC3.Entity.Paciente;
import com.example.ClinicaOdontologicaC3.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/listar")
    public String listarTodos(Model model) {
        List<Paciente> pacientes = pacienteService.listarTodos();
        model.addAttribute("pacientes", pacientes);
        return "listar_pacientes"; // Nombre del archivo Thymeleaf en resources/templates
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/ver/{id}")
    public String verPaciente(@PathVariable Long id, Model model) {
        Optional<Paciente> paciente = pacienteService.buscarPorId(id);
        if (paciente.isPresent()) {
            model.addAttribute("paciente", paciente.get());
            return "ver_paciente"; // Nombre del archivo Thymeleaf en resources/templates
        } else {
            return "error"; // Página de error o redireccionamiento
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "formulario_paciente"; // Nombre del archivo Thymeleaf en resources/templates
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/guardar")
    public String guardarPaciente(@ModelAttribute Paciente paciente) {
        pacienteService.registrarPaciente(paciente);
        return "redirect:/paciente/listar"; // Redirecciona a la lista después de guardar
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Optional<Paciente> paciente = pacienteService.buscarPorId(id);
        if (paciente.isPresent()) {
            model.addAttribute("paciente", paciente.get());
            return "formulario_paciente"; // Nombre del archivo Thymeleaf en resources/templates
        } else {
            return "error"; // Página de error o redireccionamiento
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/actualizar/{id}")
    public String actualizarPaciente(@PathVariable Long id, @ModelAttribute Paciente paciente) {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorId(id);
        if (pacienteBuscado.isPresent()) {
            paciente.setId(id); // Asegúrate de que el ID se actualice correctamente
            pacienteService.actualizarPaciente(paciente);
            return "redirect:/paciente/listar"; // Redirecciona a la lista después de actualizar
        } else {
            return "error"; // Página de error o redireccionamiento
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/eliminar/{id}")
    public String eliminarPaciente(@PathVariable Long id) {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorId(id);
        if (pacienteBuscado.isPresent()) {
            pacienteService.eliminarPaciente(id);
            return "redirect:/paciente/listar"; // Redirecciona a la lista después de eliminar
        } else {
            return "error"; // Página de error o redireccionamiento
        }
    }
}
