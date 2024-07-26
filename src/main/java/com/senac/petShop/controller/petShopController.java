
package com.senac.petShop.controller;

import com.senac.petShop.model.Agendar;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class petShopController {
    
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
        model.addAttribute("agendas", listaAgendamento);
        return "registro";
    }
    
    @GetMapping("/cancelar")
    public String cancelarAtendimento(Model model, @RequestParam String id){
        Integer idAgendar = Integer.parseInt(id);
        
        for (Agendar a : listaAgendamento){
            if (a.getId()==idAgendar){
                listaAgendamento.remove(a);
                break;
            }
        }
     
        return "redirect:/registro";
    }
    
    
    @GetMapping("/reagendar")
    public String reagendarAtendimento(Model model, @RequestParam String id){
        Integer idAgendar = Integer.parseInt(id);
        
        Agendar registroEncontrado = new Agendar();
        for (Agendar a : listaAgendamento){
            if (a.getId()==idAgendar){
                registroEncontrado = a;
                break;
            }
        }
     
        model.addAttribute("agendar", registroEncontrado);
        return "agendamento";
    }
    
    
    
    
    @PostMapping("/agendamento")
    public String processarForm(Model model, @ModelAttribute Agendar agendar){
        
        if(agendar.getId()!=null){
            
           for (Agendar a : listaAgendamento){
            if (a.getId()== agendar.getId()){
                a.setNome_pet(agendar.getNome_pet());
                a.setRaça_pet(agendar.getRaça_pet());
                a.setNome(agendar.getNome());
                a.setData(agendar.getData());
                a.setHorario(agendar.getHorario());
                a.setProfissional(agendar.getProfissional());
                a.setServiços(agendar.getServiços());
                a.setObservaçoes(agendar.getObservaçoes());
                break;
            }
        }
            
        }else {
            agendar.setId(listaAgendamento.size()+1);
            listaAgendamento.add(agendar);
        }
        
        return "redirect:/registro";
    }
}
