package prova2.questao4e5;

import prova2.Questao8.Comparavel;

public class Retangulo extends FiguraGeometrica1 implements Comparavel{
	private double comprimento;
    private double largura;

    public Retangulo(double comprimento, double largura) {
        this.comprimento = comprimento;
        this.largura = largura;
    }

    public double calcularArea() {
        return comprimento * largura;
    }

    public double calcularPerimetro() {
        return 2 * (comprimento + largura);
    }
    
    public int comparar(FiguraGeometrica1 f) {
		if (this.calcularArea() < f.calcularArea()) {
			return -1;
		}
		else if (this.calcularArea() == f.calcularArea()) {
			return 0;
		}
		else {
			return 1;
		}
		
	}
}
