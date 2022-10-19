package com.DesafioContaBancaria.conta.service.impl;

import com.DesafioContaBancaria.conta.dtos.ExibicaoContaDTO;
import com.DesafioContaBancaria.conta.dtos.ExtratoDTO;
import com.DesafioContaBancaria.conta.entity.ClientEntity;
import com.DesafioContaBancaria.conta.entity.ExtratoEntity;
import com.DesafioContaBancaria.conta.enums.StatusDaConta;
import com.DesafioContaBancaria.conta.enums.TipoAcaoEnum;
import com.DesafioContaBancaria.conta.repository.ContaRepository;
import com.DesafioContaBancaria.conta.repository.ExtratoRepository;
import com.DesafioContaBancaria.conta.service.ExtratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service("extratoService")
public class ExtratoServiceImpl implements ExtratoService {
    @Autowired
    private ExtratoRepository extratoRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public ExtratoDTO salvarExtrato(ExtratoDTO extratoDTO) {
        ExtratoEntity extratoEntity = convertDTOparaEntity(extratoDTO);
        extratoEntity = extratoRepository.saveAndFlush(extratoEntity);
        return convertEntityparaDTO(extratoEntity);
    }

    @Override
    public List<ExtratoDTO> mostrarExtratos(ExibicaoContaDTO destinatario) {
        try {
            ClientEntity client = contaRepository.findByCpf(destinatario.getCpf());
            List<ExtratoEntity> destinatarios = extratoRepository.findByDestinatario(client);
            return convertListEntityparaListDTO(destinatarios);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }


    }

    private ExtratoEntity convertDTOparaEntity(ExtratoDTO extratoDTO) {
        TipoAcaoEnum tipoAcaoEnum = null;
        if (extratoDTO.getTipoAcao() == 1) {
            tipoAcaoEnum = TipoAcaoEnum.TRANSFERENCIA;
        } else {
            tipoAcaoEnum = TipoAcaoEnum.DEPOSITO;
        }
        ExibicaoContaDTO remetente = null;
        if (extratoDTO.getRemetente() != null) {
            remetente = extratoDTO.getRemetente();
        }
        return new ExtratoEntity((convertDTOparaEntity(remetente)), convertDTOparaEntity(extratoDTO.getDestinatario()),
                tipoAcaoEnum, extratoDTO.getValorTransferencia(), LocalDateTime.now());
    }

    private ExtratoDTO convertEntityparaDTO(ExtratoEntity extrato) {
        Long tipoAcao = null;
        if (extrato.getTipoAcao().getCodigo() == 1) {
            tipoAcao = TipoAcaoEnum.TRANSFERENCIA.getCodigo();
        } else {
            tipoAcao = TipoAcaoEnum.DEPOSITO.getCodigo();
        }
        ClientEntity remetente = null;
        if (extrato.getRemetente() != null) {
            remetente = extrato.getRemetente();
        }

        ExtratoDTO extratoDTO = new ExtratoDTO(convertEntityparaDTO(remetente), convertEntityparaDTO(extrato.getDestinatario()),
                tipoAcao, extrato.getValorTransferencia(), LocalDateTime.now());
        return extratoDTO;
    }

    private List<ExtratoDTO> convertListEntityparaListDTO(List<ExtratoEntity> list) {
        List<ExtratoDTO> listExibicao = new ArrayList<>();
        for (ExtratoEntity extrato : list) {
            //ExibicaoContaDTO exibicaoContaDTO = this.convertEntityparaDTO(client);
            listExibicao.add(this.convertEntityparaDTO(extrato));
        }
        return listExibicao;
    }

    private ExibicaoContaDTO convertEntityparaDTO(ClientEntity client) {
        if (client != null) {
            Long statusDaConta = null;
            if (client.getStatusDaConta().getCodigo() == 0) {
                statusDaConta = StatusDaConta.ATIVA.getCodigo();
            } else {
                statusDaConta = StatusDaConta.INATIVA.getCodigo();
            }

            return new ExibicaoContaDTO(client.getId(), client.getTitularDaConta(),
                    client.getCpf(), client.getNumeroDaConta(),
                    client.getAgenciaBancaria(), client.getSaldoDaConta(), statusDaConta);

        } else {
            return null;
        }

    }

    private ClientEntity convertDTOparaEntity(ExibicaoContaDTO exibicaoContaDTO) {

//        Long id;
//        if (exibicaoContaDTO.getId() != null) {
//            id = exibicaoContaDTO.getId();
//        } else {
//            id = null;
//        }
        if (exibicaoContaDTO != null) {

            return new ClientEntity((exibicaoContaDTO.getId() != null ? exibicaoContaDTO.getId() : null),
                    exibicaoContaDTO.getTitularDaConta(),
                    exibicaoContaDTO.getCpf(), exibicaoContaDTO.getNumeroDaConta(), exibicaoContaDTO.getAgenciaBancaria(),
                    exibicaoContaDTO.getSaldoDaConta(), LocalDateTime.now(), LocalDateTime.now());
        } else {
            return null;
        }

    }

}
