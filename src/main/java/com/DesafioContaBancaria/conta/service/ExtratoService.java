package com.DesafioContaBancaria.conta.service;

import com.DesafioContaBancaria.conta.dtos.ExibicaoContaDTO;
import com.DesafioContaBancaria.conta.dtos.ExtratoDTO;
import com.DesafioContaBancaria.conta.entity.ClientEntity;

import java.util.List;

public interface ExtratoService {

    public ExtratoDTO salvarExtrato(ExtratoDTO extratoDTO);

    public List<ExtratoDTO> mostrarExtratos(ExibicaoContaDTO destinatario);
}
