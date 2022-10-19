package com.DesafioContaBancaria.conta.dtos;

import com.DesafioContaBancaria.conta.entity.ClientEntity;

import java.time.LocalDateTime;

public class ExtratoDTO {

    private ExibicaoContaDTO remetente;
    private ExibicaoContaDTO destinatario;
    private Long tipoAcao;
    private Double valorTransferencia;
    private LocalDateTime dataTransferencia;

    public ExtratoDTO() {
    }

    public ExtratoDTO(ExibicaoContaDTO remetente, ExibicaoContaDTO destinatario,
                      Long tipoAcao, Double valorTransferencia, LocalDateTime dataTransferencia) {

        this.remetente = remetente;
        this.destinatario = destinatario;
        this.tipoAcao = tipoAcao;
        this.valorTransferencia = valorTransferencia;
        this.dataTransferencia = dataTransferencia;
    }


    public ExibicaoContaDTO getRemetente() {
        return remetente;
    }

    public void setRemetente(ExibicaoContaDTO remetente) {
        this.remetente = remetente;
    }

    public ExibicaoContaDTO getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(ExibicaoContaDTO destinatario) {
        this.destinatario = destinatario;
    }

    public Long getTipoAcao() {
        return tipoAcao;
    }

    public void setTipoAcao(Long tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public Double getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(Double valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }

    public LocalDateTime getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(LocalDateTime dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

}




