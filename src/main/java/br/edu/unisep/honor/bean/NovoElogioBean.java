package br.edu.unisep.honor.bean;

import br.edu.unisep.honor.dto.DestinatarioDto;
import br.edu.unisep.honor.dto.NovoElogioDto;
import br.edu.unisep.honor.dto.TipoElogioDto;
import br.edu.unisep.honor.repository.ElogioRepository;
import br.edu.unisep.honor.repository.TipoElogioRepository;
import br.edu.unisep.honor.repository.UsuarioRepository;
import com.rcpadilha.hibernate.exception.DaoException;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
@Getter
@Setter
public class NovoElogioBean {

    private List<DestinatarioDto> destinatarios;
    private List<TipoElogioDto> tipos;

    @Inject
    private UsuarioBean usuarioBean;

    private NovoElogioDto elogio;

    private UsuarioRepository userRepo = new UsuarioRepository();
    private ElogioRepository elogioRepo = new ElogioRepository();
    private TipoElogioRepository tipoRepo = new TipoElogioRepository();

    @PostConstruct
    public void iniciar() {
        this.destinatarios = userRepo.listarDestinatarios(usuarioBean.getUsuario().getLogin());
        this.tipos = tipoRepo.listar();

        this.elogio = new NovoElogioDto();
    }

    public String salvar() {
        try {
            elogio.setRemetente(usuarioBean.getUsuario().getLogin());
            elogioRepo.salvar(elogio);
            return "home?faces-redirect=true";
        } catch (DaoException e) {
            return "novoElogio";
        }
    }

}
