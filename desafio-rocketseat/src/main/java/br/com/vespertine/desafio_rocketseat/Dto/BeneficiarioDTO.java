package br.com.vespertine.desafio_rocketseat.Dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public record BeneficiarioDTO(
    Long id, 
    String nome, 
    String telefone, 
    LocalDate dataNascimento, 
    List<DocumentoDTO> Documentos
) implements Serializable {}
