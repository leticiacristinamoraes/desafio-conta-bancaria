package com.DesafioContaBancaria.conta.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CadastrarContaDTO {
    @Size(min = 2, max = 50, message = "O campo nome deve conter pelo menos 2 caracteres.")
    @NotBlank(message = "Campo de preenchimento obrigatório!")
    private String titularDaConta;
    @Max(value = 4)
    private int numeroDaconta;
    @Max(value = 4)
    private int agenciaBancaria;
    private Double saldoEmConta;

    public CadastrarContaDTO() {
    }

    public String getTitularDaConta() {
        return titularDaConta;
    }

    public void setTitularDaConta(String titularDaConta) {
        this.titularDaConta = titularDaConta;
    }

    public int getNumeroDaconta() {
        return numeroDaconta;
    }

    public void setNumeroDaconta(int numeroDaconta) {
        this.numeroDaconta = numeroDaconta;
    }

    public int getAgenciaBancaria() {
        return agenciaBancaria;
    }

    public void setAgenciaBancaria(int agenciaBancaria) {
        this.agenciaBancaria = agenciaBancaria;
    }

    public Double getSaldoEmConta() {
        return saldoEmConta;
    }

    public void setSaldoEmConta(Double saldoEmConta) {
        this.saldoEmConta = saldoEmConta;
    }

}
