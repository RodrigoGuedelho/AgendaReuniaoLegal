/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guedelho.managerBeans;

import com.guedelho.enums.StatusGenerico;
import com.guedelho.models.Usuario;
import com.guedelho.services.UsuarioService;
import com.guedelho.utils.Msg;
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
    private Usuario usuarioDeletar;
    private StatusGenerico statusAtivo;
    private StatusGenerico statusCancelado;
    
    public ManagerPesquisarUsuarios() {
        
    }
    
    @PostConstruct
    public void init(){
        statusAtivo = StatusGenerico.ATIVO;
        statusCancelado = StatusGenerico.CANCELADO;
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
    
    public void cancelar() {
        try {
            usuarioService.cancelar(usuarioDeletar.getId());
            usuarios.remove(usuarioDeletar);
            Msg.messagemInfo(Msg.SuccessFull);
        } catch (Exception e) {
            Msg.messagemError(e.getMessage());
        }
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

    public Usuario getUsuarioDeletar() {
        return usuarioDeletar;
    }

    public void setUsuarioDeletar(Usuario usuarioDeletar) {
        this.usuarioDeletar = usuarioDeletar;
    }

    public StatusGenerico getStatusAtivo() {
        return statusAtivo;
    }

    public void setStatusAtivo(StatusGenerico statusAtivo) {
        this.statusAtivo = statusAtivo;
    }

    public StatusGenerico getStatusCancelado() {
        return statusCancelado;
    }

    public void setStatusCancelado(StatusGenerico statusCancelado) {
        this.statusCancelado = statusCancelado;
    }

   
    
    
}   
