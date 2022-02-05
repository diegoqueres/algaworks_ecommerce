package com.algaworks.ecommerce.model;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * As classes de entidade podem ser mapeadas também nos métodos get.
 * Dessa forma, o mapeamento não fica mais localizado nos atributos.
 */
@Entity
@Table(name = "categoria")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Categoria {

    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    private Integer categoriaPaiId;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "categoria_pai_id")
    public Integer getCategoriaPaiId() {
        return categoriaPaiId;
    }

    public void setCategoriaPaiId(Integer categoriaPaiId) {
        this.categoriaPaiId = categoriaPaiId;
    }
}
