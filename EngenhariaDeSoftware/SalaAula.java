

import java.util.List;
import java.util.LinkedList;

public class SalaAula {
	
	private List<Aluno> alunos = new LinkedList<Aluno>();
	
	public void adicionarAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	public List<Aluno> buscarAlunosNome(String nome) {
		List<Aluno> encontrados = new LinkedList<Aluno> ();
		for(Aluno aluno:alunos) {
			if(aluno.getnome().equals(nome))
				encontrados.add(aluno);
		}
		return encontrados;
	}
	
	public Aluno buscarAlunoRA(String ra) {
		for(Aluno aluno:alunos) {
			if(aluno.getRa().equals(ra)) return aluno;
		}
		return null;
	}
}
