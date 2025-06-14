package br.com.vespertine.desafio_rocketseat.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vespertine.desafio_rocketseat.Entity.BeneficiarioEntity;

public interface BeneficiarioRepository extends JpaRepository<BeneficiarioEntity, Long>{
    Optional<BeneficiarioEntity> findByPhone(String telefone);

}
