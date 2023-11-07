package segundaCamada;

import java.util.ArrayList;
import java.util.List;
import primeiraCamada.Postagem;
import primeiraCamada.PostagemAvancada;

public class RepositorioDePostagens {
    private List<Postagem> postagens = new ArrayList<>();
    private int tamanho;

    public int getTamanho() {
        return tamanho;
    }

    public void incluirPostagem(Postagem postagem) {
            postagens.add(postagem);
            System.out.println("Postagem adicionada com sucesso!");
        }

    public List<Postagem> getPostagens() {
        return postagens;
    }

    public List<Postagem> consultar(int id, String texto, String hashtag, int idPerfil) {
        List<Postagem> postagensEncontradas = new ArrayList<>();

        for (Postagem postagem : postagens) {
            boolean matchId = (id == 0) || (postagem.getId() == id);
            boolean matchTexto = (texto == null) || postagem.getTexto().contains(texto);
            boolean matchHashtag = (hashtag == null) || (postagem instanceof PostagemAvancada && ((PostagemAvancada) postagem).getHashtags().contains(hashtag));
            boolean matchPerfil = (idPerfil == 0) || (postagem.getIdPerfil() == idPerfil);

            
            if (matchId || matchTexto || matchHashtag || matchPerfil) {
                if (postagem instanceof PostagemAvancada && ((PostagemAvancada) postagem).getVisualizacoesRestantes() > 0) {
                	((PostagemAvancada) postagem).decrementarVisualizacoes();
                    postagensEncontradas.add(postagem);
                }
                else {
                	continue;
                }
            }
        }

        return postagensEncontradas;
    }

}
