package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class EnderecoEntregaPedido {
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String estado;
}
