package com.DesafioContaBancaria.conta;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titularDaConta;
    private int numeroDaConta;
    private int agenciaBancaria;
    private Double saldoDaConta;

    public Conta() {
    }

    public Conta(int id, String titularDaConta, int numeroDaConta, int agenciaBancaria, Double saldoDaConta) {
        this.id = id;
        this.titularDaConta = titularDaConta;
        this.numeroDaConta = numeroDaConta;
        this.agenciaBancaria = agenciaBancaria;
        this.saldoDaConta = saldoDaConta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

}
