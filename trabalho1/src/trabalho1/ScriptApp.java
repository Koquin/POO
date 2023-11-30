package trabalho1;
import java.util.*;
import trabalho1.classesAux.*;
import trabalho1.questao10.ValorInvalidoError;
import trabalho1.questao12.PoupancaInvalidaError;
import trabalho1.questao15.*;
import trabalho1.questao7.ContaInexistenteError;
public class ScriptApp {
	public static void main(String[] args) {
		boolean programaRodando = true;
		boolean mostrarOpcoes = true;
		Scanner teclado = new Scanner(System.in);
		Banco bancoDoBetin = new Banco();
		String nomeConta = "";
		int numeroConta = 0;
		double saldoConta = 0;
		float taxaJuros = 0;
		int opcaoEscolhida = 0;
		while (programaRodando) {
			while (mostrarOpcoes) {
				opcaoEscolhida = 0;
				menu();
				try {
					opcaoEscolhida = teclado.nextInt();
					MetodosAuxiliaresApp.validarOpcao(opcaoEscolhida);
					mostrarOpcoes = false;
				}
				catch(InputMismatchException e) {
					System.out.println("Erro: Nao foi digitado um numero valido");
					teclado.nextLine();
					mostrarOpcoes = true;
				}
				catch(OpcaoInvalidaError e) {
					System.out.println("Erro: Opcao Invalida");
					teclado.nextLine();
					mostrarOpcoes = true;
				}
				catch(RuntimeException e) {
					teclado.nextLine();
					System.out.println("Erro: contate o administrador");
				}		
		}
			switch (opcaoEscolhida) {
			case 1: {
				try {
					System.out.println("Digite o numero da conta:\n");
					numeroConta = teclado.nextInt();
					System.out.println("Digite o nome da conta:\n");
					teclado.nextLine();
					nomeConta = teclado.nextLine();
					System.out.println("Digite o valor a depositar na conta:\n");
					saldoConta = teclado.nextDouble();
					bancoDoBetin.inserir(new Conta (numeroConta, nomeConta, saldoConta));
				}catch (ContaInexistenteError e) {
					System.out.println(e.getMessage());
				}catch(InputMismatchException e) {
					System.out.println("Erro: Algum valor invalido foi digitado");
					teclado.nextLine();
				}catch (RuntimeException e) {
					System.out.println("Ocorreu um erro");
				}
				mostrarOpcoes = true;
				break;
			}
			case 2: {
				try {
					System.out.println("Digite o numero da conta:\n");
					numeroConta = teclado.nextInt();
					System.out.println("Digite o nome da conta:\n");
					teclado.nextLine();
					nomeConta = teclado.nextLine();
					System.out.println("Digite o valor a depositar na conta:\n");
					saldoConta = teclado.nextDouble();
					System.out.println("Digite a taxa de juros:\n");
					taxaJuros = teclado.nextFloat();
					bancoDoBetin.inserir(new Poupanca (numeroConta, nomeConta, saldoConta, taxaJuros));
				} catch (ContaInexistenteError e) {
					System.out.println(e.getMessage());
				}catch (InputMismatchException e) {
					System.out.println("Erro: Algum valor invalido foi digitado");
				} catch (RuntimeException e) {
					System.out.println("Ocorreu um erro");
				}
				mostrarOpcoes = true;
				break;
			}
			case 3: {
				try {
					System.out.println("Digite o valor a ser sacado:\n");
					double valorSaque = teclado.nextDouble();
					System.out.println("Digite o numero da conta:\n");
					teclado.nextLine();
					numeroConta = teclado.nextInt();
					bancoDoBetin.sacar(numeroConta, valorSaque);
				}
				catch (ContaInexistenteError e) {
					System.out.println(e.getMessage());
				}catch (ValorInvalidoError e) {
					System.out.println(e.getMessage());
				}
				catch (RuntimeException e) {
					System.out.println("Ocorreu um erro");
				}
				mostrarOpcoes = true;
				break;
			}
			case 4: {
				try {
					System.out.println("Digite o valor a ser depositado:\n");
					double valorDeposito = teclado.nextDouble();
					System.out.println("Digite o numero da conta:\n");
					teclado.nextLine();
					numeroConta = teclado.nextInt();
					bancoDoBetin.depositar(numeroConta, valorDeposito);
				}
				catch (ContaInexistenteError e) {
					System.out.println(e.getMessage());
				}catch (ValorInvalidoError e) {
					System.out.println(e.getMessage());
				}
				catch (RuntimeException e) {
					System.out.println("Ocorreu um erro");
				}
				mostrarOpcoes = true;
				break;
			}
			case 5: {
				try {
					System.out.println("Digite o numero da conta a ser debitada:\n");
					teclado.nextLine();
					numeroConta = teclado.nextInt();
					System.out.println("Digite o numero da conta a ser creditada:\n");
					int numeroContaDebito = teclado.nextInt();
					System.out.println("Digite o valor da transferencia:\n");
					double valorTransferencia = teclado.nextDouble();
					bancoDoBetin.transferir(numeroConta, numeroContaDebito, valorTransferencia);
				}
				catch (ContaInexistenteError e) {
					System.out.println(e.getMessage());
				}catch (ValorInvalidoError e) {
					System.out.println(e.getMessage());
				}
				catch (RuntimeException e) {
					System.out.println("Ocorreu um erro");
				}
				mostrarOpcoes = true;
				break;
			}
			case 6: {
				try {
					System.out.println("Digite o numero da conta poupanca a ter seu saldo creditado:\n");
					teclado.nextLine();
					numeroConta = teclado.nextInt();
					bancoDoBetin.renderJuros(numeroConta);
				} catch (ContaInexistenteError e) {
					System.out.println(e.getMessage());
				} catch (PoupancaInvalidaError e) {
					System.out.println(e.getMessage());
				}
				catch (RuntimeException e) {
					System.out.println("Ocorreu um erro");
				}
				mostrarOpcoes = true;
				break;
			}
			case 7: {
				try {
					System.out.println("Digite o numero da conta a ser excluida:\n");
					teclado.nextLine();
					numeroConta = teclado.nextInt();
					bancoDoBetin.excluir(numeroConta);
				} catch (ContaInexistenteError e) {
					System.out.println(e.getMessage());
				} catch (RuntimeException e) {
					System.out.println("Ocorreu um erro");
				}
				mostrarOpcoes = true;
				break;
			}
			case 8: {
				try {
					System.out.println("Digite o numero da conta que deseja alterar:\n");
					teclado.nextLine();
					numeroConta = teclado.nextInt();
					System.out.println("Digite o novo nome da conta:\n");
					nomeConta = teclado.nextLine();
					System.out.println("Digite o novo saldo da conta:\n");
					saldoConta = teclado.nextDouble();
					bancoDoBetin.alterar(new Conta (numeroConta, nomeConta, saldoConta));
				} catch (ValorInvalidoError e) {
					System.out.println(e.getMessage());
				}catch (ContaInexistenteError e) {
					System.out.println(e.getMessage());
				} catch (RuntimeException e) {
					System.out.println("Ocorreu um erro");
				}		
				mostrarOpcoes = true;
				break;
			}
			case 9: {
				try {
					System.out.println("Digite o numero da conta:\n");
					teclado.nextLine();
					numeroConta = teclado.nextInt();
					System.out.println("Saldo: " + bancoDoBetin.consultar(numeroConta).getSaldo());
				} catch (ValorInvalidoError e) {
					System.out.println(e.getMessage());
				} catch (ContaInexistenteError e) {
					System.out.println(e.getMessage());
				} catch (RuntimeException e) {
					System.out.println("Ocorreu um erro");
				} 
				mostrarOpcoes = true;
				break;
			}
			case 0: {
				System.out.println("Saindo do sistema...");
				mostrarOpcoes = false;
				programaRodando = false;
				break;
			}
		
			
			
			
		}
	}
}
	public static void menu() {
		System.out.println("Bem vindo ao banco do Betin\nDigite uma opção: "
				+ "\n1 - Inserir conta"
				+ "\n2 - Criar Poupanca"
				+ "\n3 - Sacar valor da conta"
				+ "\n4 - Depositar valor em conta"
				+ "\n5 - Transferir valor para conta"
				+ "\n6 - Render poupanca"
				+ "\n7 - Excluir conta"
				+ "\n8 - Alterar conta por indice"
				+ "\n9 - Consultar saldo"
				+ "\n0 - Sair");
	}
}
