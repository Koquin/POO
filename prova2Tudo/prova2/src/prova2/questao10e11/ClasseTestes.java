package prova2.questao10e11;

public class ClasseTestes {
	public static void main(String[] args) {
		
		AuditoriaInterna auditoria = new AuditoriaInterna();
		
		auditoria.adicionar(new ContaCorrente("Iago", 20020.0));
		auditoria.adicionar(new ContaCorrente("Jose", 42020.0));
		auditoria.adicionar(new ContaCorrente("Ramos", 6100260.0));
		auditoria.adicionar(new SeguroDeVida());
		System.out.println("Valor total dos tributos: " + auditoria.calcularTributos());


	}
}
