package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
//@Table(name = "pagamento_cartao")
@DiscriminatorValue(value = "cartao")
@Getter
@Setter
public class PagamentoCartao extends Pagamento {

    @Column(name = "numero_cartao")
    private String numero;
}
