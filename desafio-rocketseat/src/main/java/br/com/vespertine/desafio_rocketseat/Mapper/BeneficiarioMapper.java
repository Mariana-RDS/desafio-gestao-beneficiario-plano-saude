package br.com.vespertine.desafio_rocketseat.Mapper;

import java.util.List;
import org.mapstruct.*;
import br.com.vespertine.desafio_rocketseat.Dto.BeneficiarioDTO;
import br.com.vespertine.desafio_rocketseat.Entity.BeneficiarioEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BeneficiarioMapper {

    // DTO -> Entity
    BeneficiarioEntity toEntity(BeneficiarioDTO BeneficiarioDTO);
    List<BeneficiarioEntity> toEntityList(List<BeneficiarioDTO> beneficiarioDTOs);

    //Entity -> DTO
    BeneficiarioDTO toDto(BeneficiarioEntity beneficiarioEntity);
    List<BeneficiarioDTO> toDtoList(List<BeneficiarioEntity> beneficiarioEntities);

    //atualiza campos não-nulos sem sobrescrever os campos já preenchidos
    //garante que valores null do DTO não sobrescrevam os da Entity
    //@MappingTarget indica que esta modificando um objeto existente, e não criando um novo
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BeneficiarioEntity partialUpdate(BeneficiarioDTO beneficiarioDTO, @MappingTarget BeneficiarioEntity beneficiarioEntity);

}
