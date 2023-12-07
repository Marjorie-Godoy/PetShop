package DAO;

import DTO.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDAO {
    
    Connection conn;
    PreparedStatement pstm;

    
    public void cadastrarCliente(Pessoa objpessoa){
        
        String sql = "insert into Cliente (Nome, CPF, Telefone, Endereco) values (?, ?, ?, ?)";
        
        conn = new conexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objpessoa.getNome());
            pstm.setString(2, objpessoa.getCpf());
            pstm.setString(3, objpessoa.getTelefone());
            pstm.setString(4, objpessoa.getEndereco());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "ClienteDAO" + erro);
        }
    }
}
