package com.DesafioContaBancaria.conta.enums;

public enum TipoAcaoEnum {
   DEFAULT(0L,"Default"), TRANSFERENCIA(1L,"Transferencia"), DEPOSITO(2L,"Deposito");

    private Long codigo;
    private String descricao;

    TipoAcaoEnum(Long codigo, String descricao) {
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
