package br.edu.unisep.honor.bean;

import br.edu.unisep.honor.dto.ElogioDto;
import br.edu.unisep.honor.repository.ElogioRepository;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListaElogiosBean {

    @Inject
    private UsuarioBean usuarioBean;

    private ElogioRepository repo;

    @Getter
    @Setter
    private List<ElogioDto> elogios;

    @PostConstruct
    public void iniciar() {
        this.repo = new ElogioRepository();
        this.elogios = repo.listar(usuarioBean.getUsuario().getLogin());
    }
}
