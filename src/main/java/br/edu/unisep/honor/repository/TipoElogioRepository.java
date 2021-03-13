package br.edu.unisep.honor.repository;

import br.edu.unisep.honor.dto.TipoElogioDto;
import br.edu.unisep.honor.entity.TipoElogio;
import com.rcpadilha.hibernate.dao.HibernateDao;

import java.util.List;
import java.util.stream.Collectors;

public class TipoElogioRepository {

    public List<TipoElogioDto> listar() {
        var dao = new HibernateDao<TipoElogio>();
        var elogios = dao.find(TipoElogio.class);
        return elogios.stream().map(e -> new TipoElogioDto(e.getId(), e.getDescricao()))
                .collect(Collectors.toList());
    }

}
