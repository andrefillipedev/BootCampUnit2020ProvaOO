/**
 * 
 */

/**
 * @author Andre
 *
 */
public class Almanaque extends Livro {

	//Só é possível folhear esse tipo de publicação pelo índice, localizado na página 2
	public void folhear() {
		System.out.println("Folheando " +getTitulo());
		setPaginaAtual(2);
	}

	@Override
	public void avancarPagina() {
		// Para ler um livro, navegando nas páginas, ele deve estar aberto;
		/*
		 * Só se pode navegar por páginas válidas, respeitando os limites inicial e
		 * final do livro;
		 * 
		 * As páginas são avançadas de 2 em 2, por ser dividido em folhas duplas;
		 */
		
		int paginaAtual = getPaginaAtual();
		int proximaPagina = paginaAtual + 2;

		if (isAberto() && (paginaAtual >= 0 && proximaPagina <= getTotalPaginas())) {
			setPaginaAtual(paginaAtual+2);
			System.out.println("\n"+getTitulo()+":avançando página");
		}
		else {
			System.out.println("\nMétodo avancarPagina,"+getTitulo()+":livro fechado ou só se pode navegar por páginas válidas, respeitando os limites inicial e final do livro");
		}
		
	}
}
