package com.DesafioContaBancaria.conta.enums;

public enum StatusDaConta {
    ATIVA(0L, "Ativa"), INATIVA(1L, "Inativa");

    private Long codigo;
    private String descricao;

    StatusDaConta(Long codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
