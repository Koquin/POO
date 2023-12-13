package prova2.questao4e5;

import prova2.Questao8.Comparavel;

public abstract class FiguraGeometrica1 implements Comparavel{
	public abstract double calcularArea();
	public abstract double calcularPerimetro();
	
	public int comparar(FiguraGeometrica outraForma) {
        double areaAtual = this.calcularArea();
        double areaOutra = outraForma.calcularArea();

        if (areaAtual < areaOutra) {
            return -1;
        } else if (areaAtual > areaOutra) {
            return 1;
        } else {
            return 0;
        }
    }
}
