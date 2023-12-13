package quartaCamada;

import terceiraCamada.RedeSocial;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import primeiraCamada.*;

public class App {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcao = 0;
        int opcao2 = 0;
        RedeSocial parekHighlights = null;
        boolean repetirEscolhaDeBD = true;
        while (repetirEscolhaDeBD) {
       	 try {
                escolherBD();
                opcao2 = teclado.nextInt();
                repetirEscolhaDeBD = false;
            } catch (InputMismatchException e) {
            	System.out.println("Digite um numero válido entre as opções mostradas");
            	repetirEscolhaDeBD = true;
                teclado.nextLine();
            } catch (Exception e) {
           	 System.out.println("Ocorreu um erro: Tente digitar uma opcao válida ou chame o administrador");
           	 repetirEscolhaDeBD = true;
             teclado.nextLine();
            }
       }

        switch (opcao2) {
        case 1: {
            parekHighlights = new RedeSocial(opcao2);
            System.out.println("PostgreSQL selecionado!");
            break;
        }
        case 4: {
        	System.out.println("Finalizando programa");
        	System.exit(0);
        }
        //Outros cases com construtores diferentes
        }
        do {
        	opcao = 0;
        	opcao2 = 0;
            LocalDate dataAtual = LocalDate.now();
            String nome = null;
            String email = null;
            int id = 0;
            Perfil perfil;
            String postagem = null;
            String hashtag = null;
            int idPerfil = 0;

                    menu();
                    opcao = teclado.nextInt();
                    switch (opcao) {
                        case 1:
                            teclado.nextLine();
                            System.out.println("Digite seu nome: ");
                            nome = teclado.nextLine();
                            System.out.println("Digite seu email: ");
                            email = teclado.nextLine();
                            perfil = new Perfil(nome, email);
                            parekHighlights.incluirPerfil(perfil);
                            break;
                        case 2:
                        	if (RedeSocial.getTamanho() == 0) {
                        		System.out.println("Ops! nenhum perfil criado ainda.");
                        		break;
                        	} else {
                        		int opcao3;
                                System.out.println("Quer procurar usando o que?"
                                        + "\n1 - id"
                                        + "\n2 - nome"
                                        + "\n3 - email "
                                        + "\n4 - todos"
                                        + "\n5 - cancelar");
                                opcao3 = teclado.nextInt();
                                if (opcao3 == 1) {
                                    System.out.println("Digite o id:");
                                    id = teclado.nextInt();
                                    try {
                                        System.out.println(parekHighlights.consultarPerfil(id, null, null));
                                    } catch (NullPointerException e) {
                                    	System.out.println("Ocorreu algum erro ao consultar os perfis, nada foi retornado.");
                                    }
                                } else if (opcao3 == 2) {
                                    System.out.println("Digite o nome: ");
                                    teclado.nextLine();
                                    nome = teclado.nextLine();
                                    try {
                                        System.out.println(parekHighlights.consultarPerfil(null, nome, null));
                                    } catch (NullPointerException e) {
                                    	System.out.println("Ocorreu algum erro ao consultar os perfis, nada foi retornado.");
                                    }
                                    } else if (opcao3 == 3) {
                                    System.out.println("Digite o email: ");
                                    teclado.nextLine();
                                    email = teclado.nextLine();
                                    try {
                                        System.out.println(parekHighlights.consultarPerfil(null, null, email));
                                    } catch (NullPointerException e) {
                                    	System.out.println("Ocorreu algum erro ao consultar os perfis, nada foi retornado.");
                                    }
                                } else if (opcao3 == 4) {
                                    System.out.println("Digite o id: ");
                                    id = teclado.nextInt();
                                    System.out.println("Digite o nome: ");
                                    teclado.nextLine();
                                    nome = teclado.nextLine();
                                    System.out.println("Digite o email: ");
                                    email = teclado.nextLine();
                                    try {
                                        System.out.println(parekHighlights.consultarPerfil(id, nome, email));
                                    } catch (NullPointerException e) {
                                    	System.out.println("Ocorreu algum erro ao consultar os perfis");
                                    }
                                } else if (opcao3 == 5) {
                                    System.out.println("Cancelado.");
                                }
                                break;
                        	}
                        case 3:{
                        	int opcao5 = 0;
                        		System.out.println("Digite o tipo de postagem:\n1 - Postagem normal\n2 - Postagem avançada");
                        		opcao5 = teclado.nextInt();
                        		if (opcao5 == 1) {
                        			System.out.println("Digite o texto que quer colocar na postagem: ");
                                    teclado.nextLine();
                                    postagem = teclado.nextLine();
                                    System.out.println("Digite o id do perfil:");
                                    try {
                                        idPerfil = teclado.nextInt();
                                    }catch (InputMismatchException e) {
                                    	System.out.println("Erro no input! Digite somente numeros.");
                                    } 
                                    Postagem postagem1 = new Postagem(postagem, 0, 0, dataAtual, idPerfil);
                                    parekHighlights.incluirPostagem(postagem1);
                                break;
                        		} else if (opcao5 == 2) {
                                    System.out.println("Digite o texto que quer colocar na postagem: ");
                                    teclado.nextLine();
                                    postagem = teclado.nextLine();
                                    System.out.println("Digite o id do perfil:");
                                    idPerfil = teclado.nextInt();
                                    System.out.println("Digite uma hashtag:");
                                    teclado.nextLine();
                                    hashtag = teclado.nextLine();
                                    PostagemAvancada postagem1 = new PostagemAvancada(postagem, 0, 0, dataAtual, idPerfil);
                                    postagem1.adicionarHashtag(hashtag);
                                    parekHighlights.incluirPostagem(postagem1);
                                break;
                        		}
                        }

                        case 4:
                            int opcao3 = 0;
                            System.out.println("Como quer procurar?"
                                    + "\n1 - usando id"
                                    + "\n2 - usando texto"
                                    + "\n3 - usando hashtag"
                                    + "\n4 - usando perfil"
                                    + "\n5 - usando todos"
                                    + "\n6 - cancelar");
                            opcao3 = teclado.nextInt();
                            
                            if (opcao3 == 1) {
                                System.out.println("Digite o id:");
                                id = teclado.nextInt();
                                for (Postagem postagem1 : parekHighlights.consultarPostagens(id, null, null, -1)) {
                                    System.out.println(postagem1 + "\n");
                                }

                            } else if (opcao3 == 2) {
                                System.out.println("Digite o texto ou parte dele:");
                                teclado.nextLine();
                                postagem = teclado.nextLine();
                                for (Postagem postagem1 : parekHighlights.consultarPostagens(-1, postagem, null, -1)) {
                                    System.out.println(postagem1 + "\n");
                                }
                            } else if (opcao3 == 3) {
                                System.out.println("Digite a hashtag");
                                teclado.nextLine();
                                hashtag = teclado.nextLine();
                                for (Postagem postagem1 : parekHighlights.consultarPostagens(-1, null, hashtag, -1)) {
                                    System.out.println((PostagemAvancada) postagem1 + "\n");
                                }
                            } else if (opcao3 == 4) {
                                System.out.println("Digite o id do perfil");
                                idPerfil = teclado.nextInt();
                                for (Postagem postagem1 : parekHighlights.consultarPostagens(-1, null, null, idPerfil)) {
                                    System.out.println(postagem1 + "\n");
                                }
                            } else if (opcao3 == 5) {
                                System.out.println("Digite o id da postagem:");
                                id = teclado.nextInt();
                                System.out.println("Digite o texto ou parte dele:");
                                teclado.nextLine();
                                postagem = teclado.nextLine();
                                System.out.println("Digite a hashtag: ");
                                hashtag = teclado.nextLine();
                                System.out.println("Digite o id do perfil: ");
                                idPerfil = teclado.nextInt();
                                for (Postagem postagem1 : parekHighlights.consultarPostagens(id, postagem, hashtag, idPerfil)) {
                                    System.out.println(postagem1 + "\n");
                                }
                            } else if (opcao3 == 6) {
                                System.out.println("Cancelado.");
                            }
                            break;

                        case 5: 
                            System.out.println("Digite o id da postagem:");
                            id = teclado.nextInt();
                            parekHighlights.curtir(id);
                            System.out.println("Postagem curtida!");
                            break;

                        case 6:
                            System.out.println("Digite o id da postagem:");
                            id = teclado.nextInt();
                            parekHighlights.descurtir(id);
                            System.out.println("Postagem descurtida!");
                            break;
                        case 9:
                        	System.out.println("Saindo do sistema...");
                        	teclado.close();
                        	break;
                    }
        }
        while (opcao != 9);
    }

    public static void menu() {
        System.out.println("Bem vindo ao Parek Highlights! A rede social com highlights do Parek."
                + "\nDigite o que quer fazer:"
                + "\n1 - Criar perfil"
                + "\n2 - Procurar perfil"
                + "\n3 - Criar postagem"
                + "\n4 - Procurar postagens"
                + "\n5 - Curtir postagem"
                + "\n6 - Descurtir postagem"
                + "\n9 - Sair"
                + "\nSua opção:");
    }
    public static void escolherBD() {
    	System.out.println("Antes de começar, escolha o método de persistência de dados que deseja usar:"
    			+ "\n1 - PostgreSQL"
    			+ "\n4 - sair");
    }
}

