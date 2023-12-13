package prova2.questao10e11;

import java.util.ArrayList;
import java.util.List;

public class AuditoriaInterna {
	List<Tributavel> tributaveis = new ArrayList<>();
	
	public void adicionar(Tributavel tributavel) {
		tributaveis.add(tributavel);
	}
	
	public double calcularTributos() {
		double somaTributaveis = 0;
		for (Tributavel tributavel: tributaveis) {
			somaTributaveis += tributavel.calculaTributos();
		}
		return somaTributaveis;
	}
}
