package projetoHospital;

import java.util.List;

public class Hospital {

 private String nome;
 private String endereco;
 private final HospitalDb db;

 public Hospital(String nome, String endereco) {
     this.nome = nome;
     this.endereco = endereco;
     this.db = new HospitalDb();
 }

 public void adicionarMedico(Medico medico) {
     this.db.adicionarMedico(medico);
 }

 public void adicionarPaciente(Paciente paciente) {
     this.db.adicionarPaciente(paciente);
 }

 public List<Medico> getMedicos() {
     return this.db.listarMedicos();
 }

 public List<Paciente> getPacientes() {
     return this.db.listarPacientes();
 }

 // Getters e Setters
 public String getNome() { return nome; }
 public void setNome(String nome) { this.nome = nome; }
 public String getEndereco() { return endereco; }
 public void setEndereco(String endereco) { this.endereco = endereco; }
}