package br.edu.unisep.honor.repository;


import br.edu.unisep.honor.dao.UsuarioDao;
import br.edu.unisep.honor.dto.DestinatarioDto;
import br.edu.unisep.honor.dto.UsuarioDto;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioRepository {

    private UsuarioDao dao = new UsuarioDao();

    public UsuarioDto findByLogin(String login) {
        var usuario = dao.findByLogin(login);
        return new UsuarioDto(usuario.getLogin(),
                usuario.getEmail(), usuario.getNome());
    }


    public List<DestinatarioDto> listarDestinatarios(String login) {
        var destinatario = dao.listarDestinatarios(login);

        return destinatario.stream().map(d -> new DestinatarioDto(d.getLogin(), d.getNome())).collect(Collectors.toList());
    }

}
