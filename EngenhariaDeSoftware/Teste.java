package aula;

public class Teste {

import org.junit.jupiter.api.Test;

class Teste {
	
	
	
	@Test
	void test() {
		
		SalaAula engenharia = new SalaAula();
		engenharia.adicionarAluno(new Aluno)("Joao", "12345"));
  		engenharia.adicionarAluno(new Aluno)("Maria", "54321"));
		asserEquals(engenharia.getAlunos().size(), 2);
		
		List<Aluno> busca = engenharia.buscarAlunoNome("Joao");
		assertEquals(busca.get(0).getRa(), "12345");
		
		Aluno aluno = engenharia.buscarAlunoRA("54321");
		assertEquals(aluno.getNome(), "Maria");
		
	}
	
	
	
}
}
