package com.DesafioContaBancaria.conta.repository;

import com.DesafioContaBancaria.conta.entity.ClientEntity;
import com.DesafioContaBancaria.conta.entity.ExtratoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtratoRepository extends JpaRepository<ExtratoEntity, Long> {

    public List<ExtratoEntity> findByDestinatario(ClientEntity destinatario);

}
