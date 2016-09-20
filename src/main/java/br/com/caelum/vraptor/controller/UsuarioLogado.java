package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.model.Usuario;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author ARCE - Davi Mustafa
 * @date 20/09/16
 */
@Named
@SessionScoped
public class UsuarioLogado implements Serializable{

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
