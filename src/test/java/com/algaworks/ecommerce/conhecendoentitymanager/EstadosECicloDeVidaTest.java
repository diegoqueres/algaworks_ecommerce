package com.algaworks.ecommerce.conhecendoentitymanager;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Categoria;

public class EstadosECicloDeVidaTest extends EntityManagerTest {

    public void analisarEstados() {
        Categoria categoriaNovo = new Categoria();   //Transient
        //se quiser fazer a nova ser gerenciada...
        Categoria categoriaGerenciadaMerge = entityManager.merge(categoriaNovo);   //Managed

        Categoria categoriaGerenciada = entityManager.find(Categoria.class, 1);    //Managed

        entityManager.remove(categoriaGerenciada);     //Removed

        entityManager.persist(categoriaGerenciada);    //Managed

        entityManager.detach(categoriaGerenciada);      //Detached
    }

}
