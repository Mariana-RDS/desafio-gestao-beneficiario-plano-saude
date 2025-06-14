package br.com.vespertine.desafio_rocketseat.Service;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.vespertine.desafio_rocketseat.Dto.BeneficiarioDTO;
import br.com.vespertine.desafio_rocketseat.Dto.DocumentoDTO;
import br.com.vespertine.desafio_rocketseat.Entity.BeneficiarioEntity;
import br.com.vespertine.desafio_rocketseat.Entity.DocumentoEntity;
import br.com.vespertine.desafio_rocketseat.Mapper.BeneficiarioMapper;
import br.com.vespertine.desafio_rocketseat.Mapper.DocumentosMapper;
import br.com.vespertine.desafio_rocketseat.Repository.BeneficiarioRepository;

@Service
public class BeneficiarioService {

    private final BeneficiarioRepository beneficiarioRepository;
    private final BeneficiarioMapper beneficiarioMapper;
    private final DocumentosMapper documentosMapper;

    

    public BeneficiarioService(BeneficiarioRepository beneficiarioRepository, BeneficiarioMapper beneficiarioMapper, DocumentosMapper documentosMapper) {
        this.beneficiarioRepository = beneficiarioRepository;
        this.beneficiarioMapper = beneficiarioMapper;
        this.documentosMapper = documentosMapper;
    }

    public List<DocumentoDTO> getAllDocumentos(Long id){
        try{
            Optional<BeneficiarioEntity> beneficiarios = beneficiarioRepository.findById(id);
            if(beneficiarios.isPresent()){
                return List.of();
            }
            BeneficiarioEntity beneficiario = beneficiarios.get();
            List<DocumentoEntity> documentos = beneficiario.getDocumentos();
            return documentosMapper.toDtoList(documentos);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Please Try Again");
        }
    }

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
            Optional<BeneficiarioEntity> beneficiario = beneficiarioRepository.findByTelefone(beneficiarioDTO.telefone());
            if(beneficiario.isPresent()){
                return null;
            }else{
                BeneficiarioEntity newBeneficiarioEntity = beneficiarioMapper.toEntity(beneficiarioDTO);
                newBeneficiarioEntity = beneficiarioRepository.save(newBeneficiarioEntity);
                return beneficiarioMapper.toDto(newBeneficiarioEntity);
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

    public Boolean delete(Long id){
        try {
            Optional<BeneficiarioEntity> beneficiario = beneficiarioRepository.findById(id);
            if(beneficiario.isPresent()){
                beneficiarioRepository.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Please Try Again");
        }
    }

    public Boolean deleteAll(){
        try {
            beneficiarioRepository.deleteAll();
            return true;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Please Try Again");
        }
    }

}
