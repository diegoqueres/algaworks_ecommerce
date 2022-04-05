package com.algaworks.ecommerce.conhecendoentitymanager;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Categoria;
import org.junit.Test;

public class EstadosECicloDeVidaTest extends EntityManagerTest {

    @Test
    public void analisarEstados() {
        Categoria categoriaNovo = new Categoria();   //Transient
        categoriaNovo.setNome("Eletrônicos");

        //se quiser fazer a nova ser gerenciada...
        Categoria categoriaGerenciadaMerge = entityManager.merge(categoriaNovo);   //Managed

        Categoria categoriaGerenciada = entityManager.find(Categoria.class, 1);    //Managed

        entityManager.remove(categoriaGerenciada);     //Removed

        entityManager.persist(categoriaGerenciada);    //Managed

        entityManager.detach(categoriaGerenciada);      //Detached
    }

}
