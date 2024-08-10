
package com.senac.petShop.controller;

import com.senac.petShop.model.Agendar;
import com.senac.petShop.service.AgendarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendar")
public class AgendarAPIController {
    
    @Autowired
    AgendarService agendarService;

    @PostMapping("/adicionar")
    public ResponseEntity<Agendar> criar (@RequestBody Agendar agendar){
        Agendar novoAgendar = agendarService.criar(agendar);
        return new ResponseEntity<>(novoAgendar, HttpStatus.CREATED);
    }
    
    
     //buscar por id
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Agendar> pesquisar(@PathVariable Integer id){
        Agendar agendarEncontrado = agendarService.buscarPorId(id);
        return new ResponseEntity<>(agendarEncontrado, HttpStatus.OK);
    }

    
     //listar todos
    @GetMapping("/listarTodos")
    public ResponseEntity<List> listar(){
        List<Agendar> listaTodosAgendamentos = agendarService.listarTodos();
        return new ResponseEntity<>(listaTodosAgendamentos, HttpStatus.OK);
    }
    
    //atualizar
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Agendar> editarAgendamento(@PathVariable Integer id, @RequestBody Agendar agendar){
        Agendar agendarAtualizado = agendarService.atualizar(id, agendar);
        return new ResponseEntity<>(agendarAtualizado, HttpStatus.OK);
    }
    
     //excluir
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        agendarService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
