package trabalho1.classesAux;

import trabalho1.questao10.ValorInvalidoError;

public class Poupanca extends Conta {
	
	private double _taxaDeJuros;
	
	public Poupanca(int numero, String nome, double saldo, double _taxaDeJuros) throws ExcecaoTeste, ValorInvalidoError {
		super(numero, nome, saldo);
		this._taxaDeJuros = _taxaDeJuros;
	}
	
	public void set_TaxaDeJuros(double taxa) {
		this._taxaDeJuros = taxa;
	}
	
	public double get_TaxaDeJuros() {
		return this._taxaDeJuros;
	}
	
	
	
}
