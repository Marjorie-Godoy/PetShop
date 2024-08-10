
package com.senac.petShop.controller;

import com.senac.petShop.model.Agendar;
import com.senac.petShop.service.AgendarService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class petShopController {
    
    @Autowired
    AgendarService agendarService;
    
    private List<Agendar> listaAgendamento = new ArrayList<>();
    
    @GetMapping("/")
    public String inicio(){
        return"home";
    }
    
    @GetMapping("/home")
    public String inicio2(){
        return"home";
    }
    
    @GetMapping("/agendamento")
    public String AgendaAtendimento(Model model){
        model.addAttribute("agendar", new Agendar());
        
        return "agendamento";
    }
    
    @GetMapping("/registro")
    public String RegistroAtendimentos(Model model){
        model.addAttribute("agendas", agendarService.listarTodos());
        return "registro";
    }
    
    @GetMapping("/cancelar")
    public String cancelarAtendimento(Model model, @RequestParam String id){
        Integer idAgendar = Integer.parseInt(id);
        agendarService.excluir(idAgendar);
     
        return "redirect:/registro";
    }
    
    
    @GetMapping("/reagendar")
    public String reagendarAtendimento(Model model, @RequestParam String id){
        Integer idAgendar = Integer.parseInt(id);
        
        model.addAttribute("agendar", agendarService.buscarPorId(idAgendar));
        return "agendamento";
    }
    
    
    
    
    @PostMapping("/agendamento")//gravar-livro
    public String processarForm(Model model, @ModelAttribute Agendar agendar){
        
        if(agendar.getId()!=null){
            agendarService.atualizar(agendar.getId(), agendar);
        }else {
            agendarService.criar(agendar);
        }
        return "redirect:/registro";
    }
}
