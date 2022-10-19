package com.DesafioContaBancaria.conta.service;

import com.DesafioContaBancaria.conta.dtos.ExibicaoContaDTO;

import java.util.List;

public interface ContaService {
    public ExibicaoContaDTO salvarCorrentista(ExibicaoContaDTO exibicaoContaDTO);

    public List<ExibicaoContaDTO> findAll();

    public ExibicaoContaDTO findById(Long id);

    public ExibicaoContaDTO findByCpf(String cpf);

    public ExibicaoContaDTO atualizarSaldo(ExibicaoContaDTO exibicaoContaDTO);

    public Boolean deletarUsuario(Long id);

}
