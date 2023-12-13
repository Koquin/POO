package segundaCamada;

import primeiraCamada.Perfil;
import java.util.List;

public interface IRepositorioDePerfis {
    int getTamanho();

    void incluir(Perfil perfil);

    List<Perfil> getPerfis();

    List<Perfil> consultar(Integer id, String nome, String email);

}
