package trabalho1;

import trabalho1.classesAux.Conta;

public class Questao3 {
	public static void main(String[] args){
		Conta conta1 = new Conta(123, "a", 300);
		conta1.sacar1(302);
		//O metodo sacar1 é uma variação do sacar que fiz só para essa questão, contendo o lançamento da exceção.
	}
}
