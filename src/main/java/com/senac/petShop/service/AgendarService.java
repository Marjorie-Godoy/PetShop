
package com.senac.petShop.service;

import com.senac.petShop.model.Agendar;
import com.senac.petShop.repository.AgendarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendarService {
    
    @Autowired
    AgendarRepository agendarRepository;
    
    public Agendar buscarPorId(Integer id){
        return agendarRepository.findById(id).orElseThrow();
    }
    
    public Agendar criar(Agendar agendar){
        agendar.setId(null);
        agendarRepository.save(agendar);
        return agendar;
    }
    
    public List<Agendar> listarTodos(){
        return agendarRepository.findAll();
    }
    
    public Agendar atualizar(Integer id, Agendar agendar){
        Agendar agendamentoEncontrado = buscarPorId(id);
        
        agendamentoEncontrado.setNome_pet(agendar.getNome_pet());
        agendamentoEncontrado.setRaça_pet(agendar.getRaça_pet());
        agendamentoEncontrado.setNome(agendar.getNome());
        agendamentoEncontrado.setTelefone(agendar.getTelefone());
        agendamentoEncontrado.setData(agendar.getData());
        agendamentoEncontrado.setHorario(agendar.getHorario());
        agendamentoEncontrado.setProfissional(agendar.getProfissional());
        agendamentoEncontrado.setServiços(agendar.getServiços());
        agendamentoEncontrado.setObservaçoes(agendar.getObservaçoes());
        agendarRepository.save(agendamentoEncontrado);
        
        return agendamentoEncontrado;
    }
    
        public void excluir(Integer id){
        Agendar agendamentoEncontrado = buscarPorId(id);
        agendarRepository.deleteById(agendamentoEncontrado.getId());
    }
}
