package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class PrimeiroCrudTest extends EntityManagerTest {

    @Test
    public void criandoNovoCliente() {
        Cliente cliente = new Cliente();
        Integer id = 3;
        cliente.setId(id);
        cliente.setNome("Jonas Gav");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Cliente clienteSalvo = entityManager.find(Cliente.class, 3);
        Assert.assertNotNull(clienteSalvo);
        Assert.assertEquals(id, clienteSalvo.getId());
        Assert.assertEquals("Jonas Gav", clienteSalvo.getNome());
    }

    @Test
    public void buscarPorId() {
        Integer id = 1;
        Cliente cliente = entityManager.find(Cliente.class, id);

        Assert.assertNotNull(cliente);
        Assert.assertEquals("Marcio Albuquerque Figueiroa", cliente.getNome());
    }

    @Test
    public void atualizarCliente() {
        Integer id = 1;
        Cliente cliente = entityManager.find(Cliente.class, id);
        cliente.setNome("Marcio Albuquerque Figueiroa");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Cliente clienteSalvo = entityManager.find(Cliente.class, id);
        Assert.assertNotNull(clienteSalvo);
        Assert.assertEquals("Marcio Albuquerque Figueiroa", clienteSalvo.getNome());
    }

    @Test
    public void removerCliente() {
        Integer id = 2;
        Cliente cliente = entityManager.find(Cliente.class, id);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        Cliente clienteSalvo = entityManager.find(Cliente.class, id);
        Assert.assertNull(clienteSalvo);
    }

}


