package br.com.vespertine.desafio_rocketseat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vespertine.desafio_rocketseat.Entity.DocumentoEntity;

public interface DocumentoRepository extends JpaRepository<DocumentoEntity, Long>{

}
