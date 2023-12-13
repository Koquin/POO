package prova2.questao10e11;

public class ContaCorrente extends Conta implements Tributavel{
	String nome;
	double saldo;
	
	public ContaCorrente(String nome, double saldo) {
		this.nome = nome;
		this.saldo = saldo;
	}
	
	public double calculaTributos() {
		double tributos = (saldo * 0.1);
		return tributos;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
