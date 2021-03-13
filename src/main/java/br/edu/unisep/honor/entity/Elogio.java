package br.edu.unisep.honor.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "elogio")
public class Elogio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_elogio")
    private Integer id;

    @Column(name="ds_titulo")
    private String titulo;

    @Column(name="ds_conteudo")
    private String conteudo;

    @OneToOne
    @JoinColumn(name="id_remetente", referencedColumnName = "ds_login")
    private Usuario remetente;

    @OneToOne
    @JoinColumn(name="id_destinatario", referencedColumnName = "ds_login")
    private Usuario destinatario;

    @OneToOne
    @JoinColumn(name="id_tipo")
    private TipoElogio tipo;

    @Column(name="dt_elogio")
    private LocalDate data;

}
