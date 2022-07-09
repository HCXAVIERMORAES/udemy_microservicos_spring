package br.com.erudio;

public class Greeting {

	private final long id;
	private final String content;
	
	//criando um construtor para os atributos acima
	public Greeting(long id, String content) {
		//super();  criado e removido, pois não é preciso
		this.id = id;
		this.content = content;
	}
	
	//gerar os gets e sets, porem por ser final, so é permitido os gets
	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
	
	
	
}
