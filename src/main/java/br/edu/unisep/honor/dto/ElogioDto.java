package br.edu.unisep.honor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ElogioDto {

    private String titulo;

    private String conteudo;

    private String tipo;

    private LocalDate data;

}
