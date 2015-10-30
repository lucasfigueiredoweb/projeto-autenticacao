package controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.Result;
import model.UsuarioSessao;

public abstract class GenericController {
	
	@Inject protected UsuarioSessao usuarioSessao;
	@Inject protected Result result;
	@Inject protected HttpServletRequest request;

}