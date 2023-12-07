
package DAO;
import DTO.Agendamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class AgendamentoDAO {
    Connection conn;
    PreparedStatement pstm;
    
    public void AgendarAtendimento(Agendamento objagendamento){
        //Entendo que essa classe não faz muito sentido, pois não esta coerente com a tabela do banco de dados, mas não tive tempo de modifidar a tabela para que os valores não sejao id
        //
        //por isso é só uma simulação de como ficaria 
        
        String sql = "insert into Atendimento (Hora_chegada, Hora_retirada, Trabalhador_id, pet_id, servico_id) values (?, ?, ?, ?, ?)";
        
        conn = new conexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objagendamento.getDataHora_chegada());
            pstm.setString(2, objagendamento.getDataHora_retirada());
            pstm.setString(3, objagendamento.getTrabalhador());
            pstm.setString(4, objagendamento.getPet());
            pstm.setString(4, objagendamento.getServico());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "AgendamentoDAO" + erro);
        }
    }
}
