package com.oficina.oficina_mecanica.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "VEICULO")
public class Veiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VEICULO", nullable = false, unique = true)
    private Long identificador;

    @CreationTimestamp
    @Column (name = "DATA_CADASTRO")
    private Instant dataCadastro;

    @UpdateTimestamp
    @Column (name = "DATA_ATUALIZACAO")
    private Instant dataAtualizacao;

    @Column (name = "MARCA")
    private String marca;

    @Column (name = "MODELO")
    private String modelo;

    @Column (name = "ANO")
    private String ano;

    @Column (name = "PLACA")
    private String placa;

    @Column (name = "COR")
    private String cor;

    @Column (name = "KM_ATUAL")
    private Long kmAtual;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENTE", foreignKey = @ForeignKey(name = "FK_VEICULO_CLIENTE"))
    private Cliente cliente;
}
