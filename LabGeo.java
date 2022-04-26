import java.util.Scanner;

/* 
 * A presente classe tem por objetivo demonstrar algumas das atividades do laboratóriod e Geomensura da UNISINOS.
 * Neste laboratório é onde se da o armazenamento dos equipamentos de topografia. Esses equipamentos são utilizados
 * nas aulas de topografia. Para cada aula prática, cada turma obrigatoriamente vai precisar, pelo menos, de uma Estação 
 * Total, um tripe e um prisma. Nessa classe teremos algumas funções para emprestar os equipamentos, para devolver os
 * equipamentos, para registrar algum equipamento quebrado. Assim, sempre que um(a) professor(a) pedir um empréstimo de
 * material será "diminuído" uma unidade de cada um dos três equipamentos. E quando um equipamento estiver quebrado, uma
 * unidade do equipamento específico ficará indisponível.
 */

public class LabGeo {
	
	Scanner input = new Scanner(System.in);
	
	private int qdadeTrenasEBalizas;
	private int qdadeTeodolito;
	private int qdadeNivelOptico;
	private int qdadeEstacaoTotal;
	private int qdadeGPS;
	private int qdadeTripe;
	private int qdadePrisma;
	private int qdadeEmprestimo;
	
	public LabGeo() {
		
	}
	
	public LabGeo(int qdadeTrenasEBalizas, int qdadeTeodolito, int qdadeNivelOptico, int qdadeEstacaoTotal,
			 int qdadeGPS, int qdadeTripe, int qdadePrisma) {
		this.qdadeEstacaoTotal = qdadeEstacaoTotal;
		this.qdadeTeodolito = qdadeTeodolito;
		this.qdadeNivelOptico = qdadeNivelOptico;
		this.qdadeTrenasEBalizas = qdadeTrenasEBalizas;
		this.qdadeGPS = qdadeGPS;
		this.qdadeTripe = qdadeTripe;
		this.qdadePrisma = qdadePrisma;
	}


	public int getQdadeEstacaoTotal() {
		return qdadeEstacaoTotal;
	}

	public void setQdadeEstacaoTotal(int qdadeEstacaoTotal) {
		this.qdadeEstacaoTotal = qdadeEstacaoTotal;
	}

	public int getQdadeTeodolito() {
		return qdadeTeodolito;
	}

	public void setQdadeTeodolito(int qdadeTeodolito) {
		this.qdadeTeodolito = qdadeTeodolito;
	}

	public int getQdadeNivelOptico() {
		return qdadeNivelOptico;
	}

	public void setQdadeNivelOptico(int qdadeNivelOptico) {
		this.qdadeNivelOptico = qdadeNivelOptico;
	}

	public int getQdadeTrenasEBalizas() {
		return qdadeTrenasEBalizas;
	}

	public void setQdadeTrenasEBalizas(int qdadeTrenasEBalizas) {
		this.qdadeTrenasEBalizas = qdadeTrenasEBalizas;
	}

	public int getQdadeGPS() {
		return qdadeGPS;
	}

	public void setQdadeGPS(int qdadeGPS) {
		this.qdadeGPS = qdadeGPS;
	}

	public int getQdadeTripe() {
		return qdadeTripe;
	}

	public void setQdadeTripe(int qdadeTripe) {
		this.qdadeTripe = qdadeTripe;
	}

	public int getQdadePrisma() {
		return qdadePrisma;
	}

	public void setQdadePrisma(int qdadePrisma) {
		this.qdadePrisma = qdadePrisma;
	}

