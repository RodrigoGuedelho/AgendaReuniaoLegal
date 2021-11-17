/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guedelho.utils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author rodrigo
 */
public class Msg {
    public static final String SuccessFull = "Operação Realizada com Sucesso";
    public static final String Failure = "Erro ao Realizar a Operação";
    public static final String PermissaoNegada = "Você não tem permissão para executar esta operação !";

    public static void messagemInfo(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
    }

    public static void messagemError(String message) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, ""));
        } catch (Exception e) {
        }
    }

    public static void messagemWarn(String message) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, ""));
        } catch (Exception e) {
        }
    }

    public static void messagemInfoRedirect(String message, String url) {
        try {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            FacesContext fc = FacesContext.getCurrentInstance();
            FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
            fc.getExternalContext().getFlash().setKeepMessages(true);
            try {
                context.redirect(url);
            } catch (IOException ex) {
                Logger.getLogger(Msg.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
        }
    }
}

