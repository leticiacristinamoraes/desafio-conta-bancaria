package com.DesafioContaBancaria.conta.repository;

import com.DesafioContaBancaria.conta.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<ClientEntity, Long> {

    public ClientEntity findByCpf(String cpf);

}
