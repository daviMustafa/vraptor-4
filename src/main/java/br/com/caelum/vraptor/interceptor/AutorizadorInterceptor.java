package br.com.caelum.vraptor.interceptor;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.annotations.Public;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.controller.LoginController;
import br.com.caelum.vraptor.controller.UsuarioLogado;

import javax.inject.Inject;

/**
 * @author ARCE - Davi Mustafa
 * @date 20/09/16
 */
@Intercepts
public class AutorizadorInterceptor {

    @Inject
    private UsuarioLogado usuarioLogado;
    @Inject
    private Result result;
    @Inject
    private ControllerMethod controllerMethod;

    // Metodos que possuem a anotação Public não serão interceptados
    @Accepts
    public boolean accepts(){
        return !controllerMethod.containsAnnotation(Public.class);
    }

    @AroundCall
    public void intercepta(SimpleInterceptorStack stack){

        if(usuarioLogado.getUsuario() == null){
            result.redirectTo(LoginController.class).formulario();
            return;
        }
        stack.next();
    }
}
