package br.com.vespertine.desafio_rocketseat.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vespertine.desafio_rocketseat.Dto.BeneficiarioDTO;
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
}
