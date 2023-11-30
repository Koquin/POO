package trabalho1.classesAux;

import trabalho1.questao10.ValorInvalidoError;
public class Conta {
    private int numero;
    private String nome;
    private double saldo;

    public Conta(int numero, String nome, double saldo) {
        this.numero = numero;
        this.nome = nome;
        //Sobre a questão 10:
        depositar(saldo);
    }
  //Sobre a questão 9, fiz a alteração:
    public void depositar(double valor) {
    	validarValor(valor);
        this.saldo += valor;
    }
  //Sobre a questão 9, fiz a alteração:
    public boolean sacar(double valor){
        validarValor(valor);
        this.saldo -= valor;
        return true;
    }
  //Sobre a questão 9, fiz a alteração:
    public boolean sacar1(double valor){
        if (this.saldo - valor < 0) {
            throw new Error ("Erro ao sacar (Este erro esta no pacote classesAux na classe Conta na linha 33)");
        }
        this.saldo -= valor;
        return true;
    }

    public double consultarSaldo() {
        return this.saldo;
    }
  //Sobre a questão 9, fiz a alteração:
    public boolean transferir(Conta conta, double valor) {
    	boolean sacou = sacar(valor);
    	if (sacou) {
    	conta.depositar(valor);
    	return true;
    	} else
    	throw new ExcecaoTeste("Erro ao transferir");
    	}
    public boolean transferir1(Conta conta, double valor) {
    	boolean sacou = sacar(valor);
    	if (!sacou) {
    	return false;
    	}
    	conta.depositar(valor);
    	return true;
    }
    
    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
    	this.saldo = saldo;
    }

    private void validarValor(double valor) {
    	if (valor <= 0) {
    		throw new ValorInvalidoError("Valor invalido (menor ou igual a zero)");
    	}
    }
}
