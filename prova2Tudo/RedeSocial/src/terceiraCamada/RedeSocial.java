package terceiraCamada;
import primeiraCamada.*;
import segundaCamada.*;

import java.util.ArrayList;
import java.util.List;

public class RedeSocial {
	private static IRepositorioDePostagens repositorioPostagens;
	private static IRepositorioDePerfis repositorioPerfis;
	private int qualBd;
	public RedeSocial(int Bd) {
		if (Bd == 1) {
			repositorioPerfis = new RepositorioDePerfisPostgreSQL();
			repositorioPostagens = new RepositorioDePostagensPostgreSQL();
		}
		else {
			//instancie outro metodo de persistência de dados
		}
	}

	public void incluirPerfil(Perfil perfil) {
		if (repositorioPerfis instanceof RepositorioDePerfisPostgreSQL) {
			qualBd = 1;
		}
		switch (qualBd) {
		case 1: {
				repositorioPerfis.incluir(perfil);
				System.out.println("Perfil criado com sucesso!");
			break;
		}
		}
		
	}
	
	
	
	public static int getTamanho() {
		return repositorioPerfis.getTamanho();
	}



	public static void setRepositorioPerfis(RepositorioDePerfisPostgreSQL repositorioPerfis) {
		RedeSocial.repositorioPerfis = repositorioPerfis;
	}



	public List<Perfil> consultarPerfil(Integer id, String nome, String email) {
			return repositorioPerfis.consultar(id, nome, email);
	}
	
	public void incluirPostagem(Postagem postagem) {
				repositorioPostagens.incluirPostagem(postagem);
	}
	
	public List<Postagem> consultarPostagens(int id, String texto, String hashtag, int idPerfil) {
		return repositorioPostagens.consultar(id, texto, hashtag, idPerfil);
	}
	
	public void curtir (int idPostagem) {
		List<Postagem> postagensConsultadas = repositorioPostagens.consultar(3, null , null, -1);
		for (Postagem postagem : postagensConsultadas) {
			if (postagem.getId() == idPostagem) {
				postagem.curtir();	
			}
		}
	}
	
	public void descurtir (int idPostagem) {
		List<Postagem> postagensConsultadas = repositorioPostagens.consultar(3, null , null, -1);
		for (Postagem postagem : postagensConsultadas) {
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

	
	public List<Postagem> exibirPostagensPorHashtag(String hashtag) {
	    List<Postagem> retornarPostagens = new ArrayList<>();
	    for (Postagem postagem : repositorioPostagens.getPostagens()) {
	        if (postagem instanceof PostagemAvancada && ((PostagemAvancada) postagem).getVisualizacoesRestantes() > 0 && ((PostagemAvancada) postagem).getHashtags().contains(hashtag)) {
	            retornarPostagens.add(postagem);
	            decrementarVisualizacoes((PostagemAvancada) postagem);
	        }
	    }
	    return retornarPostagens;
	}

	
	
	
}
