package com.project.sistemaDeReservas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {

    private Long id;
    private LocalDateTime inicio;
    private LocalDateTime encerramento;
    private String localNome;
    private String usuarioNome;
}
