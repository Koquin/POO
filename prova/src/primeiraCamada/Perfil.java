package primeiraCamada;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class Perfil {
    private static Set<Integer> usedIds = new HashSet<>();
    private int id;
    private String nome;
    private String email;

    public Perfil(String nome, String email) {
        this.id = generateUniqueRandomId();
        this.nome = nome;
        this.email = email;
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

    @Override
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
