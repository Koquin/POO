package terceiraCamada;
import primeiraCamada.*;
import segundaCamada.*;

import java.util.ArrayList;
import java.util.List;

import metodosAuxiliares.MetodosAuxiliares;
public class RedeSocial {
	private static RepositorioDePostagens repositorioPostagens = new RepositorioDePostagens();
	private static RepositorioDePerfis repositorioPerfis = new RepositorioDePerfis();
	

	public void incluirPerfil(Perfil perfil) {
		if (MetodosAuxiliares.perfilValido(perfil, repositorioPerfis)) {
			repositorioPerfis.incluir(perfil);
			System.out.println("Perfil criado com sucesso!");
		}
		else {
			System.out.println("Perfil inválido!");
		}
	}
	
	
	
	public static int getTamanho() {
		return repositorioPerfis.getTamanho();
	}



	public static void setRepositorioPerfis(RepositorioDePerfis repositorioPerfis) {
		RedeSocial.repositorioPerfis = repositorioPerfis;
	}



	public Perfil consultarPerfil(int id, String nome, String email) {
			return repositorioPerfis.consultar(id, nome, email);
	}
	
	public void incluirPostagem(Postagem postagem) {
				repositorioPostagens.incluirPostagem(postagem);
	}
	public List<Postagem> consultarPostagens(int id, String texto, String hashtag, int idPerfil) {
		return repositorioPostagens.consultar(id, texto, hashtag, idPerfil);
	}
	public void curtir (int idPostagem) {
		for (Postagem postagem: repositorioPostagens.getPostagens()) {
			if (postagem.getId() == idPostagem) {
				postagem.curtir();
			}
		}
	}
	public void descurtir (int idPostagem) {
		for (Postagem postagem: repositorioPostagens.getPostagens()) {
			if (postagem.getId() == idPostagem) {
				postagem.descurtir();
			}
		}
	}
	public void decrementarVisualizacoes(PostagemAvancada postagem) {
		if (postagem.getVisualizacoesRestantes() > 0) {
			postagem.decrementarVisualizacoes();
		}
	}
	public List<Postagem> exibirPostagensPorPerfil(int idPerfil) {
	    List<Postagem> postagensDoPerfil = new ArrayList<>();
	    
	    for (Postagem postagem : repositorioPostagens.getPostagens()) {
	        if (postagem.getIdPerfil() == idPerfil && postagem instanceof PostagemAvancada) {
	            PostagemAvancada postagemAvancada = (PostagemAvancada) postagem;
	            
	            if (postagemAvancada.getVisualizacoesRestantes() > 0) {
	                postagensDoPerfil.add(postagem);
	                postagemAvancada.decrementarVisualizacoes();
	            }
	        }
	    }
	    
	    return postagensDoPerfil;
	}

	
	public List<Postagem> exibirPostagensPorHashtag(String hashtag){
		List<Postagem> retornarPostagens = new ArrayList<>();
		for (Postagem postagem: repositorioPostagens.getPostagens()) {
			if (postagem instanceof PostagemAvancada && ((PostagemAvancada) postagem).getVisualizacoesRestantes() > 0 && ((PostagemAvancada) postagem).getHashtag(hashtag) == hashtag) {
				retornarPostagens.add(postagem);
				decrementarVisualizacoes((PostagemAvancada) postagem);
			}
		}
		return retornarPostagens;
	}
	
	
	
	
}
