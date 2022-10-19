package com.DesafioContaBancaria.conta.controller;

import com.DesafioContaBancaria.conta.dtos.ExibicaoContaDTO;
import com.DesafioContaBancaria.conta.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    private ContaService contaService;

    @GetMapping
    public List<ExibicaoContaDTO> mostrarCorrentistas() {
        List<ExibicaoContaDTO> list = contaService.findAll();
        return list;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExibicaoContaDTO cadastrarCorrentista(@RequestBody ExibicaoContaDTO exibicaoContaDTO) {

        return contaService.salvarCorrentista(exibicaoContaDTO);
    }

    @GetMapping("/{id}")
    public ExibicaoContaDTO exibirCorrentistaId(@PathVariable Long id) {
        ExibicaoContaDTO client = contaService.findById(id);
        return client;
    }

    @GetMapping("/transferencia/{cpf}")
    public ExibicaoContaDTO buscarUsuarioCPf(@PathVariable String cpf) {
        ExibicaoContaDTO usuarioCpf = contaService.findByCpf(cpf);
        return usuarioCpf;
    }

    @PostMapping("/update")
    public ExibicaoContaDTO atualizarSaldo(@RequestBody ExibicaoContaDTO exibicaoContaDTO) {
        ExibicaoContaDTO saldoAtualizado = contaService.atualizarSaldo(exibicaoContaDTO);
        return saldoAtualizado;
    }

    @GetMapping("/delete/{id}")
    public Boolean deletarClient(@PathVariable Long id) {
        Boolean usuarioCpf = contaService.deletarUsuario(id);
        return usuarioCpf;
    }

}
