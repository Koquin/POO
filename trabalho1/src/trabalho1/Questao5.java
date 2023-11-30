package trabalho1;

import trabalho1.classesAux.Banco;
import trabalho1.classesAux.Conta;
import trabalho1.classesAux.ExcecaoTeste;
import trabalho1.questao10.ValorInvalidoError;

public class Questao5 {
	public static void main(String[] args) {
		Banco banco1 = new Banco();
		banco1.inserir(new Conta(123, "a", 321));
		banco1.inserir(new Conta(456, "b", 123));
		banco1.transferir(123, 456, 400);
		//Já que eu usei o método transferir da classe banco,
		//sim, o erro foi propagado para banco.transferir() e conta.transferir()
		//Seria também propagado para o scriptApp, porém como eu estou fazendo as questões separada por 
		//arquivos, scriptApp não foi usado.
	}
}
