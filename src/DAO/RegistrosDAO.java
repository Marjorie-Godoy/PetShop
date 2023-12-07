
package DAO;

import DTO.Agendamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class RegistrosDAO {
    
     Connection conn;
     PreparedStatement pstm;
     ResultSet rs;
     ArrayList<Agendamento> lista = new ArrayList<>();
     
     public ArrayList<Agendamento> PesquisarRegistros(){
         
         String sql = "SELECT * FROM pesquisa_atendimento";
         conn = new conexaoDAO().conectaBD();
         
         try {
             pstm = conn.prepareStatement(sql);
             rs = pstm.executeQuery();
             
             while(rs.next()){
                 Agendamento objagendamento = new Agendamento();
                 objagendamento.setDataHora_chegada(rs.getString("Hora_chegada"));
                 objagendamento.setTrabalhador(rs.getString("Nome"));
                 objagendamento.setPet(rs.getString("Nome"));
                 objagendamento.setCliente(rs.getString("Nome"));
                 objagendamento.setServico(rs.getString("Tipo"));
                 
                 lista.add(objagendamento);
                 
             }
             
         } catch (SQLException erro) {
             JOptionPane.showMessageDialog(null, "RegistrosDAO Pesquisar: " + erro);
         }
         return lista;
     }
}
