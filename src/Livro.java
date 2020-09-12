import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Andre
 *
 */
public class Livro implements Publicacao {

	private String titulo;
	private String autor;
	private int totalPaginas;
	private int paginaAtual = 0;
	private boolean aberto = false;
	private Pessoa pessoa;

	public Livro(String titulo, String autor, int totalPaginas, Pessoa pessoa) {
		this.titulo = titulo;
		this.autor = autor;
		this.totalPaginas = totalPaginas;
		this.pessoa = pessoa;
		//this.paginaAtual = 0;
		//this.aberto = false;
	}

	public Livro() {
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public void setTotalPaginas(int totalPaginas) {
		this.totalPaginas = totalPaginas;
	}

	public int getPaginaAtual() {
		return paginaAtual;
	}

	public void setPaginaAtual(int paginaAtual) {
		this.paginaAtual = paginaAtual;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
		this.pessoa.getLivros().add(this);
	}

	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	public String detalhes() {
		return this.getTitulo() + "," + this.getAutor() + "," + this.getTotalPaginas() + "," + this.getPaginaAtual()
				+ "," + this.isAberto() + "," + this.getPessoa().getNome();
	}

	@Override
	public void abrir() {
		Pessoa pessoa = getPessoa();
		//Cada livro s� pode ser lido por uma Pessoa por vez.
		if (pessoa != null) {
			ArrayList<Livro> livros = pessoa.getLivros();
			for (Livro livro : livros) {
				if (livro.isAberto()) {
					System.out.print(pessoa.getNome() + " tem " + livros.size() + " livros em seu nome por�m � ");
					System.out.println("imposs�vel abrir " +this.getTitulo() + ".Uma pessoa s� pode ler um livro por vez e "+pessoa.getNome() + " est� lendo "+livro.getTitulo());
					// Uma Pessoa s� pode ler um livro por vez (aberto).
					return;
				}
			}
			setAberto(true);
			System.out.println("\n"+getTitulo() +":livro aberto,por " +getPessoa().getNome());
			avancarPagina();
		}
		else {
			System.out.println("Imposs�vel abrir livro sem pessoa associada");
		}
	}

	@Override
	public void fechar() {
		if (isAberto()) {
			setAberto(false);
			/*Fechar um livro apenas habilita a possibilidade da mesma Pessoa poder abrir
			outro livro*/
			ArrayList<Livro> livros = pessoa.getLivros();
			for (Livro livro : livros) {
				if (livro.isAberto()&& livro.getTitulo().equals(this.getTitulo())) {
					livro.setAberto(false);
				}
			}
			System.out.println(getTitulo()+" fechado por " +getPessoa().getNome());
		} else {
			System.out.println("Livro j� fechado.Imposs�vel fechar novamente");
		}
	}

	@Override
	public void folhear(int pagina) {
		System.out.println("Folheando :"+getTitulo());
		setPaginaAtual(pagina);
		//setPaginaAtual(getPaginaAtual() + pagina);
	}

	@Override
	public void avancarPagina() {
		// Para ler um livro, navegando nas p�ginas, ele deve estar aberto;
		/*
		 * S� se pode navegar por p�ginas v�lidas, respeitando os limites inicial e
		 * final do livro;
		 */
		int paginaAtual = getPaginaAtual();
		int proximaPagina = paginaAtual +1;
		if (isAberto() && (paginaAtual >= 0 && proximaPagina <= getTotalPaginas())) {
			setPaginaAtual(proximaPagina);
			System.out.println("\n"+getTitulo()+":avan�ando p�gina");
		}
		else {
			System.out.println("\nM�todo avancarPagina,"+getTitulo()+":livro fechado ou s� se pode navegar por p�ginas v�lidas, respeitando os limites inicial e final do livro");
		}
	}

	@Override
	public void voltarPagina() {
		// Para ler um livro, navegando nas p�ginas, ele deve estar aberto;
		/*
		 * S� se pode navegar por p�ginas v�lidas, respeitando os limites inicial e
		 * final do livro;
		 */
		int paginaAtual = getPaginaAtual();
		if (isAberto() && (paginaAtual >= 0 && paginaAtual <= getTotalPaginas())) {
			setPaginaAtual(--paginaAtual);
			System.out.println(getTitulo()+":voltando p�gina");
		}
		else {
			System.out.println("M�todo voltarPagina,"+getTitulo()+":Livro fechado ou s� se pode navegar por p�ginas v�lidas, respeitando os limites inicial e final do livro");
		}
	}
}
