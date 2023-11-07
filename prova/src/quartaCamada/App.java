package quartaCamada;
/*
import terceiraCamada.RedeSocial;

import java.time.LocalDate;
import java.util.Scanner;
import primeiraCamada.*;
import segundaCamada.*;
public class App {
	static private RedeSocial parekHighlights = new RedeSocial();
	private static RepositorioDePerfis repositorioPerfis = new RepositorioDePerfis();
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int opcao = 0;
		do {
			boolean logado = false;
			int opcao4 = 0;
			String nome;
			String senha;
			String email = null;
			int id = 0;
			Perfil perfil;
			String postagem = null;
			Perfil perfilLogado = null;
			String hashtag = null;
			int idPerfil;
			LocalDate dataAtual = LocalDate.now();
			do {
				System.out.println("1 - Logar\n2 - Continuar");
				opcao4 = teclado.nextInt();
				if (opcao4 == 1) {
					parekHighlights.login();
					logado = true;
					for (Perfil perfil1: repositorioPerfis.getPerfis()) {
						if (perfil1.logado == true) {
							perfilLogado = perfil1;
						}
					}
				}
				else {
					menu();
					opcao = teclado.nextInt();
						switch (opcao) {
						case 1:
							teclado.nextLine();
							System.out.println("Digite seu nome: ");
							nome = teclado.nextLine();
							System.out.println("Digite sua senha: ");
							senha = teclado.nextLine();
							System.out.println("Digite seu email: ");
							email = teclado.nextLine();
							perfil = new Perfil(nome, email, senha);
							parekHighlights.incluirPerfil(perfil);
							System.out.println("Perfil criado com sucesso!");
							break;				
						case 2:
							int opcao2;
							System.out.println("Quer procurar usando o que?"
									+ "\n1 - id"
									+ "\n2 - nome"
									+ "\n3 - email "
									+ "\n4 - todos"
									+ "\n5 - cancelar");
							opcao2 = teclado.nextInt();
							if (opcao2 == 1) {
								System.out.println("Digite o id:");
								nome = null;
								email = null;
								id = teclado.nextInt();
							} else if (opcao2 == 2) {
								System.out.println("Digite o nome: ");
								id = 0;
								email = null;
								nome = teclado.nextLine();
							} else if (opcao2 == 3) {
								System.out.println("Digite o email: ");
								id = 0;
								nome = null;
								email = teclado.nextLine();
								parekHighlights.consultarPerfil(id, nome, email);
							} else if (opcao2 == 4) {
								System.out.println("Digite o id: ");
								id = teclado.nextInt();
								System.out.println("Digite o nome: ");
								nome = teclado.nextLine();
								System.out.println("Digite o email: ");
								email = teclado.nextLine();
								parekHighlights.consultarPerfil(id, nome, email);
							} else if (opcao2 == 5) {
								System.out.println("Cancelado.");
							}
							break;
						case 3:
							if (logado) {
								System.out.println("Digite o texto que quer postar: ");
								postagem = teclado.nextLine();
								Postagem postagem1 = new Postagem(perfilLogado.getId(), postagem, 0, 0, dataAtual, perfilLogado);
								parekHighlights.incluirPostagem(postagem1);
							}
							else {
								System.out.println("Impossivel postar sem estar logado");
							}
							break;
							
						case 4:
							int opcao3 = 0;
							System.out.println("Como quer procurar?"
									+ "\n1 - usando id"
									+ "\n2 - usando texto"
									+ "\n3 - usando hashtag"
									+ "\n4 - usando perfil"
									+ "\n5 - usando todos"
									+ "\n6 - cancelar");
									opcao = teclado.nextInt();
							
						if (opcao3 == 1) {
							System.out.println("Digite o id:");
							id = teclado.nextInt();
							for (Postagem postagem1 : parekHighlights.consultarPostagens(id, email, postagem, null)) {
								System.out.println(postagem1 + "\n");
							}

						} else if (opcao3 == 2) {
							System.out.println("Digite o texto ou parte dele:");
							postagem = teclado.nextLine();
							for (Postagem postagem1 : parekHighlights.consultarPostagens(id, email, postagem, null)) {
								System.out.println(postagem1 + "\n");
							}
						} else if (opcao3 == 3) {
							System.out.println("Digite a hashtag");
							hashtag = teclado.nextLine();
							for (Postagem postagem1 : parekHighlights.consultarPostagens(id, postagem, hashtag, null)) {
								System.out.println(postagem1 + "\n");
							}
						} else if (opcao3 == 4) {
							System.out.println("Digite o id do perfil");
							idPerfil= teclado.nextInt();
							for (Postagem postagem1 : parekHighlights.consultarPostagens(id, postagem, hashtag, parekHighlights.consultarPerfil(idPerfil, null, null))) {
								System.out.println(postagem1 + "\n");
							}
						} else if (opcao3 == 5) {
							System.out.println("Digite o id da postagem:");
							id = teclado.nextInt();
							System.out.println("Digite o texto ou parte dele:");
							postagem = teclado.nextLine();
							System.out.println("Digite a hashtag: ");
							hashtag = teclado.nextLine();
							System.out.println("Digite o id do perfil: ");
							idPerfil = teclado.nextInt();
						} else if (opcao3 == 6) {
							System.out.println("Cancelado.");
						}
						break;
						case 5: 
							System.out.println("Digite o id da postagem:");
							id = teclado.nextInt();
							parekHighlights.curtir(id);
							break;
						case 6:
							System.out.println("Digite o id da postagem:");
							id = teclado.nextInt();
							parekHighlights.descurtir(id);
							break;
						case 7:
							System.out.println("Digite o ID do perfil que contém as postagens: ");
							idPerfil = teclado.nextInt();
							parekHighlights.exibirPostagensPorPerfil(idPerfil);
							break;
						case 8:
							System.out.println("Digite a Hashtag que está contida nas postagens: ");
							hashtag = teclado.nextLine();
							parekHighlights.exibirPostagensPorHashtag(hashtag);
							break;
						case 9:
							System.out.println("Saindo do sistema");
							break;
					}
				}
			}
			while (logado == false);
		}
		while (opcao != 9);
	}
	
	public static void menu () {
		System.out.println("Bem vindo ao Parek Highlights! A rede social com highlights do Parek."
				+ "\nDigite o que quer fazer:"
				+ "\n1 - Criar perfil"
				+ "\n2 - Procurar perfil"
				+ "\n3 - Criar postagem"
				+ "\n4 - Procurar postagens"
				+ "\n5 - Curtir postagem"
				+ "\n6 - Descurtir postagem"
				+ "\n7 - Exibir postagens por perfil"
				+ "\n8 - Exibir postagens por hashtag"
				+ "\n9 - Sair"
				+ "\nSua opção:");
	}

}
*/

