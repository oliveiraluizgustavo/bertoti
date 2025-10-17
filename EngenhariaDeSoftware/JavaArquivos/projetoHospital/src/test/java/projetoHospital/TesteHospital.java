package projetoHospital;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteHospital {

    @BeforeEach
    void setUp() {
        File dbFile = new File("hospital.db");
        if (dbFile.exists()) {
            dbFile.delete();
        }
    }

    @Test
    void testAdicionarEListarEntidades() {
        // --- ARRANGE (Organizar) ---
        // Nesta seção, adiciono quantos médicos e pacientes quiser!
        Hospital hospital = new Hospital("Hospital Central", "Rua Principal, 123");

        // Crio objetos para os médicos e pacientes que vamos verificar depois
        Medico medico1 = new Medico("Dra. Ana Zaira", "Pediatria", "CRM-SP 98765");
        Medico medico2 = new Medico("Dr. Ricardo Lima", "Ortopedia", "CRM-RJ 54321");
        Medico medico3 = new Medico("Dr. Fernando", "Psiquiatria", "CRM-mg 55321");
        
        Paciente paciente1 = new Paciente("João da Silva", 42, "Gripe Forte");
        Paciente paciente2 = new Paciente("Maria Oliveira", 25, "Tornozelo quebrado");

        // Você pode adicionar mais aqui para experimentar.
        hospital.adicionarMedico(medico1);
        hospital.adicionarMedico(medico2);
        hospital.adicionarMedico(medico3);
        hospital.adicionarPaciente(paciente1);
        hospital.adicionarPaciente(paciente2);
        hospital.adicionarPaciente(new Paciente("Carlos Souza", 55, "Check-up geral"));


        // --- ACT (Agir) ---
        // Busco as listas do banco de dados
        List<Medico> medicosDoBanco = hospital.getMedicos();
        List<Paciente> pacientesDoBanco = hospital.getPacientes();


        // --- ASSERT (Verificar) ---
        // Verificações flexíveis. Elas não se importam com o tamanho total da lista.

        // A lista de médicos não pode estar vazia
        assertFalse(medicosDoBanco.isEmpty());
        // A lista de pacientes não pode estar vazia
        assertFalse(pacientesDoBanco.isEmpty());

        // A Dra. Ana Zaira (medico1) está na lista?
        // Usamos o CRM, que é um identificador único.
        assertTrue(medicosDoBanco.stream().anyMatch(m -> m.getCrm().equals(medico1.getCrm())), 
                   "Não foi possível encontrar a Dra. Ana Zaira na lista.");

        // O Dr. Ricardo Lima (medico2) está na lista?
        assertTrue(medicosDoBanco.stream().anyMatch(m -> m.getCrm().equals(medico2.getCrm())),
                   "Não foi possível encontrar o Dr. Ricardo Lima na lista.");

        // O João da Silva (paciente1) está na lista?
        // Usamos o nome para verificar.
        assertTrue(pacientesDoBanco.stream().anyMatch(p -> p.getNome().equals(paciente1.getNome())),
                   "Não foi possível encontrar o João da Silva na lista.");
                   
        // A Maria Oliveira (paciente2) está na lista?
        assertTrue(pacientesDoBanco.stream().anyMatch(p -> p.getNome().equals(paciente2.getNome())),
                   "Não foi possível encontrar a Maria Oliveira na lista.");

        System.out.println("Teste flexível passou com sucesso!");
        System.out.println("\n--- MÉDICOS ENCONTRADOS NO BANCO ---");
        medicosDoBanco.forEach(System.out::println);
        System.out.println("\n--- PACIENTES ENCONTRADOS NO BANCO ---");
        pacientesDoBanco.forEach(System.out::println);
    }
}