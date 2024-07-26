package com.senac.petShop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Agendar {
    
    private Integer id;
    private String nome_pet;
    private String raça_pet;
    private String nome;
    private String telefone;
    private String data;
    private String horario;
    private String profissional;
    private String serviços;
    private String observaçoes;
}
