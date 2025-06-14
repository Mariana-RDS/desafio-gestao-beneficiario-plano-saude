package br.com.vespertine.desafio_rocketseat.Dto;

import java.io.Serializable;

public record DocumentoDTO(
    String tipoDocumento, 
    String descricao
) implements Serializable {}
