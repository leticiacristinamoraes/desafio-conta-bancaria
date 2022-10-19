package com.DesafioContaBancaria.conta.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExibicaoContaDTO {
    private Long id;
    @JsonProperty("titular_da_conta")
    private String titularDaConta;
    @JsonProperty("cpf")
    private String cpf;
    @JsonProperty("numero_da_conta")
    private int numeroDaConta;
    @JsonProperty("agencia_bancaria")
    private int agenciaBancaria;
    @JsonProperty("saldo_da_conta")
    private Double saldoDaConta;

    @JsonProperty("status_da_conta")
    private Long statusDaConta;

    public ExibicaoContaDTO() {
    }

    public ExibicaoContaDTO(Long id, String titularDaConta, String cpf, int numeroDaConta, int agenciaBancaria,
                            Double saldoDaConta, Long statusDaConta) {
        this.id = id;
        this.titularDaConta = titularDaConta;
        this.cpf = cpf;
        this.numeroDaConta = numeroDaConta;
        this.agenciaBancaria = agenciaBancaria;
        this.saldoDaConta = saldoDaConta;
        this.statusDaConta = statusDaConta;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getStatusDaConta() {
        return statusDaConta;
    }

    public void setStatusDaConta(Long statusDaConta) {
        this.statusDaConta = statusDaConta;
    }

}
