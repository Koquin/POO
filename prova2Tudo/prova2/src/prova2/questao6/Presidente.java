package prova2.questao6;

public class Presidente extends Funcionario {
	private double salario;
	private String login;
	private String senha;
	
	double getBonificacao() {
		double bonificacao = salario + 10000;
		return bonificacao;
	}
}
