package com.project.sistemaDeReservas.dto;

import com.project.sistemaDeReservas.model.TipoLocal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocalDTO {

    private Long id;
    private String nome;
    private TipoLocal tipo;
    private String endereco;
}
