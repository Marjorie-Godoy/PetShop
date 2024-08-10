package com.senac.petShop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "agendamento")

public class Agendar {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
