package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

public class ConsultandoRegistrosTest extends EntityManagerTest {
    @Test
    public void buscarPorIdentificador() {
        Produto produto = entityManager.find(Produto.class, 1);   //recupera todos os atributos
//        Produto produto = entityManager.getReference(Produto.class, 1);     //enquanto não forem usados, atributos não são carregados (proxy)

        Assert.assertNotNull(produto);
        Assert.assertEquals("Kindle", produto.getNome());
    }

    @Test
    public void atualizarAReferencia() {
        Produto produto = entityManager.find(Produto.class, 1);
        produto.setNome("Microfone JBL");

        entityManager.refresh(produto);

        Assert.assertEquals("Kindle", produto.getNome());
    }
}
