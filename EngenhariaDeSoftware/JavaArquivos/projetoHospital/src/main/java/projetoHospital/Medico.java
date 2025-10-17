package projetoHospital;

public class Medico {

 private int id;
 private String nome;
 private String especialidade;
 private String crm;

 /**
  * Construtor para criar um novo médico ANTES de salvá-lo no banco.
  */
 public Medico(String nome, String especialidade, String crm) {
     this.nome = nome;
     this.especialidade = especialidade;
     this.crm = crm;
 }

 /**
  * Construtor para criar um objeto médico a partir de dados
  * que JÁ VIERAM do banco de dados (por isso inclui o id).
  */
 public Medico(int id, String nome, String especialidade, String crm) {
     this.id = id;
     this.nome = nome;
     this.especialidade = especialidade;
     this.crm = crm;
 }

 // Getters e Setters
 public int getId() { return id; }
 public void setId(int id) { this.id = id; }
 public String getNome() { return nome; }
 public void setNome(String nome) { this.nome = nome; }
 public String getEspecialidade() { return especialidade; }
 public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
 public String getCrm() { return crm; }
 public void setCrm(String crm) { this.crm = crm; }

 @Override
 public String toString() {
     return "Medico [id=" + id + ", nome=" + nome + ", especialidade=" + especialidade + ", crm=" + crm + "]";
 }
}