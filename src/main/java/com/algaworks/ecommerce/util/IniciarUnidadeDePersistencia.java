package com.algaworks.ecommerce.util;

import com.algaworks.ecommerce.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;

public class IniciarUnidadeDePersistencia {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Faça seus testes aqui
        Produto produto = entityManager.find(Produto.class, 1);
        System.out.println(produto.getNome());

        entityManager.close();
        entityManagerFactory.close();
    }
}
