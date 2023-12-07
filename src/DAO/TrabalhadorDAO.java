
package DAO;
import DTO.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TrabalhadorDAO {
    Connection conn;
    PreparedStatement pstm;

    
    public void cadastrarTrabalhador(Pessoa objtrabalhadordao){
        
        String sql = "insert into Trabalhador (Nome, CPF, Endereco, Telefone) values (?, ?, ?, ?)";
        
        conn = new conexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objtrabalhadordao.getNome());
            pstm.setString(2, objtrabalhadordao.getCpf());
            pstm.setString(3, objtrabalhadordao.getEndereco());
            pstm.setString(4, objtrabalhadordao.getTelefone());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "TrabalhadorDAO" + erro);
        }
    }
}
