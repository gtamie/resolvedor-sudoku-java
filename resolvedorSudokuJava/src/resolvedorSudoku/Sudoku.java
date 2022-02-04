package resolvedorSudoku;

import java.util.Scanner;

public class Sudoku implements ResolvedorSudokuInterface {

	// tamanhoGrade = tamanho de uma linha ou coluna
	private static final int tamanhoGrade = 9;
	private int[][] tabelaInserida;
	
	//getter
	public int[][] getTabelaInserida() {
		return tabelaInserida;
	}

	@Override
	public int[][] inserirTabela() {
		Scanner scan = new Scanner(System.in);
		int[][] tabela = new int[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.println("Digite o elemento da linha " + (i + 1) + " e coluna " + (j + 1)
						+ " (se for um quadrado em branco, digite 0): ");
				tabela[i][j] = scan.nextInt();
				tabelaInserida = tabela;
			}
		}
		scan.close();

		return this.tabelaInserida;
	}

	@Override
	public void printTabela(int[][] tabela) {
		for (int linha = 0; linha < tamanhoGrade; linha++) {
			if (linha % 3 == 0 && linha != 0) {
				System.out.println("-----------");
			}
			for (int coluna = 0; coluna < tamanhoGrade; coluna++) {
				if (coluna % 3 == 0 && coluna != 0) {
					System.out.print("|");
				}
				System.out.print(tabela[linha][coluna]);
			}
			System.out.println();
		}
	}

	/*
	 * Verifica na linha se há um número com o mesmo valor da variável numero. A
	 * variável numero receberá o valor da variável numberToTry, de 1 a 9.
	 */
	@Override
	public boolean isNumberInLinha(int[][] tabela, int numero, int linha) {

		for (int i = 0; i < tamanhoGrade; i++) {
			if (tabela[linha][i] == numero) {

				return true;
			}
		}
		return false;
	}

	// Verifica na coluna se há um número com o mesmo valor da variável numero.
	@Override
	public boolean isNumberInColuna(int[][] tabela, int numero, int coluna) {

		for (int i = 0; i < tamanhoGrade; i++) {
			if (tabela[i][coluna] == numero) {

				return true;
			}
		}
		return false;
	}

	// Verifica no box 3x3 se há um número com o mesmo valor da variável numero.
	@Override
	public boolean isNumberInBox(int[][] tabela, int numero, int linha, int coluna) {
		int localBoxLinha = linha - linha % 3;
		int localBoxColuna = coluna - coluna % 3;

		for (int i = localBoxLinha; i < localBoxLinha + 3; i++) {
			for (int j = localBoxColuna; j < localBoxColuna + 3; j++) {
				if (tabela[i][j] == numero) {
					return true;
				}
			}
		}
		return false;
	}

	// verifica se numero é válido na linha, coluna e box
	@Override
	public boolean isValidPlacement(int[][] tabela, int numero, int linha, int coluna) {
		return !isNumberInLinha(tabela, numero, linha) && !isNumberInColuna(tabela, numero, coluna)
				&& !isNumberInBox(tabela, numero, linha, coluna);

	}

	// Completa os valores corretos na tabela
	@Override
	public boolean solveTabela(int[][] tabela) {
		for (int linha = 0; linha < tamanhoGrade; linha++) {
			for (int coluna = 0; coluna < tamanhoGrade; coluna++) {
				if (tabela[linha][coluna] == 0) {
					for (int numberToTry = 1; numberToTry <= tamanhoGrade; numberToTry++) {
						if (isValidPlacement(tabela, numberToTry, linha, coluna)) {
							tabela[linha][coluna] = numberToTry;

							if (solveTabela(tabela)) {
								return true;
							} else {
								tabela[linha][coluna] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

}
