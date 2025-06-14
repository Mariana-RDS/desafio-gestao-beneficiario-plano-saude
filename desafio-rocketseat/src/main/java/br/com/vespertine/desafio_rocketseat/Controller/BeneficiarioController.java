package br.com.vespertine.desafio_rocketseat.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vespertine.desafio_rocketseat.Dto.BeneficiarioDTO;
import br.com.vespertine.desafio_rocketseat.Dto.DocumentoDTO;
import br.com.vespertine.desafio_rocketseat.Service.BeneficiarioService;

@RestController
@RequestMapping("/api")
public class BeneficiarioController {

    private final BeneficiarioService beneficiarioService;

    public BeneficiarioController(BeneficiarioService beneficiarioService) {
        this.beneficiarioService = beneficiarioService;
    }

    @GetMapping("/beneficiarios")
    public ResponseEntity<List<BeneficiarioDTO>> getAllBeneficiarios(){
        try {
            List<BeneficiarioDTO> dtos = beneficiarioService.getAll();
            if(dtos==null || dtos.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/documentos")
    public ResponseEntity<List<DocumentoDTO>> AllDocumentos(@PathVariable("id") Long id){
        try {
            List<DocumentoDTO> dtos = beneficiarioService.getAllDocumentos(id);
            if(dtos==null || dtos.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/beneficiario/{id}")
    public ResponseEntity<BeneficiarioDTO> getBeneficiarioById(@PathVariable("id") Long id){
        try {
            BeneficiarioDTO dto = beneficiarioService.getById(id);
            if(dto==null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<BeneficiarioDTO> createBeneficiario(@RequestBody BeneficiarioDTO beneficiarioDTO){
        try {
            BeneficiarioDTO dto = beneficiarioService.create(beneficiarioDTO);
            if(dto==null){
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BeneficiarioDTO> updateBeneficiario(@PathVariable("id") Long id, @RequestBody BeneficiarioDTO beneficiarioDTO){
        try{
            BeneficiarioDTO dtoUpdate = beneficiarioService.update(id, beneficiarioDTO);
            if(dtoUpdate==null){
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            return new ResponseEntity<>(dtoUpdate, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteBeneficiarioById(@PathVariable("id") Long id){
        try {
            if(beneficiarioService.delete(id)){
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteAllBeneficiarios(){
        try {
            if(beneficiarioService.deleteAll()){
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
}