	// Função adicionada no módulo 5 para exercício de estrutura de seleção. Nesta função o programa toma uma decisão baseado na informação passada pelo usuário.
	/* 
	 * EXPLICANDO O CONTEXTO E O PROGRAMA: Aqui no laboratório em que trabalho temos vários equipamentos onde cada um deles é usada conforme a necessidade
	 *  do professor durante a aula. Aqui o usuário vai escolher um número para cada uma das atividades que se pode fazer com cada um dos equipamentos e o 
	 *  programa retornar qual o equipamento mais apropriado ele deve tomar por empréstimo. 
	 */
	int opcao;
	String nomeEquipamento = "";
	public void escolherEquipamento() {
		String mensagemDeRetorno = "";
		
		
		System.out.print("Qual atividade você vai realizar? ");
		System.out.println();
		System.out.println("1 - MEDIÇÃO DE COTAS (ALTURA)");
		System.out.println("2 - MEDIÇÃO SOMENTE DE ÂNGULOS");
		System.out.println("3 - MEDIÇÃO SOMENTE DE DISTÂNCIAS");
		System.out.println("4 - MEDIÇÃO DE DISTÂNCIAS E ÂNGULOS");
		System.out.println("5 - MEDIÇÃO DE COORDENADAS");
		
		do {
			opcao = input.nextInt();
			
			switch(opcao) {
				case 1:
					mensagemDeRetorno = "Para esta atividade você precisa usar o equipamento: NÍVEL OPTICO";
					nomeEquipamento = "NÍVEL ÓPTICO";
					break;
				case 2: 
					mensagemDeRetorno = "Para esta atividade você precisa usar o equipamento: TEODOLITO";
					nomeEquipamento = "TEODOLITO";
					break;
				case 3:
					mensagemDeRetorno = "Para esta atividade você precisa usar o equipamento: TRENAS E BALIZAS";
					nomeEquipamento = "TRENA E BELIZAS";
					break;
				case 4:
					mensagemDeRetorno = "Para esta atividade você precisa usar o equipamento: ESTAÇÃO TOTAL";
					nomeEquipamento = "ESTAÇÃO TOTAL";
					break;
				case 5:
					mensagemDeRetorno = "Para esta atividade você precisa usar o equipamento: RECEPTOR GNSS";
					nomeEquipamento = "RECEPTOR GNSS";
					break;
				default:
					mensagemDeRetorno = "Opcao invalida";
			}
			if(opcao < 1 || opcao > 5) {
				System.out.println("Opção inválida. Tente novamente escolhendo uma das opções anteriores!");
			}
		} while ((opcao < 1) || (opcao > 5));
		System.out.println(mensagemDeRetorno);
	}

	// Função para calcular a quantidade de empréstimos e quantidade de equipamentos disponíveis.
	public void emprestimoEquipamento(int qdadeEmprestimo) {
		
		escolherEquipamento();
		
		if(opcao == 1) {
			if (qdadeNivelOptico > 0) {
				this.qdadeNivelOptico -= qdadeEmprestimo;
				this.qdadeEmprestimo += 1;
				this.qdadeTripe -= qdadeEmprestimo;
				this.qdadePrisma -= qdadeEmprestimo;
			}
		} else if(opcao == 2) {
			if (qdadeTeodolito > 0) {
				this.qdadeTeodolito -= qdadeEmprestimo;
				this.qdadeEmprestimo += 1;
				this.qdadeTripe -= qdadeEmprestimo;
				this.qdadePrisma -= qdadeEmprestimo;
			}
		} else if(opcao == 3) {
			if (qdadeTrenasEBalizas > 0) {
				this.qdadeTrenasEBalizas -= qdadeEmprestimo;
				this.qdadeEmprestimo += 1;
				this.qdadeTripe -= qdadeEmprestimo;
				this.qdadePrisma -= qdadeEmprestimo;
			}
		} else if(opcao == 4) {
			if (qdadeEstacaoTotal > 0) {
				this.qdadeEstacaoTotal -= qdadeEmprestimo;
				this.qdadeEmprestimo += 1;
				this.qdadeTripe -= qdadeEmprestimo;
				this.qdadePrisma -= qdadeEmprestimo;
			}
		}  else if(opcao == 5) {
			if (qdadeGPS > 0) {
				this.qdadeGPS -= qdadeEmprestimo;
				this.qdadeEmprestimo += 1;
				this.qdadeTripe -= qdadeEmprestimo;
				this.qdadePrisma -= qdadeEmprestimo;
			}
		}		
	}
	
	// Função para imprimir um pequeno relatório.
	public void impressaoEquipamentosDisponiveis() {
		if (getQdadeEstacaoTotal() > 0) {
			System.out.printf("Após %d empréstimo(s) tem-se disponível no laboratório: \n", qdadeEmprestimo);
			if (opcao == 1) {
				System.out.print(getQdadeNivelOptico());
			} else if (opcao == 2 ) {
				System.out.print(getQdadeTeodolito());
			} else if (opcao == 3) {
				System.out.print(getQdadeTrenasEBalizas());
			} else if (opcao == 4) {
				System.out.print(getQdadeEstacaoTotal());
			} else {
				System.out.print(getQdadeGPS());
			}
			System.out.printf(" %s, \n%d Tripes, \n%d Prismas.\n", nomeEquipamento, getQdadeTripe(), getQdadePrisma());
		} else {
			System.out.println("Não há mais equipamentos disponíveis para empréstimo.");
		}		
	}
	
}
