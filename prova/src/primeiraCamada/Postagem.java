package primeiraCamada;

import java.time.LocalDate;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class Postagem {
    private static Set<Integer> usedIds = new HashSet<>();
    private int id;
    private String texto;
    private int curtidas;
    private int descurtidas;
    private LocalDate data;
    private int idPerfil;
    // Constructor
    public Postagem(String texto, int curtidas, int descurtidas, LocalDate data, int idPerfil) {
        this.id = generateUniqueRandomId();
        this.texto = texto;
        this.curtidas = curtidas;
        this.descurtidas = descurtidas;
        this.data = data;
        this.idPerfil = idPerfil;
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
        curtidas++;
    }

    public void descurtir() {
        descurtidas--;
    }

    public boolean ehPopular() {
        return ((curtidas + (descurtidas * 0.5) > descurtidas));
    }

    @Override
    public String toString() {
        return "Postagem [id=" + id + ", texto=" + texto + ", curtidas=" + curtidas + ", descurtidas=" + descurtidas
                + ", data=" + data + ", perfil=" + idPerfil + "]";
    }

    private int generateUniqueRandomId() {
        Random rand = new Random();
        int uniqueId;
        do {
            uniqueId = rand.nextInt(10000) + 1;
        } while (usedIds.contains(uniqueId));

        usedIds.add(uniqueId);
        return uniqueId;
    }
}
