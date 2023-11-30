package trabalho1;

import trabalho1.classesAux.Banco;
import trabalho1.classesAux.Conta;
import trabalho1.classesAux.ExcecaoTeste;
import trabalho1.questao10.ValorInvalidoError;

public class Questao6 {
	public static void main(String[] args) {
		Banco banco1 = new Banco();
		banco1.inserir(new Conta(123, "a", 123));
		banco1.inserir(new Conta(456, "b", 3));
		banco1.transferir(123, 456, 3);
		//O transferir acima transfere da "a" para a "b"
		banco1.inserir(new Conta(678, "c", -1));
		//São criadas duas contas para fazer os mesmos testes da
		//questão 5, incluindo o teste de transferir e ter exceção
		//e depois é criada uma conta com o saldo negativo para que seja lançada a exceção
	}
}
