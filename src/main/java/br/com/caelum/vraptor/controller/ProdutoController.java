package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.model.Produto;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller
public class ProdutoController {

	private final Result result;
    private final ProdutoDao dao;
    private Validator validator;


	@Inject
	public ProdutoController(Result result, ProdutoDao dao, Validator validator) {
		this.result = result;
        this.dao = dao;
        this.validator = validator;
	}
	
	/**
	 * Como foi usado o final no atributo Result, precisa passa
	 * o this com o valor null do Result
	 */
	public ProdutoController() {
		this(null, null, null);
	}

	@Get("/")
	public void inicio() {

	}

    @Get
    public void lista(){
        result.include("produtoList", dao.lista());
    }

	@Get
	public void listaEmXml() {
	    result.use(Results.xml()).from(dao.lista())
	            .exclude("quantidade").serialize();
	}

    @Get
    public void listaEmJson() {
        result.use(Results.json()).from(dao.lista()).serialize();
    }

    @Get
    public void formulario(){}

    @Post
    public void adiciona(@Valid Produto produto){
        validator.onErrorForwardTo(this).formulario();

        dao.adiciona(produto);
        result.include("mensagem", "Produto adicionado com sucesso");
        result.redirectTo(this).lista();
    }
}
