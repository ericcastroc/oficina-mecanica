package com.oficina.oficina_mecanica.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "PECA")
public class Peca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PECA", nullable = false, unique = true)
    private Long identificador;

    @CreationTimestamp
    @Column (name = "DATA_CADASTRO")
    private Instant dataCadastro;

    @UpdateTimestamp
    @Column (name = "DATA_ATUALIZACAO")
    private Instant dataAtualizacao;

    @Column(name = "NOME")
    private String nome;

    @Column (name = "CODIGO")
    private String codigo;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "PRECO")
    private Double preco;

    @Column(name = "MODELO_COMPATIVEL")
    private String modeloCompativel;

    @Column(name = "QUANTIDADE_ESTOQUE")
    private Integer quantidadeEstoque;
}
