package trabalho1;

import trabalho1.classesAux.Conta;
import trabalho1.classesAux.ExcecaoTeste;
import trabalho1.questao10.ValorInvalidoError;

public class Questao4 {
	public static void main(String[] args){
		
		Conta conta1 = new Conta(123, "a", 200);
		Conta conta2 = new Conta(456, "b", 300);
		conta1.transferir1(conta2, 400);
		System.out.println(conta2.consultarSaldo());
		//Não foi debitado nada, pois existe verificação dentro de Conta 
		//que impede de debitar mais do que tem (desconsiderar operação).
		
	}
}
