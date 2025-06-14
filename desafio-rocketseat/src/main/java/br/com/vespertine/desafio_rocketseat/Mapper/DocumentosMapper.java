package br.com.vespertine.desafio_rocketseat.Mapper;

import java.util.List;
import org.mapstruct.*;

import br.com.vespertine.desafio_rocketseat.Dto.DocumentoDTO;
import br.com.vespertine.desafio_rocketseat.Entity.DocumentoEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DocumentosMapper {

    
    DocumentoEntity toEntity(DocumentoDTO documentoDTO);
    List<DocumentoEntity> toEntityList(List<DocumentoDTO> documentoDTOs);

    //Entity -> DTO
    DocumentoDTO toDto(DocumentoEntity documentoEntity);
    List<DocumentoDTO> toDtoList(List<DocumentoEntity> documentoEntities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DocumentoEntity partialUpdate(DocumentoDTO DocumentoDTO, @MappingTarget DocumentoEntity documentoEntity);

}
