package com.DesafioContaBancaria.conta.entity;

import com.DesafioContaBancaria.conta.enums.StatusDaConta;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "client")

public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "titular_da_conta")
    private String titularDaConta;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "numero_da_conta")
    private int numeroDaConta;
    @Column(name = "agencia_bancaria")
    private int agenciaBancaria;
    @Column(name = "saldo_da_conta")
    private Double saldoDaConta;
    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao;
    @Column(name = "data_de_atualizacao")
    private LocalDateTime dataDeAtualizacao;
    
    @Column(name = "status_da_conta")
    private StatusDaConta statusDaConta;

    public ClientEntity() {
    }

    public ClientEntity(Long id, String titularDaConta, String cpf, int numeroDaConta, int agenciaBancaria, Double saldoDaConta,
                        LocalDateTime dataDeCriacao, LocalDateTime dataDeAtualizacao, StatusDaConta statusDaConta) {
        this.id = id;
        this.titularDaConta = titularDaConta;
        this.cpf = cpf;
        this.numeroDaConta = numeroDaConta;
        this.agenciaBancaria = agenciaBancaria;
        this.saldoDaConta = saldoDaConta;
        this.dataDeCriacao = dataDeCriacao;
        this.dataDeAtualizacao = dataDeAtualizacao;
        this.statusDaConta = statusDaConta;
    }

    public ClientEntity(Long aLong, String titularDaConta, String cpf, int numeroDaConta, int agenciaBancaria, Double saldoDaConta, LocalDateTime now, LocalDateTime now1) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitularDaConta() {
        return titularDaConta;
    }

    public void setTitularDaConta(String titularDaConta) {
        this.titularDaConta = titularDaConta;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public int getAgenciaBancaria() {
        return agenciaBancaria;
    }

    public void setAgenciaBancaria(int agenciaBancaria) {
        this.agenciaBancaria = agenciaBancaria;
    }

    public Double getSaldoDaConta() {
        return saldoDaConta;
    }

    public void setSaldoDaConta(Double saldoDaConta) {
        this.saldoDaConta = saldoDaConta;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public LocalDateTime getDataDeAtualizacao() {
        return dataDeAtualizacao;
    }

    public void setDataDeAtualizacao(LocalDateTime dataDeAtualizacao) {
        this.dataDeAtualizacao = dataDeAtualizacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public StatusDaConta getStatusDaConta() {
        return statusDaConta;
    }

    public void setStatusDaConta(StatusDaConta statusDaConta) {
        this.statusDaConta = statusDaConta;
    }

}
