package resolvedorSudoku;

public interface ResolvedorSudokuInterface {
	
	public abstract int[][] inserirTabela();
	
	public abstract void printTabela(int[][] tabela);
	
	public abstract boolean isNumberInLinha(int[][] tabela, int numero, int linha);
	
	public abstract boolean isNumberInColuna(int[][] tabela, int numero, int coluna);
	
	public abstract boolean isNumberInBox(int[][] tabela, int numero, int linha, int coluna);
	
	public boolean isValidPlacement(int[][] tabela, int numero, int linha, int coluna);
	
	public abstract boolean solveTabela(int[][] tabela);

}
