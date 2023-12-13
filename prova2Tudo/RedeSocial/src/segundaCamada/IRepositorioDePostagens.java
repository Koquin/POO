package segundaCamada;

import java.util.List;

import primeiraCamada.Postagem;

public interface IRepositorioDePostagens {

	public int getTamanho();

    public void incluirPostagem(Postagem postagem);

    public List<Postagem> getPostagens();

    public List<Postagem> consultar(int id, String texto, String hashtag, int idPerfil);
}
