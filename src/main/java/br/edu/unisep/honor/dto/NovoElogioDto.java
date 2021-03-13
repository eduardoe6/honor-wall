package br.edu.unisep.honor.dto;

import lombok.Data;

@Data
public class NovoElogioDto {

    private String titulo;

    private String conteudo;

    private Integer tipo;

    private String destinatario;

    private String remetente;

}
