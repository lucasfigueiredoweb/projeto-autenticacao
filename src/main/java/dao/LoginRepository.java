package dao;

import model.Usuario;

public interface LoginRepository {

	Usuario autenticar(String login, String senha) throws Exception;
	
}