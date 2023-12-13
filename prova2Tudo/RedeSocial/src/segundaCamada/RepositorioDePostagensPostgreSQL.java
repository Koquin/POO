package segundaCamada;

import primeiraCamada.Postagem;
import primeiraCamada.PostagemAvancada;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepositorioDePostagensPostgreSQL implements IRepositorioDePostagens {
    private static final String URL = "jdbc:postgresql://localhost:5432/RedeSocial";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "PMJ1w0t4D10u51";
    private List<Postagem> postagens = new ArrayList<>();

    public void incluirPostagem(Postagem postagem) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sqlPostagem = "INSERT INTO postagens (texto, id_perfil, data, curtidas, descurtidas) VALUES (?, ?, ?, 0, 0) RETURNING id";
            String sqlHashtag = "INSERT INTO hashtag (tag, postagem_id) VALUES (?, ?)";

            try (PreparedStatement preparedStatementPostagem = connection.prepareStatement(sqlPostagem);
                 PreparedStatement preparedStatementHashtag = connection.prepareStatement(sqlHashtag)) {
                connection.setAutoCommit(false);

                preparedStatementPostagem.setString(1, postagem.getTexto());
                preparedStatementPostagem.setInt(2, postagem.getIdPerfil());
                preparedStatementPostagem.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));  // Adicionando a data

                try (ResultSet generatedKeys = preparedStatementPostagem.executeQuery()) {
                    if (generatedKeys.next()) {
                        int postId = generatedKeys.getInt(1);

                        if (postagem instanceof PostagemAvancada) {
                            for (String hashtag : ((PostagemAvancada) postagem).getHashtags()) {
                                System.out.println("Hashtag adicionada (supostamente): " + hashtag);
                                preparedStatementHashtag.setString(1, hashtag);
                                preparedStatementHashtag.setInt(2, postId);
                                preparedStatementHashtag.executeUpdate();
                            }
                        }

                        connection.commit();
                        connection.setAutoCommit(true);
                        System.out.println("Postagem adicionada com sucesso!");
                    } else {
                        connection.rollback();
                        System.out.println("Falha ao obter ID da postagem.");
                    }
                }
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int getTamanho() {
        int tamanho = 0;
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS total FROM postagem")) {

            if (resultSet.next()) {
                tamanho = resultSet.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tamanho;
    }

    @Override
    public List<Postagem> getPostagens() {
        return postagens;
    }

    public List<Postagem> consultar(int id, String texto, String hashtag, int idPerfil) {
        List<Postagem> postagensEncontradas = new ArrayList<>();

        StringBuilder sqlBuilder = new StringBuilder("SELECT DISTINCT p.id, p.texto, p.id_perfil, p.curtidas, p.descurtidas, p.data, h.tag FROM postagens p ");
        sqlBuilder.append("LEFT JOIN hashtag h ON p.id = h.postagem_id WHERE ");

        List<Object> parametros = new ArrayList<>();

        if (id != -1) {
            sqlBuilder.append("(p.id = ? OR ? = -1) AND ");
            parametros.add(id);
            parametros.add(id);
        }

        if (texto != null) {
            sqlBuilder.append("(p.texto LIKE ? OR ? IS NULL) AND ");
            parametros.add("%" + texto + "%");
            parametros.add(texto);
        }

        if (hashtag != null) {
            sqlBuilder.append("(h.tag LIKE ? OR ? IS NULL) AND ");
            parametros.add("%" + hashtag + "%");
            parametros.add(hashtag);
        }

        if (idPerfil != -1) {
            sqlBuilder.append("(p.id_perfil = ? OR ? = -1) AND ");
            parametros.add(idPerfil);
            parametros.add(idPerfil);
        }

        // Remove o último "AND" da consulta
        sqlBuilder.setLength(sqlBuilder.length() - 5);

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlBuilder.toString())) {

            // Configura os parâmetros na ordem correta
            for (int i = 0; i < parametros.size(); i++) {
                preparedStatement.setObject(i + 1, parametros.get(i));
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                            int postId = resultSet.getInt("id");
                            String postTexto = resultSet.getString("texto");
                            int postIdPerfil = resultSet.getInt("id_perfil");
                            int curtidas = resultSet.getInt("curtidas");
                            int descurtidas = resultSet.getInt("descurtidas");
                            LocalDate data = resultSet.getDate("data").toLocalDate();
                            String postHashtag = resultSet.getString("tag");

                            Postagem postagem;
                            if (postHashtag != null) {
                                // Ajuste para criar instância de PostagemAvancada e configurar as hashtags
                                PostagemAvancada postagemAvancada = new PostagemAvancada(postTexto, curtidas, descurtidas, data, postIdPerfil);
                                postagemAvancada.setId(postId);
                                postagemAvancada.setHashtags(Arrays.asList(postHashtag.split(", ")));
                                postagem = postagemAvancada;
                            } else {
                                // Cria instância padrão de Postagem
                                postagem = new Postagem(postTexto, curtidas, descurtidas, data, postIdPerfil);
                                postagem.setId(postId);
                            }

                            postagensEncontradas.add(postagem);                 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return postagensEncontradas;
    }
}