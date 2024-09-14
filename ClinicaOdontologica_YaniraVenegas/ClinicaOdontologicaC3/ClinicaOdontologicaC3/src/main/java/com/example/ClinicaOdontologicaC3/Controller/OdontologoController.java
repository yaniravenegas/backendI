package com.example.ClinicaOdontologicaC3.Controller;

import com.example.ClinicaOdontologicaC3.Entity.Odontologo;
import com.example.ClinicaOdontologicaC3.Service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/odontologo")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/listar")
    public String listarTodos(Model model) {
        List<Odontologo> odontologos = odontologoService.listarTodos();
        model.addAttribute("odontologos", odontologos);
        return "listar_odontologos"; // Nombre del archivo Thymeleaf en resources/templates
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/ver/{id}")
    public String verOdontologo(@PathVariable Long id, Model model) {
        Optional<Odontologo> odontologo = odontologoService.buscarPorId(id);
        if (odontologo.isPresent()) {
            model.addAttribute("odontologo", odontologo.get());
            return "ver_odontologo"; // Nombre del archivo Thymeleaf en resources/templates
        } else {
            return "error"; // Página de error o redireccionamiento
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("odontologo", new Odontologo());
        return "formulario_odontologo"; // Nombre del archivo Thymeleaf en resources/templates
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/guardar")
    public String guardarOdontologo(@ModelAttribute Odontologo odontologo) {
        odontologoService.registrarOdontologo(odontologo);
        return "redirect:/odontologo/listar"; // Redirecciona a la lista después de guardar
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public String actualizarOdontologo(@PathVariable Long id, @ModelAttribute Odontologo odontologo) {
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarPorId(id);
        if (odontologoBuscado.isPresent()) {
            odontologo.setId(id); // Asegúrate de que el ID se actualice correctamente
            odontologoService.registrarOdontologo(odontologo);
            return "redirect:/odontologo/listar"; // Redirecciona a la lista después de actualizar
        } else {
            return "error"; // Página de error o redireccionamiento
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public String eliminarOdontologo(@PathVariable Long id) {
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarPorId(id);
        if (odontologoBuscado.isPresent()) {
            odontologoService.eliminarOdontologo(id);
            return "redirect:/odontologo/listar"; // Redirecciona a la lista después de eliminar
        } else {
            return "error"; // Página de error o redireccionamiento
        }
    }
}
