/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guedelho.managerBeans;

import com.guedelho.models.Usuario;
import com.guedelho.services.UsuarioService;
import com.guedelho.utils.Msg;
import com.guedelho.utils.Util;
import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author rodrigo
 */

@ManagedBean
@ViewScoped
public class ManagerUsuario implements Serializable{
    @EJB
    UsuarioService usuarioService;
    
    private Usuario usuario;
 
    
    public void salvar() {
        try {
            if (!Util.isEmpitNumberLong(usuario.getId()))
                usuarioService.editar(usuario);
            else
                usuarioService.salvar(usuario);
            usuario = new Usuario();
            Msg.messagemInfo(Msg.SuccessFull);
            System.err.println("Salvou");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public ManagerUsuario() {
    }
    
    @PostConstruct
    public void init() {
        usuario = new Usuario();
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("id");
        if (!Util.isEmpit(id)) {
            try {
                usuario = usuarioService.findByIdActive(Long.parseLong(id));
                if (usuario != null)
                    usuario.setSenha("");
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
