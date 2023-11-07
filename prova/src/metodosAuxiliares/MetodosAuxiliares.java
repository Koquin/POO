package metodosAuxiliares;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import primeiraCamada.*;
import segundaCamada.*;

public class MetodosAuxiliares {

	public static RepositorioDePerfis repositorioPerfis = new RepositorioDePerfis();
	
	public static boolean ehEmail(String email) {
        // Padrão de expressão regular para validar um email
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        // Compila o padrão regex
        Pattern pattern = Pattern.compile(regex);

        // Cria um Matcher com a string de entrada
        Matcher matcher = pattern.matcher(email);

        // Verifica se o email corresponde ao padrão regex
        return matcher.matches();
    }
	public static boolean perfilValido(Perfil perfil, RepositorioDePerfis repositorioPerfis) {
		for (Perfil perfis : repositorioPerfis.getPerfis()) {
			if ((perfis.getId() == perfil.getId()) || (perfis.getNome() == perfil.getNome()) || (perfis.getEmail() == perfil.getEmail()) || (perfil.getEmail() == null) || (perfil.getNome() == null) || (perfil.getId() == 0)) {
				return false;
			}
		}
		if (MetodosAuxiliares.ehEmail(perfil.getEmail())) {
			return true;
		}
		return false;
	}
	public static boolean postagemValida(Postagem postagem, RepositorioDePostagens repositorioPostagens) {
		for (Postagem postagens : repositorioPostagens.getPostagens()) {
			if (postagens.getId() == postagem.getId() || postagem.getId() == 0 || postagem.getIdPerfil() == 0 || postagem.getTexto() == null) {
				return false;
			}
		}
		return true;
	}
	
}
