package prova2.questao6;

public class Diretor extends Funcionario{
	private double salario;
	private String login;
	private String senha;
	
	double getBonificacao() {
		double bonificacao = salario * (60/100);
		return bonificacao;
	}

}
