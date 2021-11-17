/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guedelho.services;

import com.guedelho.enums.StatusGenerico;
import com.guedelho.models.Usuario;
import com.guedelho.utils.Util;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rodrigo
 */

@Stateless
public class UsuarioService {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    
    public void salvar(Usuario usuario) {
        try {
            usuario.setSenha(usuario.encryptPassword(usuario.getSenha()));
            entityManager.persist(usuario);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        
    }
    
    public void editar(Usuario usuario) {
        try {
            usuario.setSenha(usuario.encryptPassword(usuario.getSenha()));
            entityManager.merge(usuario);
            entityManager.flush();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        
    }
    
    public Usuario findByIdActive(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        return usuario != null && usuario.getStatus().equals(StatusGenerico.ATIVO) ? usuario : null;
    }
    
    public List<Usuario> find(Usuario usuario) {
        String sql = "select u from Usuario u where u.status = :status ";

        if (Util.isEmpit(usuario.getNome()))
            sql += "and lower(u.nome) like lower(:nome) ";    
        if (Util.isEmpit(usuario.getLogin())) 
            sql += "and lower(u.login) like lower(:login) ";


        Query query = entityManager.createQuery(sql);

        query.setParameter("status", usuario.getStatus());

        if (Util.isEmpit(usuario.getNome()))
           query.setParameter("nome","%" + usuario.getNome() + "%");
        if (Util.isEmpit(usuario.getLogin())) 
            query.setParameter("login", "%" + usuario.getLogin() + "%");
      
        List<Usuario> usuarios = query.getResultList();
        return usuarios;
    }
    
}
