package com.example.danilo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao_tarefa")
    private String descricao;

    @Column(name = "prazo")
    private LocalDate dataVencimento;

    @Column(name = "tarefa_concluida")
    private Boolean conclusao;

    public Tarefa(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Boolean getConclusao() {
        return conclusao;
    }

    public void setConclusao(Boolean conclusao) {
        this.conclusao = conclusao;
    }
}
