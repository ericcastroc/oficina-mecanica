package com.oficina.oficina_mecanica.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Table (name = "ORDEM_SERVICO_SERVICO")
public class OrdemServicoServico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ORDEM_SERVICO_SERVICO", nullable = false, unique = true)
    private Long identificador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ORDEM_SERVICO", foreignKey = @ForeignKey(name = "FK_OS_SERVICO_ORDEM_SERVICO"), nullable = false)
    private OrdemServico ordemServico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SERVICO", foreignKey = @ForeignKey(name = "FK_OS_SERVICO_SERVICO"), nullable = false)
    private Servico servico;

    @Column(name = "VALOR", nullable = false)
    private Double valor;
}
