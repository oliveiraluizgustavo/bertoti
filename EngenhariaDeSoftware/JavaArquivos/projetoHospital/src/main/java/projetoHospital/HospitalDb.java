package projetoHospital;

                                                                                                                                                                                                import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalDb {

 private static final String URL = "jdbc:sqlite:hospital.db";

 public HospitalDb() {
     try (Connection conn = DriverManager.getConnection(URL); Statement stmt = conn.createStatement()) {
         String sqlMedicos = "CREATE TABLE IF NOT EXISTS medicos ("
                 + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                 + "nome TEXT NOT NULL,"
                 + "especialidade TEXT NOT NULL,"
                 + "crm TEXT NOT NULL UNIQUE);";
         stmt.execute(sqlMedicos);

         String sqlPacientes = "CREATE TABLE IF NOT EXISTS pacientes ("
                 + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                 + "nome TEXT NOT NULL,"
                 + "idade INTEGER NOT NULL,"
                 + "diagnostico TEXT);";
         stmt.execute(sqlPacientes);
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

 public void adicionarMedico(Medico medico) {
     String sql = "INSERT INTO medicos(nome, especialidade, crm) VALUES(?, ?, ?)";
     try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {
         pstmt.setString(1, medico.getNome());
         pstmt.setString(2, medico.getEspecialidade());
         pstmt.setString(3, medico.getCrm());
         pstmt.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

 public void adicionarPaciente(Paciente paciente) {
     String sql = "INSERT INTO pacientes(nome, idade, diagnostico) VALUES(?, ?, ?)";
     try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {
         pstmt.setString(1, paciente.getNome());
         pstmt.setInt(2, paciente.getIdade());
         pstmt.setString(3, paciente.getDiagnostico());
         pstmt.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

 public List<Medico> listarMedicos() {
     String sql = "SELECT * FROM medicos";
     List<Medico> medicos = new ArrayList<>();
     try (Connection conn = DriverManager.getConnection(URL); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
         while (rs.next()) {
             medicos.add(new Medico(rs.getInt("id"), rs.getString("nome"), rs.getString("especialidade"), rs.getString("crm")));
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return medicos;
 }

 public List<Paciente> listarPacientes() {
     String sql = "SELECT * FROM pacientes";
     List<Paciente> pacientes = new ArrayList<>();
     try (Connection conn = DriverManager.getConnection(URL); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
         while (rs.next()) {
             pacientes.add(new Paciente(rs.getInt("id"), rs.getString("nome"), rs.getInt("idade"), rs.getString("diagnostico")));
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return pacientes;
 }
}