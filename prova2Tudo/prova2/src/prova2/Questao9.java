package prova2;

import java.lang.reflect.Array;

import prova2.questao4e5.FiguraGeometrica1;
import prova2.questao4e5.Circulo;
import prova2.questao4e5.Quadrado;
import prova2.questao4e5.Retangulo;
import prova2.questao4e5.Triangulo;

public class Questao9 {
	public static void main(String[] args) {
		FiguraGeometrica1 circulo = new Circulo(5);
		System.out.println("Perimetro do circulo: " + circulo.calcularPerimetro());
		System.out.println("Area do circulo: " + circulo.calcularArea());
		FiguraGeometrica1 quadrado = new Quadrado(5);
		System.out.println("Perimetro do quadrado: " + quadrado.calcularPerimetro());
		System.out.println("Area do quadrado: " + quadrado.calcularArea());
		FiguraGeometrica1 retangulo = new Retangulo(5, 5);
		System.out.println("Perimetro do retangulo: " + retangulo.calcularPerimetro());
		System.out.println("Area do retangulo: " + retangulo.calcularArea());
		FiguraGeometrica1 triangulo = new Triangulo(5, 6, 7);
		System.out.println("Perimetro do triangulo: " + triangulo.calcularPerimetro());
		System.out.println("Area do triangulo: " + triangulo.calcularArea());
		
		System.out.println(triangulo.comparar(retangulo));
	
	}
}
