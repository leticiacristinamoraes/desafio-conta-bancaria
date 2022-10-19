package com.DesafioContaBancaria.conta.controller;

import com.DesafioContaBancaria.conta.dtos.ExibicaoContaDTO;
import com.DesafioContaBancaria.conta.dtos.ExtratoDTO;
import com.DesafioContaBancaria.conta.service.ContaService;
import com.DesafioContaBancaria.conta.service.ExtratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/extratos")
public class ExtratoController {

    @Autowired
    private ExtratoService extratoService;

    @Autowired
    private ContaService contaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExtratoDTO salvarExtrato(@RequestBody ExtratoDTO extratoDTO) {

        return extratoService.salvarExtrato(extratoDTO);
    }

    @GetMapping("/{idDestinatario}")
    public List<ExtratoDTO> mostrarExtratos(@PathVariable Long idDestinatario) {
        ExibicaoContaDTO exibicaoContaDTO = contaService.findById(idDestinatario);
        List<ExtratoDTO> extratos = extratoService.mostrarExtratos(exibicaoContaDTO);
        return extratos;
    }

}
