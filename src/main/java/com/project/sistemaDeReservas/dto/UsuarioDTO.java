package com.project.sistemaDeReservas.dto;

import com.project.sistemaDeReservas.model.Reserva;
import com.project.sistemaDeReservas.model.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;
    private Role role;
    private Set<Reserva> reservas;
}
