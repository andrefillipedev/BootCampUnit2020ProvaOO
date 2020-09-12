import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Andre
 *
 */
public class Pessoa {

	private String nome;
	private int idade;
	private String sexo;
	private ArrayList<Livro> livros;

	public Pessoa() {
		this.livros = new ArrayList<Livro>();	
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}

	public void fazerAniversario() {
		System.out.print(getNome() +" tinha " +getIdade() + " anos e fez aniversário.");
		this.idade++;
		System.out.println("Idade atual: "+getIdade());
	}
}