insert into produto (id, nome, preco, data_criacao, descricao) values (1, 'Kindle', 499.0, date_sub(sysdate(), interval 1 day), 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into produto (id, nome, preco, data_criacao, descricao) values (3, 'Câmera GoPro Hero 7', 1400.0, date_sub(sysdate(), interval 1 day), 'Desempenho 2x melhor.');

insert into cliente (id, nome, cpf) values (1, 'Marcio Albuquerque', '343434343434');
insert into cliente (id, nome, cpf) values (2, 'Thomas Epaminondas', '545454545454');
insert into cliente_detalhe (cliente_id, data_nascimento, sexo) values (1, date_sub(sysdate(), interval 27 year), 'MASCULINO');
insert into cliente_detalhe (cliente_id, data_nascimento, sexo) values (2, date_sub(sysdate(), interval 30 year), 'MASCULINO');

insert into pedido (id, cliente_id, data_criacao, total, status) values (1, 1, sysdate(), 998.0, 'AGUARDANDO');
insert into pedido (id, cliente_id, data_criacao, total, status) values (2, 1, sysdate(), 499.0, 'AGUARDANDO');

insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 499, 2);
insert into item_pedido (pedido_id, produto_id, preco_produto, quantidade) values (2, 1, 499, 1);

insert into pagamento (pedido_id, status, tipo_pagamento, numero_cartao, codigo_barras) values (2, 'PROCESSANDO', 'cartao', '5308280517032328', null);

insert into categoria (id, nome) values (1, 'Eletrônicos');