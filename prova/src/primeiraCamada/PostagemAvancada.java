package primeiraCamada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostagemAvancada extends Postagem{
	
	private List<String> hashtag = new ArrayList<>();
	private int visualizacoesRestantes = 2;
	
	//Constructor
	public PostagemAvancada(String texto, int curtidas, int descurtidas, LocalDate data, int idPerfil) {
		super(texto, curtidas, descurtidas, data, idPerfil);
	}
	
	
	@Override
	public String toString() {
		return super.toString() + " hashtag=" + hashtag + ", visualizacoesRestantes=" + visualizacoesRestantes + "]";
	}


	public String getHashtag(String hashtag) {
		for (String hashtags : this.hashtag) {
			if (hashtags.equals(hashtag)) {
				return hashtag;
			}
		}
		return null;
	}
	public List<String> getHashtags() {
		return this.hashtag;
	}


	public int getVisualizacoesRestantes() {
		return visualizacoesRestantes;
	}

	public void adicionarHashtag(String hashtag) {
		this.hashtag.add(hashtag);
	}
	public boolean existeHashtag(String hashtag) {
		for (String hashtags: this.hashtag) {
			if (hashtags == hashtag) {
				return true;
			}
		}
		return false;
	}
	public void decrementarVisualizacoes() {
		visualizacoesRestantes--;
	}
}
