package controllers;


import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import dao.LoginRepository;
import model.Usuario;


@Controller
public class LoginController extends GenericController {
	
	@Inject private LoginRepository repository;
	
	@Get("/login")
	public void login() {
	
	}
	
	@Get("/logout")
	public void logout() {
		usuarioSessao.invalidaSessao();
		request.getSession().setAttribute("usuarioSessao", null);
		request.getSession().invalidate();
		result.redirectTo(this).login();
	}
	
	@Post("/autenticar")
	public void autenticar(Usuario usuario) {
		try {
			Usuario user = repository.autenticar(usuario.getLogin(),
			usuario.getSenha());
			
			if (user != null) {
				usuarioSessao.setUsuario(user);
				request.getSession().setAttribute("usuarioSessao", usuarioSessao);
				result.include(user);
				result.redirectTo(IndexController.class).index();
				
			} else {
				result.include("error", "Email ou senha inválidos!");
				result.redirectTo(this).login();
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.redirectTo(this).login();
		}
	}

}