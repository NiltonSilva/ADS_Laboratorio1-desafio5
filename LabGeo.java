import java.util.Scanner;

/* 
 * A presente classe tem por objetivo demonstrar algumas das atividades do laborat�riod e Geomensura da UNISINOS.
 * Neste laborat�rio � onde se da o armazenamento dos equipamentos de topografia. Esses equipamentos s�o utilizados
 * nas aulas de topografia. Para cada aula pr�tica, cada turma obrigatoriamente vai precisar, pelo menos, de uma Esta��o 
 * Total, um tripe e um prisma. Nessa classe teremos algumas fun��es para emprestar os equipamentos, para devolver os
 * equipamentos, para registrar algum equipamento quebrado. Assim, sempre que um(a) professor(a) pedir um empr�stimo de
 * material ser� "diminu�do" uma unidade de cada um dos tr�s equipamentos. E quando um equipamento estiver quebrado, uma
 * unidade do equipamento espec�fico ficar� indispon�vel.
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

	// Fun��o adicionada no m�dulo 5 para exerc�cio de estrutura de sele��o. Nesta fun��o o programa toma uma decis�o baseado na informa��o passada pelo usu�rio.
	/* 
	 * EXPLICANDO O CONTEXTO E O PROGRAMA: Aqui no laborat�rio em que trabalho temos v�rios equipamentos onde cada um deles � usada conforme a necessidade
	 *  do professor durante a aula. Aqui o usu�rio vai escolher um n�mero para cada uma das atividades que se pode fazer com cada um dos equipamentos e o 
	 *  programa retornar qual o equipamento mais apropriado ele deve tomar por empr�stimo. 
	 */
	int opcao;
	String nomeEquipamento = "";
	public void escolherEquipamento() {
		String mensagemDeRetorno = "";
		
		
		System.out.print("Qual atividade voc� vai realizar? ");
		System.out.println();
		System.out.println("1 - MEDI��O DE COTAS (ALTURA)");
		System.out.println("2 - MEDI��O SOMENTE DE �NGULOS");
		System.out.println("3 - MEDI��O SOMENTE DE DIST�NCIAS");
		System.out.println("4 - MEDI��O DE DIST�NCIAS E �NGULOS");
		System.out.println("5 - MEDI��O DE COORDENADAS");
		
		do {
			opcao = input.nextInt();
			
			switch(opcao) {
				case 1:
					mensagemDeRetorno = "Para esta atividade voc� precisa usar o equipamento: N�VEL OPTICO";
					nomeEquipamento = "N�VEL �PTICO";
					break;
				case 2: 
					mensagemDeRetorno = "Para esta atividade voc� precisa usar o equipamento: TEODOLITO";
					nomeEquipamento = "TEODOLITO";
					break;
				case 3:
					mensagemDeRetorno = "Para esta atividade voc� precisa usar o equipamento: TRENAS E BALIZAS";
					nomeEquipamento = "TRENA E BELIZAS";
					break;
				case 4:
					mensagemDeRetorno = "Para esta atividade voc� precisa usar o equipamento: ESTA��O TOTAL";
					nomeEquipamento = "ESTA��O TOTAL";
					break;
				case 5:
					mensagemDeRetorno = "Para esta atividade voc� precisa usar o equipamento: RECEPTOR GNSS";
					nomeEquipamento = "RECEPTOR GNSS";
					break;
				default:
					mensagemDeRetorno = "Opcao invalida";
			}
			if(opcao < 1 || opcao > 5) {
				System.out.println("Op��o inv�lida. Tente novamente escolhendo uma das op��es anteriores!");
			}
		} while ((opcao < 1) || (opcao > 5));
		System.out.println(mensagemDeRetorno);
	}

	// Fun��o para calcular a quantidade de empr�stimos e quantidade de equipamentos dispon�veis.
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
	
	// Fun��o para imprimir um pequeno relat�rio.
	public void impressaoEquipamentosDisponiveis() {
		if (getQdadeEstacaoTotal() > 0) {
			System.out.printf("Ap�s %d empr�stimo(s) tem-se dispon�vel no laborat�rio: \n", qdadeEmprestimo);
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
			System.out.println("N�o h� mais equipamentos dispon�veis para empr�stimo.");
		}		
	}
	
}
