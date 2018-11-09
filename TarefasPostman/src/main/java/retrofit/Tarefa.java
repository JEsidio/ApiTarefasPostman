package retrofit;

public class Tarefa {

	private int id;
	private String description;
	private Boolean done;
	
	@Override
	public String toString() {
		return "Tarefa: " + id + "\n" +
				"Descrição: " + description + "\n" +
				"Estado: " + done + "\n\n";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return description;
	}
	public void setDescricao(String descricao) {
		this.description = descricao;
	}
	public Boolean getEstado() {
		return done;
	}
	public void setEstado(Boolean estado) {
		this.done = estado;
	}

}
