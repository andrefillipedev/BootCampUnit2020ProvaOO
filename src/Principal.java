import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Andre
 *
 */
public class Principal {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa();
		p1.setNome("André");
		p1.setIdade(26);

		Pessoa p2 = new Pessoa();
		p2.setNome("Jorge");

		Livro l1 = new Livro();
		l1.setTitulo("Turma da Mônica");
		l1.setAutor("Maurício de Souza");
		l1.setTotalPaginas(25);
		l1.setPessoa(p1);

		Livro l2 = new Livro();
		l2.setTitulo("Dom Casmurro");
		l2.setAutor("Machado de Assis");
		l2.setTotalPaginas(300);
		l2.setPessoa(p1);

		Livro l3 = new Livro();
		l3.setTitulo("Java- Como Programar");
		l3.setAutor("Paul Deitel");
		l3.setTotalPaginas(968);
		l3.setPessoa(p2);

		Almanaque a1 = new Almanaque();
		a1.setTitulo("Super Almanaque Turma da Mônica");
		a1.setAutor("Turma da Mônica");
		a1.setTotalPaginas(1000);
		Pessoa p3 = new Pessoa();
		p3.setNome("Joaquim");
		a1.setPessoa(p3);

		Almanaque a2 = new Almanaque();
		a2.setTitulo("Almanaque SBT 35 Anos");
		a2.setAutor("Online Editora");
		a2.setTotalPaginas(2000);
		Pessoa p4 = new Pessoa();
		p4.setNome("Aline");
		a2.setPessoa(p4);

		ArrayList<Publicacao> publicacoes = new ArrayList<Publicacao>();
		publicacoes.add(0, l1);
		publicacoes.add(1, l2);
		publicacoes.add(2, l3);
		publicacoes.add(a1);
		publicacoes.add(a2);

		listarPublicacoes(publicacoes);
		l1.avancarPagina();
		l1.voltarPagina();
		l1.abrir();
		for (int i = 1; i <= 6; i++) {
			l1.avancarPagina();
		}
		System.out.println("Detalhes l1:" + l1.detalhes());
		l1.fechar();
		l2.abrir();
		System.out.println("Detalhes l2:" + l2.detalhes());
		l2.folhear(300);
		System.out.println("\nPágina atual l2," + l2.getTitulo() + ":" + l2.getPaginaAtual());
		l2.avancarPagina();
		l3.abrir();
		l3.folhear(5);
		System.out.println("\nPágina atual l3," + l3.getTitulo() + ":" + l3.getPaginaAtual());
		l3.avancarPagina();
		System.out.println("\nPágina atual l3," + l3.getTitulo() + ":" + l3.getPaginaAtual());
		l3.voltarPagina();
		System.out.println("\nPágina atual l3," + l3.getTitulo() + ":" + l3.getPaginaAtual());
		// abertos pela primeira vez
		a1.abrir();
		a1.avancarPagina();
		a1.avancarPagina();
		a1.folhear();
		System.out.println("\nPágina atual a1:" + a1.getTitulo() + ":" + a1.getPaginaAtual());

		a2.abrir();
		a2.avancarPagina();
		System.out.println("Página atual a2:" + a2.getTitulo() + ":" + a2.getPaginaAtual());
		a2.fechar();
		l1.abrir();
		l2.fechar();
		l1.abrir();
		publicacoes.set(0, l1);
		publicacoes.set(1, l2);
		publicacoes.set(2, l3);
		publicacoes.set(3, a1);
		publicacoes.set(4, a2);
		System.out.println();
		listarPublicacoes(publicacoes);
		System.out.println();
		p1.fazerAniversario();
	}

	private static void listarPublicacoes(ArrayList<Publicacao> publicacoes) {
		System.out.println("Publicações:\n");
		for (Publicacao publicacao : publicacoes) {
			if ((publicacao instanceof Livro) && !(publicacao instanceof Almanaque)) {
				Livro l = (Livro) publicacao;
				System.out.println(l.detalhes());
			} else if (publicacao instanceof Almanaque) {
				Almanaque a = (Almanaque) publicacao;
				System.out.println(a.getTitulo() + "," + a.getAutor() + "," + a.getTotalPaginas() + ","
						+ a.getPaginaAtual() + "," + a.isAberto() + "," + a.getPessoa().getNome());
			}
		}
	}
}
