package prova2.questao7;
import java.util.*;
public class ScriptQ7 {
	public static void main(String[] args) {
		Circulo circulo = new Circulo(5);
		System.out.println("Perimetro do circulo: " + circulo.calcularPerimetro());
		System.out.println("Area do circulo: " + circulo.calcularArea());
		Quadrado quadrado = new Quadrado(5);
		System.out.println("Perimetro do quadrado: " + quadrado.calcularPerimetro());
		System.out.println("Area do quadrado: " + quadrado.calcularArea());
		Retangulo retangulo = new Retangulo(5, 5);
		System.out.println("Perimetro do retangulo: " + retangulo.calcularPerimetro());
		System.out.println("Area do retangulo: " + retangulo.calcularArea());
		Triangulo triangulo = new Triangulo(5, 6, 7);
		System.out.println("Perimetro do triangulo: " + triangulo.calcularPerimetro());
		System.out.println("Area do triangulo: " + triangulo.calcularArea());
	}
}
