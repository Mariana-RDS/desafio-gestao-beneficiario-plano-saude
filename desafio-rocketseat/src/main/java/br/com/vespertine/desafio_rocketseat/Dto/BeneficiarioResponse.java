package br.com.vespertine.desafio_rocketseat.Dto;

import java.time.LocalDate;
import java.util.List;

public record BeneficiarioResponse(String nome, String telefone, LocalDate dataNascimento, List<DocumentoDTO> Documentos) {

}
