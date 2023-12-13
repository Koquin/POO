package prova2.questao7;

public class Quadrado implements FiguraGeometrica{
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

}
