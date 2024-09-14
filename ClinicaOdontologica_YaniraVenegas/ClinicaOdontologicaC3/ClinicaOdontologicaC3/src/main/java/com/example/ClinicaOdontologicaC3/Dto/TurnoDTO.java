package com.example.ClinicaOdontologicaC3.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class TurnoDTO {

    private Long id;
    private LocalDate fecha;
    private LocalTime hora;  // Nuevo campo de hora
    private Long pacienteId;
    private Long odontologoId;
}