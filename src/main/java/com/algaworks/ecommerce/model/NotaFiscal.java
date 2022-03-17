package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nota_fiscal")
@Getter
@Setter
public class NotaFiscal extends EntidadeBaseInteger {

    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Lob
    private byte[] xml;

    @Column(name = "data_emissao")
    private Date dataEmissao;
}
