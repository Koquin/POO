package primeiraCamada;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Perfil {
    private int id;
    private String nome;
    private String email;
    private static final String URL = "jdbc:postgresql://localhost:5432/RedeSocial";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "PMJ1w0t4D10u51";

    public Perfil(String nome, String email) {
        this.id = getNextId();
        this.nome = nome;
        this.email = email;
    }
    public Perfil(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    private int getNextId() {
        int nextId = 0;
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(id) AS maxId FROM perfil");
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
        return "Perfil [id=" + id + ", nome=" + nome + ", email=" + email + "]";
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}

