package resolvedorSudoku;

public class ResolvedorSudoku {
	
	public static void main(String[] args) {
		
		Sudoku sudoku = new Sudoku();
		
		System.out.println("Preencha os valores originais do Sudoku que você deseja resolver:");
		
		sudoku.inserirTabela();
		
		System.out.println("Jogo inserido: ");
						
		sudoku.printTabela(sudoku.getTabelaInserida());

		if (sudoku.solveTabela(sudoku.getTabelaInserida())) {
			System.out.println("\nResolvido!!!");
		} 
		else {
			System.out.println("\n Não foi possível resolver.");
		}
		sudoku.printTabela(sudoku.getTabelaInserida());

	}

	
}
