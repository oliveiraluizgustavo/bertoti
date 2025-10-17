package projetoHospital;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        // 1. Inicia a conexão com o banco (e cria as tabelas se não existirem)
        HospitalDb db = new HospitalDb();

        System.out.println("--- Adicionando Novos Dados ---");

        // 2. Criar e adicionar um novo Médico
        //    (usando o construtor SEM id)
        Medico novoMedico = new Medico("Dra. Ana Costa", "Cardiologia", "CRM-SP 12345");
        db.adicionarMedico(novoMedico);
        System.out.println("Médico(a) adicionado(a): " + novoMedico.getNome());
        
        // 3. Criar e adicionar um novo Paciente
        //    (usando o construtor SEM id)
        Paciente novoPaciente = new Paciente("João Silva", 45, "Hipertensão");
        db.adicionarPaciente(novoPaciente);
        System.out.println("Paciente adicionado: " + novoPaciente.getNome());

        System.out.println("\n======================================\n");
        System.out.println("--- Listando Dados do Banco ---");

        // 4. Listar todos os Médicos do banco
        List<Medico> listaDeMedicos = db.listarMedicos();
        System.out.println(">>> MÉDICOS CADASTRADOS:");
        for (Medico m : listaDeMedicos) {
            // Imprime usando o método toString() que criamos
            System.out.println(m); 
        }

        System.out.println("---------------------------------");

        // 5. Listar todos os Pacientes do banco
        List<Paciente> listaDePacientes = db.listarPacientes();
        System.out.println(">>> PACIENTES CADASTRADOS:");
        for (Paciente p : listaDePacientes) {
            // Imprime usando o método toString() que criamos
            System.out.println(p);
        }
    }
}
