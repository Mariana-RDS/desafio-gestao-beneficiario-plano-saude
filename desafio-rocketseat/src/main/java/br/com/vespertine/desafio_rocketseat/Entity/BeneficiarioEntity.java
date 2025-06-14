package br.com.vespertine.desafio_rocketseat.Entity;

import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class BeneficiarioEntity extends AuditoriaEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private LocalDate dataNascimento;

    @OneToMany(mappedBy="beneficiario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DocumentoEntity> documentos = new ArrayList<>();



}
