package com.project.sistemaDeReservas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime inicio;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime encerramento;
    private String usuarioNome;
    private String localNome;
}
