package br.edu.unisep.honor.repository;

import br.edu.unisep.honor.dao.ElogioDao;
import br.edu.unisep.honor.dto.ElogioDto;
import br.edu.unisep.honor.dto.LoginDto;
import br.edu.unisep.honor.dto.NovoElogioDto;
import br.edu.unisep.honor.dto.UsuarioDto;
import br.edu.unisep.honor.entity.Elogio;
import br.edu.unisep.honor.entity.TipoElogio;
import br.edu.unisep.honor.entity.Usuario;
import com.rcpadilha.hibernate.exception.DaoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ElogioRepository {

    private ElogioDao dao = new ElogioDao();

    public List<ElogioDto> listar(String login) {
        var elogios = dao.listar(login);

        var retorno = new ArrayList<ElogioDto>();

        elogios.forEach(d -> {

            retorno.add(new ElogioDto(d.getTitulo(),
                    d.getConteudo(),
                    d.getTipo().getDescricao(),
                    d.getData()));
        });

        return retorno;
    }

    public void salvar(NovoElogioDto novoElogio) throws DaoException {

        var elogio = new Elogio();

        elogio.setTitulo(novoElogio.getTitulo());
        elogio.setConteudo(novoElogio.getConteudo());
        elogio.setData(LocalDate.now());

        var tipo = new TipoElogio();
        tipo.setId(novoElogio.getTipo());

        var destinatario = new Usuario();
        destinatario.setLogin(novoElogio.getDestinatario());

        var remetente = new Usuario();
        remetente.setLogin(novoElogio.getRemetente());

        elogio.setTipo(tipo);
        elogio.setDestinatario(destinatario);
        elogio.setRemetente(remetente);

        dao.save(elogio);
    }

}
