package projetoHospital;

public class Paciente {

 private int id;
 private String nome;
 private int idade;
 private String diagnostico;

 /**
  * Construtor para criar um novo paciente ANTES de salvá-lo no banco.
  */
 public Paciente(String nome, int idade, String diagnostico) {
     this.nome = nome;
     this.idade = idade;
     this.diagnostico = diagnostico;
 }

 /**
  * Construtor para criar um objeto paciente a partir de dados
  * que JÁ VIERAM do banco de dados.
  */
 public Paciente(int id, String nome, int idade, String diagnostico) {
     this.id = id;
     this.nome = nome;
     this.idade = idade;
     this.diagnostico = diagnostico;
 }

 // Getters e Setters
 public int getId() { return id; }
 public void setId(int id) { this.id = id; }
 public String getNome() { return nome; }
 public void setNome(String nome) { this.nome = nome; }
 public int getIdade() { return idade; }
 public void setIdade(int idade) { this.idade = idade; }
 public String getDiagnostico() { return diagnostico; }
 public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

 @Override
 public String toString() {
     return "Paciente [id=" + id + ", nome=" + nome + ", idade=" + idade + ", diagnostico=" + diagnostico + "]";
 }
}
