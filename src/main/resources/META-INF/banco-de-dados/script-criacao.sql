-- Rodar manualmente para SQL como root (GroupByTest.java)
-- SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

create table testando (id integer not null auto_increment, primary key (id)) engine=InnoDB;

create function acima_media_faturamento(valor double) returns boolean reads sql data return valor > (select avg(total) from pedido);