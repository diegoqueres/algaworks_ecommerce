package com.algaworks.ecommerce.mapeamentoavancao;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.NotaFiscal;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

public class SalvandoArquivosTest extends EntityManagerTest {

    @Test
    public void salvarXmlNota() {
        Pedido pedido = entityManager.find(Pedido.class, 1);

        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setPedido(pedido);
        notaFiscal.setDataEmissao(new Date());
        notaFiscal.setXml(carregarNotaFiscal());

        entityManager.getTransaction().begin();
        entityManager.persist(notaFiscal);
        entityManager.getTransaction().commit();

        entityManager.clear();

        NotaFiscal notaFiscalVerificacao = entityManager.find(NotaFiscal.class, notaFiscal.getId());
        Assert.assertNotNull(notaFiscalVerificacao.getXml());
        Assert.assertTrue(notaFiscalVerificacao.getXml().length > 0);

        /* try {
            OutputStream out = new FileOutputStream(
                    Files.createFile(Paths.get(
                            System.getProperty("user.home") + "/xml.xml")).toFile());
            out.write(notaFiscalVerificacao.getXml());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
    }

    @Test
    public void salvarFotoProduto() {
        Produto produto = entityManager.find(Produto.class, 1);

        produto.setFoto(carregarFotoProduto());

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao.getFoto());
        Assert.assertTrue(produtoVerificacao.getFoto().length > 0);
    }

    private static byte[] carregarNotaFiscal() {
        try {
            return SalvandoArquivosTest.class.getResourceAsStream(
                    "/nota-fiscal.xml").readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] carregarFotoProduto() {
        try {
            return SalvandoArquivosTest.class.getResourceAsStream(
                    "/kindle.jpg").readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
