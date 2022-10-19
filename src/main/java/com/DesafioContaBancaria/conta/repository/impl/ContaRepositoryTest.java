package com.DesafioContaBancaria.conta.repository.impl;

import com.DesafioContaBancaria.conta.entity.ClientEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContaRepositoryTest {
    private List<ClientEntity> correntistas = new ArrayList<>();

    public List<ClientEntity> mostrarCorrentistas() {
        return correntistas;
    }

    public void salvarCorrentista(ClientEntity clientEntity) {
        correntistas.add(clientEntity);
    }

}
