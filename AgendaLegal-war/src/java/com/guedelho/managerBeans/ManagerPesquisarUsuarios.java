/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guedelho.managerBeans;

import com.guedelho.enums.StatusGenerico;
import com.guedelho.models.Usuario;
import com.guedelho.services.UsuarioService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author rodrigo
 */

@ManagedBean
@ViewScoped
public class ManagerPesquisarUsuarios implements Serializable{
    @EJB
    private UsuarioService usuarioService;
    private List<Usuario> usuarios;
    private Usuario usuario;
    
    public ManagerPesquisarUsuarios() {
    }
    
    @PostConstruct
    public void init(){
        this.limpar();
    }
    
    public void limpar() {
        usuario = new Usuario();
        usuario.setStatus(StatusGenerico.ATIVO);
        usuarios = new ArrayList<>();
    }
    
    public void pesquisar() {
        usuarios = usuarioService.find(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}   
