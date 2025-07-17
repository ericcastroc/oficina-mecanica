package com.oficina.oficina_mecanica.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Table (name = "ORDEM_SERVICO_PECA")
public class OrdemServicoPeca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ORDEM_SERVICO_PECA", nullable = false, unique = true)
    private Long identificador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ORDEM_SERVICO", foreignKey = @ForeignKey(name = "FK_OS_PECA_ORDEM_SERVICO"), nullable = false)
    private OrdemServico ordemServico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PECA", foreignKey = @ForeignKey(name = "FK_OS_PECA_PECA"), nullable = false)
    private Peca peca;

    @Column(name = "QUANTIDADE", nullable = false)
    private Integer quantidade;

    @Column(name = "VALOR_UNITARIO", nullable = false)
    private Double valorUnitario;

    @Column(name = "VALOR_TOTAL", nullable = false)
    private Double valorTotal;
}
