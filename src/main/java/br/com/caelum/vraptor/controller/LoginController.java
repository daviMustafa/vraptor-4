package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotations.Public;
import br.com.caelum.vraptor.dao.UsuarioDao;
import br.com.caelum.vraptor.model.Usuario;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

import javax.inject.Inject;

/**
 * @author ARCE - Davi Mustafa
 * @date 20/09/16
 */
@Controller
public class LoginController {

    private final UsuarioDao dao;
    private final Validator validator;
    private final Result result;
    private final UsuarioLogado usuarioLogado;

    @Inject
    public LoginController(UsuarioDao dao, Validator validator, Result result, UsuarioLogado usuarioLogado){
        this.dao = dao;
        this.validator = validator;
        this.result = result;
        this.usuarioLogado = usuarioLogado;
    }

    public LoginController(){
        this(null, null, null, null);
    }

    @Get
    @Public
    public void formulario(){

    }

    @Post
    @Public
    public void autentica(Usuario usuario){
        if(!dao.existe(usuario)){
            validator.add(new I18nMessage("login", "login.invalido"));
            validator.onErrorUsePageOf(this).formulario();
        }
        usuarioLogado.setUsuario(usuario);
        result.redirectTo(ProdutoController.class).lista();
    }
}
