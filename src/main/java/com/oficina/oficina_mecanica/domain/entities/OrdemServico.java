package com.oficina.oficina_mecanica.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table (name = "ORDEM_SERVICO")
public class OrdemServico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ORDEM_SERVICO", nullable = false, unique = true)
    private Long identificador;

    @CreationTimestamp
    @Column (name = "DATA_CADASTRO")
    private Instant dataCadastro;

    @UpdateTimestamp
    @Column (name = "DATA_ATUALIZACAO")
    private Instant dataAtualizacao;

    @Column (name = "NUMERO_ORDEM_SERVICO")
    private String numeroOrdemServico;

    @ManyToOne
    @JoinColumn(name = "ID_VEICULO", foreignKey = @ForeignKey(name = "FK_ORDEM_SERVICO_VEICULO"))
    private Veiculo veiculo;

    @Column (name = "DATA_ABERTURA")
    private Date dataAbertura;

    @Column (name = "DATA_FECHAMENTO")
    private Date dataFechamento;

    @Column(name = "STATUS")
    private Short status;

    @Column (name = "DESCRICAO")
    private String descricao;

    @OneToMany (mappedBy = "ordemServico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrdemServicoServico> servicos;

    @OneToMany (mappedBy = "ordemServico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrdemServicoPeca> pecas;

    @Column (name = "VALOR_TOTAL")
    private Double valorTotal;
}
