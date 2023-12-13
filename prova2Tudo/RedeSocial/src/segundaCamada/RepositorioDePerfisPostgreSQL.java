package segundaCamada;

import primeiraCamada.Perfil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDePerfisPostgreSQL implements IRepositorioDePerfis {
    private static final String URL = "jdbc:postgresql://localhost:5432/RedeSocial";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "PMJ1w0t4D10u51";
    private List<Perfil> perfis = new ArrayList<>();
    
    @Override
    public void incluir(Perfil perfil) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO perfil (id, nome, email) VALUES (?, ?, ?)")) {
                preparedStatement.setInt(1, perfil.getId());
                preparedStatement.setString(2, perfil.getNome());
                preparedStatement.setString(3, perfil.getEmail());

                preparedStatement.executeUpdate();
                perfis.add(perfil);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public int getTamanho() {
	    int tamanho = 0;
	    try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
	         Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS total FROM perfil")) {

	        if (resultSet.next()) {
	            tamanho = resultSet.getInt("total");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return tamanho;
	}


	@Override
	public List<Perfil> getPerfis() {
		return perfis;
	}
	
	public List<Perfil> consultar(Integer id, String nome, String email) {
	    List<Perfil> perfisEncontrados = new ArrayList<>();
	    try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
	        StringBuilder queryBuilder = new StringBuilder("SELECT id, nome, email FROM perfil WHERE 1=1");

	        if (id != null && id != -1) {
	            queryBuilder.append(" AND id = ?");
	        }

	        if (nome != null) {
	            queryBuilder.append(" AND nome = ?");
	        }

	        if (email != null) {
	            queryBuilder.append(" AND email = ?");
	        }

	        try (PreparedStatement preparedStatement = connection.prepareStatement(queryBuilder.toString())) {
	            int parameterIndex = 1;

	            if (id != null && id != -1) {
	                preparedStatement.setInt(parameterIndex++, id);
	            }

	            if (nome != null) {
	                preparedStatement.setString(parameterIndex++, nome);
	            }

	            if (email != null) {
	                preparedStatement.setString(parameterIndex, email);
	            }

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                    String perfilNome = resultSet.getString("nome");
	                    String perfilEmail = resultSet.getString("email");
	                    int perfilId = resultSet.getInt("id");
	                    Perfil perfil = new Perfil(perfilId, perfilNome, perfilEmail);
	                    perfisEncontrados.add(perfil);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return perfisEncontrados;
	}


}
