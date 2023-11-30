package trabalho1.classesAux;
import trabalho1.questao15.*;
public class MetodosAuxiliaresApp {
	public static void validarOpcao(int valor) {
		int contagem = 0;
		int valoresAceitaveisOpcao[] = {0, 1, 2, 3, 4, 5, 6, 7, 8,9};
		for (int value : valoresAceitaveisOpcao) {
			if (valor == value) {
				break;
			}
			else {
				contagem++;
			}
		}
		if (contagem >= valoresAceitaveisOpcao.length) {
			throw new OpcaoInvalidaError("Erro: Opcao Invalida");
		}
		
	}
	
	public static void validarNumeroConta(int numero) {
		if (numero > 1000000000) {
			throw new ContaInvalidaError("Numero de conta muito grande");			
		}
}
}
