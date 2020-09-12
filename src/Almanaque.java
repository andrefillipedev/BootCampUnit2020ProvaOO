/**
 * 
 */

/**
 * @author Andre
 *
 */
public class Almanaque extends Livro {

	//S� � poss�vel folhear esse tipo de publica��o pelo �ndice, localizado na p�gina 2
	public void folhear() {
		System.out.println("Folheando " +getTitulo());
		setPaginaAtual(2);
	}

	@Override
	public void avancarPagina() {
		// Para ler um livro, navegando nas p�ginas, ele deve estar aberto;
		/*
		 * S� se pode navegar por p�ginas v�lidas, respeitando os limites inicial e
		 * final do livro;
		 * 
		 * As p�ginas s�o avan�adas de 2 em 2, por ser dividido em folhas duplas;
		 */
		
		int paginaAtual = getPaginaAtual();
		int proximaPagina = paginaAtual + 2;

		if (isAberto() && (paginaAtual >= 0 && proximaPagina <= getTotalPaginas())) {
			setPaginaAtual(paginaAtual+2);
			System.out.println("\n"+getTitulo()+":avan�ando p�gina");
		}
		else {
			System.out.println("\nM�todo avancarPagina,"+getTitulo()+":livro fechado ou s� se pode navegar por p�ginas v�lidas, respeitando os limites inicial e final do livro");
		}
		
	}
}
