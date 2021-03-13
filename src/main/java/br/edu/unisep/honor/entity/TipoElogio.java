package br.edu.unisep.honor.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tipo_elogio")
public class TipoElogio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tipo")
    private Integer id;

    @Column(name="ds_tipo")
    private String descricao;

}
