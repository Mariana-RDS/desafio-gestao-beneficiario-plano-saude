package br.com.vespertine.desafio_rocketseat.Service;

import java.util.*;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.vespertine.desafio_rocketseat.Dto.BeneficiarioDTO;
import br.com.vespertine.desafio_rocketseat.Entity.BeneficiarioEntity;
import br.com.vespertine.desafio_rocketseat.Mapper.BeneficiarioMapper;
import br.com.vespertine.desafio_rocketseat.Repository.BeneficiarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BeneficiarioService {

    private final BeneficiarioRepository beneficiarioRepository;
    private final BeneficiarioMapper beneficiarioMapper;

    public List<BeneficiarioDTO> getAll(){
        try{
            List<BeneficiarioEntity> beneficiarios = new ArrayList<BeneficiarioEntity>(beneficiarioRepository.findAll());
            if(beneficiarios.isEmpty()){
                return null;
            }
            return beneficiarioMapper.toDtoList(beneficiarios);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Please Try Again");
        }
    }

    public BeneficiarioDTO getById(Long id){
        try{
            Optional<BeneficiarioEntity> beneficiario = beneficiarioRepository.findById(id);
            if(beneficiario.isPresent()){
                return beneficiarioMapper.toDto(beneficiario.get());
            }
            return null;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Please Try Again");
        }
    }

    public BeneficiarioDTO create(BeneficiarioDTO beneficiarioDTO){
        try {
            Optional<BeneficiarioEntity> beneficiario = beneficiarioRepository.findByPhone(beneficiarioDTO.telefone());
            if(beneficiario.isPresent()){
                return null;
            }else{
                BeneficiarioEntity novobeneficiario = beneficiarioMapper.toEntity(beneficiarioDTO);
                novobeneficiario = beneficiarioRepository.save(novobeneficiario);
                return beneficiarioMapper.toDto(novobeneficiario);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Please Try Again");
        }
    }

    public BeneficiarioDTO update(Long id, BeneficiarioDTO beneficiarioDTO){
        try {
            Optional<BeneficiarioEntity> beneficiario = beneficiarioRepository.findById(id);
            if(beneficiario.isPresent()){
                BeneficiarioEntity upBeneficiario = beneficiario.get();
                beneficiarioMapper.partialUpdate(beneficiarioDTO, upBeneficiario);
                beneficiarioRepository.save(upBeneficiario);
                return beneficiarioMapper.toDto(upBeneficiario);
            }else{
                return null;
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Please Try Again");
        }
    }

    
    

}
