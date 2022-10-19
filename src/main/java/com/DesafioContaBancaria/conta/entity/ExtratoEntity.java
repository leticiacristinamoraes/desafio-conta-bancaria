package com.DesafioContaBancaria.conta.entity;

import com.DesafioContaBancaria.conta.enums.TipoAcaoEnum;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "extrato")
public class ExtratoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_remetente")
    private ClientEntity remetente;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_destinatario")
    private ClientEntity destinatario;
    @Column(name = "tipoAcao")
    private TipoAcaoEnum tipoAcao;
    @Column(name = "valor_transferencia")
    private Double valorTransferencia;
    @Column(name = "dataTransferencia")
    private LocalDateTime dataTransferencia;

    public ExtratoEntity() {
    }

    public ExtratoEntity(Long id, ClientEntity remetente, ClientEntity destinatario,
                         TipoAcaoEnum tipoAcao, Double valorTransferencia, LocalDateTime dataTransferencia) {
        this.id = id;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.tipoAcao = tipoAcao;
        this.valorTransferencia = valorTransferencia;
        this.dataTransferencia = dataTransferencia;
    }

    public ExtratoEntity(ClientEntity remetente, ClientEntity destinatario, TipoAcaoEnum tipoAcao,
                         Double valorTransferencia, LocalDateTime dataTransferencia) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.tipoAcao = tipoAcao;
        this.valorTransferencia = valorTransferencia;
        this.dataTransferencia = dataTransferencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientEntity getRemetente() {
        return remetente;
    }

    public void setRemetente(ClientEntity remetente) {
        this.remetente = remetente;
    }

    public ClientEntity getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(ClientEntity destinatario) {
        this.destinatario = destinatario;
    }

    public TipoAcaoEnum getTipoAcao() {
        return tipoAcao;
    }

    public void setTipoAcao(TipoAcaoEnum tipoAcao) {
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
