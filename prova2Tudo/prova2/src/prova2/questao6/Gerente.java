package prova2.questao6;

public class Gerente extends Funcionario{
	private double salario;
	private String login;
	private String senha;
	
	public double getBonificacao() {
		double bonificacao = (salario * (40/100));
		return bonificacao;
	}

}
