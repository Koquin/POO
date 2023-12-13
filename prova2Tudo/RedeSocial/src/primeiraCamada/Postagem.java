package primeiraCamada;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Postagem {
    protected int id;
    protected String texto;
    protected int curtidas;
    protected int descurtidas;
    protected LocalDate data;
    protected int idPerfil;
    private static final String URL = "jdbc:postgresql://localhost:5432/RedeSocial";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "PMJ1w0t4D10u51";
    // Constructor
    public Postagem(String texto, int curtidas, int descurtidas, LocalDate data, int idPerfil) {
        this.id = getNextId();
        this.texto = texto;
        this.curtidas = curtidas;
        this.descurtidas = descurtidas;
        this.data = data;
        this.idPerfil = idPerfil;
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

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	// Getters
    public int getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public int getDescurtidas() {
        return descurtidas;
    }

    public LocalDate getData() {
        return data;
    }
    public void curtir() {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "UPDATE postagens SET curtidas = curtidas + 1 WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, getId());
                preparedStatement.executeUpdate();
                curtidas++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void descurtir() {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "UPDATE postagens SET descurtidas = descurtidas + 1 WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, getId());
                preparedStatement.executeUpdate();
                descurtidas++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean ehPopular() {
        return ((curtidas + (descurtidas * 0.5) > descurtidas));
    }

    @Override
    public String toString() {
        return "Postagem [id=" + id + ", texto=" + texto + ", curtidas=" + curtidas + ", descurtidas=" + descurtidas
                + ", data=" + data + ", perfil=" + idPerfil + "]";
    }

	public void setId(int postId) {
		id = postId;
		
	}

}