import terceiraCamada.RedeSocial;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import primeiraCamada.*;

public class App {
    static private RedeSocial parekHighlights = new RedeSocial();

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcao = 0;
        do {
        	opcao = 0;
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
                        		int opcao2;
                                System.out.println("Quer procurar usando o que?"
                                        + "\n1 - id"
                                        + "\n2 - nome"
                                        + "\n3 - email "
                                        + "\n4 - todos"
                                        + "\n5 - cancelar");
                                opcao2 = teclado.nextInt();
                                if (opcao2 == 1) {
                                    System.out.println("Digite o id:");
                                    id = teclado.nextInt();
                                    try {
                                        System.out.println(parekHighlights.consultarPerfil(id, "-1", "-1").toString());
                                    } catch (NullPointerException e) {
                                    	System.out.println("Ocorreu algum erro ao consultar os perfis, nada foi retornado.");
                                    }
                                } else if (opcao2 == 2) {
                                    System.out.println("Digite o nome: ");
                                    teclado.nextLine();
                                    nome = teclado.nextLine();
                                    try {
                                        System.out.println(parekHighlights.consultarPerfil(-1, nome, "-1").toString());
                                    } catch (NullPointerException e) {
                                    	System.out.println("Ocorreu algum erro ao consultar os perfis, nada foi retornado.");
                                    }
                                    } else if (opcao2 == 3) {
                                    System.out.println("Digite o email: ");
                                    teclado.nextLine();
                                    email = teclado.nextLine();
                                    try {
                                        System.out.println(parekHighlights.consultarPerfil(-1, "-1", email).toString());
                                    } catch (NullPointerException e) {
                                    	System.out.println("Ocorreu algum erro ao consultar os perfis, nada foi retornado.");
                                    }
                                } else if (opcao2 == 4) {
                                    System.out.println("Digite o id: ");
                                    id = teclado.nextInt();
                                    System.out.println("Digite o nome: ");
                                    teclado.nextLine();
                                    nome = teclado.nextLine();
                                    System.out.println("Digite o email: ");
                                    email = teclado.nextLine();
                                    try {
                                        System.out.println(parekHighlights.consultarPerfil(id, nome, email).toString());
                                    } catch (NullPointerException e) {
                                    	System.out.println("Ocorreu algum erro ao consultar os perfis");
                                    }
                                } else if (opcao2 == 5) {
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
                                for (Postagem postagem1 : parekHighlights.consultarPostagens(id, "-1", "-1", -1)) {
                                    System.out.println(postagem1 + "\n");
                                }

                            } else if (opcao3 == 2) {
                                System.out.println("Digite o texto ou parte dele:");
                                teclado.nextLine();
                                postagem = teclado.nextLine();
                                for (Postagem postagem1 : parekHighlights.consultarPostagens(-1, postagem, "-1", -1)) {
                                    System.out.println(postagem1 + "\n");
                                }
                            } else if (opcao3 == 3) {
                                System.out.println("Digite a hashtag");
                                teclado.nextLine();
                                hashtag = teclado.nextLine();
                                for (Postagem postagem1 : parekHighlights.consultarPostagens(-1, "-1", hashtag, -1)) {
                                    System.out.println((PostagemAvancada) postagem1 + "\n");
                                }
                            } else if (opcao3 == 4) {
                                System.out.println("Digite o id do perfil");
                                idPerfil = teclado.nextInt();
                                for (Postagem postagem1 : parekHighlights.consultarPostagens(-1, "-1", "-1", idPerfil)) {
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
}

