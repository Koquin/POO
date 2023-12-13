package primeiraCamada;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostagemAvancada extends Postagem{
	
	private List<String> hashtag = new ArrayList<>();
	private int visualizacoesRestantes = 2;
    private static final String URL = "jdbc:postgresql://localhost:5432/RedeSocial";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "PMJ1w0t4D10u51";
	
 // Constructor
    public PostagemAvancada(String texto, int curtidas, int descurtidas, LocalDate data, int idPerfil) {
        super(texto, curtidas, descurtidas, data, idPerfil);
        this.id = getNextId();
    }

    private int getNextId() {
        int nextId = 0;
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(id) AS maxId FROM postagens");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                nextId = resultSet.getInt("maxId") + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nextId;
    }

	public String toString() {
		return super.toString() + " hashtags=" + hashtag + ", visualizacoesRestantes=" + visualizacoesRestantes + "]";
	}
	
	public List<String> getHashtags() {
        List<String> hashtags = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT tag FROM hashtag WHERE postagem_id = ?")) {
            preparedStatement.setInt(1, getId());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String hashtag = resultSet.getString("tag");
                    hashtags.add(hashtag);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hashtags;
    }
	
	public void adicionarHashtag(String hashtag) {
		this.hashtag.add(hashtag);
	}

	public boolean existeHashtag(String hashtag) {
		for (String hashtags : this.hashtag) {
			if (hashtags.equals(hashtag)) {
				return true;
			}
		}
		return false;
	}

	public int getVisualizacoesRestantes() {
		return visualizacoesRestantes;
	}

	public void decrementarVisualizacoes() {
		if (visualizacoesRestantes > 0) {
			visualizacoesRestantes--;
		}
	}
	
	public void setHashtags(List<String> hashtags) {
	    this.hashtag = hashtags;
	}


}