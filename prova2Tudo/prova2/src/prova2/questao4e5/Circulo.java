package prova2.questao4e5;

import prova2.Questao8.Comparavel;

public class Circulo extends FiguraGeometrica1 implements Comparavel{
	private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
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
