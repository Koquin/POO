package prova2.questao7;

import prova2.questao4e5.FiguraGeometrica1;

public class Triangulo implements FiguraGeometrica{
	private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
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
