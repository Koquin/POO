package segundaCamada;

import java.util.ArrayList;
import java.util.List;

import primeiraCamada.Perfil;

public class RepositorioDePerfis {
	private List<Perfil> perfis = new ArrayList<>();
	private int tamanho;
	
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void incluir(Perfil perfil) {
		this.perfis.add(perfil);
		tamanho++;
	}
	
	public List<Perfil> getPerfis(){
		return perfis;
	}
	
	public Perfil consultar(int id, String nome, String email) {
	    List<Perfil> perfisEncontrados = new ArrayList<>();
	    
	    for (Perfil perfil : perfis) {
	        if ((id == 0 || id == perfil.getId()) ||
	            (nome == null || email != null && nome.equals(perfil.getNome()) && email.equals(perfil.getEmail())) ||
	            (nome == null || nome.equals(perfil.getNome())) ||
	            (email == null || email.equals(perfil.getEmail()))){
	            perfisEncontrados.add(perfil);
	        }
	    }
	    
	    if (perfisEncontrados.isEmpty()) {
	        return null;  // Nenhum perfil correspondente foi encontrado.
	    } else if (perfisEncontrados.size() == 1) {
	        return perfisEncontrados.get(0);  // Apenas um perfil foi encontrado.
	    } else {
	        // Vários perfis correspondentes foram encontrados. Mostrar mensagem.
	        System.out.println("Foram encontrados vários perfis com o nome especificado:");
	        for (Perfil perfil : perfisEncontrados) {
	            System.out.println(perfil);
	        }
	        return null;
	    }
	}


}
