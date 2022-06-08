package com.algaworks.ecommerce.jpql;

import com.algaworks.ecommerce.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.TimeZone;

public class FuncoesTest extends EntityManagerTest {

    @Test
    public void aplicarFuncaoColecao() {
        String jpql = "select size(p.itens) from Pedido p where size(p.itens) > 1";

        TypedQuery<Integer> typedQuery = entityManager.createQuery(jpql, Integer.class);

        List<Integer> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(size -> System.out.println(size));
    }

    @Test
    public void aplicarFuncaoNumero() {
        String jpql = "select abs(-10), mod(p.id, 2), sqrt(9) from Pedido p " +
                "where abs(p.total) > 100";

        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);

        List<Object[]> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(arr -> System.out.println(arr[0] + " | " + arr[1] + " | " + arr[2]));
    }

    @Test
    public void aplicarFuncaoData() {
        // TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        // current_date, current_time, current_timestamp
        // year(p.dataCriacao), month(p.dataCriacao), day(p.dataCriacao)
        // hour(p.dataCriacao), minute(p.dataCriacao), second(p.dataCriacao)

        String jpql = "select hour(p.dataCriacao), minute(p.dataCriacao), second(p.dataCriacao) " +
                "from Pedido p where hour(p.dataCriacao) >= 18";

        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);

        List<Object[]> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(arr -> System.out.println(arr[0] + " | " + arr[1] + " | " + arr[2]));
    }

    @Test
    public void aplicarFuncaoString() {
        // Funções String: concat, length, locate, substring, lower, upper, trim
        //String jpql = "select c.nome, concat('Categoria: ', c.nome) from Categoria c";    //concat
        //String jpql = "select c.nome, length(c.nome) from Categoria c";     //length
        //String jpql = "select c.nome, locate('a', c.nome) from Categoria c";     //locate
        //String jpql = "select c.nome, substring(c.nome, 1, 2) from Categoria c";     //substring
        //String jpql = "select c.nome, lower(c.nome) from Categoria c";     //lower
        //String jpql = "select c.nome, upper(c.nome) from Categoria c";     //upper
        //String jpql = "select c.nome, trim(c.nome) from Categoria c";     //trim

        // Na cláusula WHERE
        //String jpql = "select c.nome, length(c.nome) from Categoria c where length(c.nome) > 10";     //length
        String jpql = "select c.nome, length(c.nome) from Categoria c " +
                "where substring(c.nome, 1, 1) = 'N'";      //substring

        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);

        List<Object[]> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(arr -> System.out.println(arr[0] + ", " + arr[1]));
    }
}
