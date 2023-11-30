package trabalho1.classesAux;
import java.util.ArrayList;
import java.util.List;

import trabalho1.questao12.PoupancaInvalidaError;
import trabalho1.questao7.ContaInexistenteError;

public class Banco {
    private List<Conta> contas = new ArrayList<>();

    public void inserir(Conta conta) {
    	//Questão 13:
    	try{
        	consultar(conta.getNumero());
    	}
    	catch(ContaInexistenteError contaInexistente) {
    		this.contas.add(conta);
    	}
    	
    }

    public Conta consultar(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        throw new ContaInexistenteError("Erro: Conta não encontrada");
    }

    public int consultarPorIndice(int numero) {
        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumero() == (numero)) {
                return i;
            }
        }
        throw new ContaInexistenteError("Erro: Conta não encontrada");
    }
  //Sobre a questao 9:
    public void alterar(Conta conta) {
        int indiceProcurado = consultarPorIndice(conta.getNumero());
        contas.set(indiceProcurado, conta);
    }
    
    public void excluir(int numero) {
        int indiceProcurado = consultarPorIndice(numero);
        contas.remove(indiceProcurado);
    }
  //Sobre a questao 9:
    public void sacar(int numero, double valor){
        int indiceProcurado = consultarPorIndice(numero);
        Conta conta = contas.get(indiceProcurado);
        conta.sacar(valor);
    }
  //Sobre a questao 9:
    public void depositar(int numero, double valor){
        int indiceProcurado = consultarPorIndice(numero);
        Conta conta = contas.get(indiceProcurado);
        conta.depositar(valor);
    }
    
  //Sobre a questao 9:
    public void transferir(int numeroCredito, int numeroDebito, double valor){
        Conta contaCredito = consultar(numeroCredito);
        Conta contaDebito = consultar(numeroDebito);
        contaCredito.transferir(contaDebito, valor);
    }
    
    public int quantidadeDeContas() {
        return contas.size();
    }

    public double totalDinheiroDepositado() {
        double total = 0;

        for (Conta conta : contas) {
            total += conta.getSaldo();
        }

        return total;
    }

    public double mediaSaldoContas() {
        int quantidade = quantidadeDeContas();

        if (quantidade > 0) {
            double total = totalDinheiroDepositado();
            return total / quantidade;
        } else {
            return 0;
     }
    }
    //Sobre a questao 9:
    public void renderJuros(int indice) {
        Conta renderConta = consultar(indice);

        if (renderConta instanceof Poupanca) {
            Poupanca poupanca = (Poupanca) renderConta;
            poupanca.setSaldo(poupanca.getSaldo() + (poupanca.getSaldo() * (poupanca.get_TaxaDeJuros() / 100)));
        } else {
        	//Questão 12:
        	throw new PoupancaInvalidaError("Conta não é poupanca");
        }
    }
}
