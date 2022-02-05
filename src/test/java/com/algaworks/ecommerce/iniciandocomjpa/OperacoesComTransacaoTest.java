package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoTest extends EntityManagerTest {
    @Test
    public void abrirEFecharATransacao() {
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
    }

    @Test
    public void inserirOPrimeiroObjeto() {
        Produto produto = new Produto();
        produto.setId(2);
        produto.setNome("Câmera Canon");
        produto.setDescricao("A melhor definição para suas fotos.");
        produto.setPreco(new BigDecimal(5000.00));

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();  //se não for executado, o find busca na memória do entity manager.

        Produto produtoVerificar = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificar);
        Assert.assertEquals("Câmera Canon", produtoVerificar.getNome());
    }

    @Test
    public void removerObjeto() {
        Produto produto = entityManager.find(Produto.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        Produto produtoVerificacao = entityManager.find(Produto.class, 3);
        Assert.assertNull(produtoVerificacao);
    }

    @Test
    public void atualizarObjeto() {
        Produto produto = new Produto();
        produto.setId(1);
        produto.setNome("Kindle Paperwhite");
        produto.setDescricao("conheça papaerwhite");
        produto.setPreco(new BigDecimal(499));

        entityManager.merge(produto);
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();

        entityManager.clear();  //se não for executado, o find busca na memória do entity manager.

        Produto produtoVerificar = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificar);
        Assert.assertEquals("Kindle Paperwhite", produtoVerificar.getNome());
    }

    @Test
    public void atualizarObjetoGerenciado() {
        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle Paperwhite Geração 2");
        entityManager.getTransaction().commit();

        entityManager.clear();  //se não for executado, o find busca na memória do entity manager.

        Produto produtoVerificar = entityManager.find(Produto.class, produto.getId());
        Assert.assertEquals("Kindle Paperwhite Geração 2", produtoVerificar.getNome());
    }

    @Test
    public void inserirObjetoComMerge() {
        Produto produto = new Produto();
        produto.setId(4);
        produto.setNome("Microfone Rode");
        produto.setDescricao("Melhores notas sonoras para sua voz");
        produto.setPreco(new BigDecimal(259));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();  //se não for executado, o find busca na memória do entity manager.

        Produto produtoVerificar = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificar);
        Assert.assertEquals("Microfone Rode", produtoVerificar.getNome());
    }

    @Test
    public void mostrarDiferencaoPersistMerge() {
        Produto produtoPersist = new Produto();

        produtoPersist.setId(5);
        produtoPersist.setNome("Smartphone One Plus");
        produtoPersist.setDescricao("O processador mais rápido.");
        produtoPersist.setPreco(new BigDecimal(2000));

        entityManager.getTransaction().begin();
        entityManager.persist(produtoPersist);
        produtoPersist.setNome("Smartphone One Plus II");  //fará efeito porquê a instância é salva e passa a ser gerenciada.
        entityManager.getTransaction().commit();

        entityManager.clear();  //se não for executado, o find busca na memória do entity manager.

        Produto produtoPersistVerificar = entityManager.find(Produto.class, produtoPersist.getId());
        Assert.assertNotNull(produtoPersistVerificar);
        Assert.assertEquals("Smartphone One Plus II", produtoPersistVerificar.getNome());



        Produto produtoMerge = new Produto();

        produtoMerge.setId(6);
        produtoMerge.setNome("Notebook Dell");
        produtoMerge.setDescricao("O processador mais rápido.");
        produtoMerge.setPreco(new BigDecimal(2000));

        entityManager.getTransaction().begin();
        Produto produtoCopiaMergeGerenciada = entityManager.merge(produtoMerge);
        produtoMerge.setNome("Notebook Dell II");   //não fará efeito porquê é feita uma cópia da instância para ser gerenciada (e só ela é).
        entityManager.getTransaction().commit();

        entityManager.clear();  //se não for executado, o find busca na memória do entity manager.

        Produto produtoMergeVerificar = entityManager.find(Produto.class, produtoMerge.getId());
        Assert.assertNotNull(produtoMergeVerificar);
        Assert.assertEquals("Notebook Dell", produtoMergeVerificar.getNome());
    }

    @Test
    public void impedirOperacaoComBancoDeDados() {
        Produto produto = entityManager.find(Produto.class, 1);
        entityManager.detach(produto);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle Paperwhite Geração 2");
        entityManager.getTransaction().commit();

        entityManager.clear();  //se não for executado, o find busca na memória do entity manager.

        Produto produtoVerificar = entityManager.find(Produto.class, produto.getId());
        Assert.assertEquals("Kindle", produtoVerificar.getNome());
    }
}
