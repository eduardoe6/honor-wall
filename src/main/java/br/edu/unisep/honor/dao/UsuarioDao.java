package br.edu.unisep.honor.dao;

import br.edu.unisep.honor.entity.Elogio;
import br.edu.unisep.honor.entity.Usuario;
import com.rcpadilha.hibernate.dao.HibernateDao;
import com.rcpadilha.hibernate.factory.HibernateSessionFactory;

import java.util.List;

public class UsuarioDao extends HibernateDao<Usuario> {

    public Usuario findByLogin(String login) {
        var session = HibernateSessionFactory.getSession();

        var q = session.createQuery("from Usuario where login = :LOGIN", Usuario.class);
        q.setParameter("LOGIN", login);

        var usuario = q.uniqueResult();
        session.close();

        return usuario;
    }

    public List<Usuario> listarDestinatarios(String login) {

        var session = HibernateSessionFactory.getSession();
        var q = session.createQuery("from Usuario where login != :LOGIN", Usuario.class);
        q.setParameter("LOGIN", login);
        var lista = q.list();

        session.close();

        return lista;
    }

}
