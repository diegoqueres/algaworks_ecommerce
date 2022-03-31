package com.algaworks.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "categoria",
    uniqueConstraints = { @UniqueConstraint(name = "unq_nome", columnNames = { "nome" }) }
)
public class Categoria extends EntidadeBaseInteger {

    @Column(columnDefinition = "varchar(100) not null")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "categoria_pai_id")
    private Categoria categoriaPai;

    @OneToMany(mappedBy = "categoriaPai")
    private List<Categoria> categorias;

    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos;
}
