package com.DesafioContaBancaria.conta.service.impl;

import com.DesafioContaBancaria.conta.dtos.ExibicaoContaDTO;
import com.DesafioContaBancaria.conta.entity.ClientEntity;
import com.DesafioContaBancaria.conta.enums.StatusDaConta;
import com.DesafioContaBancaria.conta.repository.ContaRepository;
import com.DesafioContaBancaria.conta.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContaServiceImpl implements ContaService {
    @Autowired
    private ContaRepository contaRepository;
    @Override
    public ExibicaoContaDTO salvarCorrentista(ExibicaoContaDTO exibicaoContaDTO) {
        ClientEntity clientEntity = convertDTOparaEntity(exibicaoContaDTO);
        ClientEntity client = contaRepository.saveAndFlush(clientEntity);
        return convertEntityparaDTO(client);
    }

    @Override
    public List<ExibicaoContaDTO> findAll() {
        List<ClientEntity> list = contaRepository.findAll();
        return convertListEntityparaListDTO(list);
    }

    @Override
    public ExibicaoContaDTO findById(Long id) {
        ClientEntity clientEntity = contaRepository.findById(id).get();
        ExibicaoContaDTO exibicaoContaDTO = this.convertEntityparaDTO(clientEntity);

        return exibicaoContaDTO;
    }

    @Override
    public ExibicaoContaDTO findByCpf(String cpf) {
        ClientEntity clientEntity = contaRepository.findByCpf(cpf);
        ExibicaoContaDTO exibicaoContaDTO = this.convertEntityparaDTO(clientEntity);
        return exibicaoContaDTO;
    }

    @Override
    public ExibicaoContaDTO atualizarSaldo(ExibicaoContaDTO exibicaoContaDTO) {
        ClientEntity clientEntity = convertDTOparaEntity(exibicaoContaDTO);
        contaRepository.saveAndFlush(clientEntity);
        ExibicaoContaDTO exibicaoContaDTO1 = convertEntityparaDTO(clientEntity);
        return exibicaoContaDTO1;
    }

    @Override
    public Boolean deletarUsuario(Long id) {
        try {
            ClientEntity user = contaRepository.findById(id).get();
            user.setStatusDaConta(StatusDaConta.INATIVA);
            contaRepository.saveAndFlush(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    private ClientEntity convertDTOparaEntity(ExibicaoContaDTO exibicaoContaDTO) {
        StatusDaConta statusDaConta = null;
        if (exibicaoContaDTO.getStatusDaConta() == 0) {
            statusDaConta = StatusDaConta.ATIVA;
        } else {
            statusDaConta = StatusDaConta.INATIVA;
        }

//        Long id;
//        if (exibicaoContaDTO.getId() != null) {
//            id = exibicaoContaDTO.getId();
//        } else {
//            id = null;
//        }
        return new ClientEntity((exibicaoContaDTO.getId() != null ? exibicaoContaDTO.getId() : null),
                exibicaoContaDTO.getTitularDaConta(), exibicaoContaDTO.getCpf(),
                exibicaoContaDTO.getNumeroDaConta(),exibicaoContaDTO.getAgenciaBancaria(),
                exibicaoContaDTO.getSaldoDaConta(), LocalDateTime.now(), LocalDateTime.now(), statusDaConta);
    }

    private List<ExibicaoContaDTO> convertListEntityparaListDTO(List<ClientEntity> list) {
        List<ExibicaoContaDTO> listExibicao = new ArrayList<>();
        for (ClientEntity client : list) {
            //ExibicaoContaDTO exibicaoContaDTO = this.convertEntityparaDTO(client);
            listExibicao.add(this.convertEntityparaDTO(client));
        }
        return listExibicao;
    }

    private ExibicaoContaDTO convertEntityparaDTO(ClientEntity client) {
        Long statusDaConta = null;
        if (client.getStatusDaConta().getCodigo() == 0) {
            statusDaConta = StatusDaConta.ATIVA.getCodigo();
        } else {
            statusDaConta = StatusDaConta.INATIVA.getCodigo();
        }
        ExibicaoContaDTO exibicaoContaDTO = new ExibicaoContaDTO(client.getId(), client.getTitularDaConta(), client.getCpf(),
                client.getNumeroDaConta(), client.getAgenciaBancaria(), client.getSaldoDaConta(), statusDaConta);
        return exibicaoContaDTO;
    }

}
