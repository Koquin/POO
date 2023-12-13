package prova2.questao4e5;

import prova2.Questao8.Comparavel;

public class Quadrado extends FiguraGeometrica1 implements Comparavel{
	double lado;
	
	public Quadrado(double lado) {
        this.lado = lado;
    }

    public double calcularArea() {
        return lado * lado;
    }

    public double calcularPerimetro() {
        return 4 * lado;
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
