-- regras prazo

insert into regra (id, descricao, ativo, id_perfil)
select id_regra_prazo, 'Prazo de Pagamento', sts_ativo, null from regras_aprovacao_prazo;

insert into regra_aprovacao_prazo 
(id, id_usuario, descricao, ativo, numero_dias_inicio, numero_dias_fim, data_inicio, data_fim, sts_ativo, dt_sicronismo, id_perfil)
select id_regra_prazo, id_usuario_aprovador, 'Prazo de Pagamento', sts_ativo, num_dias_ini, num_dias_fim, dt_ini, dt_fim, sts_ativo,dt_sincronismo, null 
from regras_aprovacao_prazo;

insert into status_pedido_regra (id_status_pedido, id_regra)
select 16, id from regra;

-- grava ultimo id

set @next_id := (select max(id) from regra);

-- regras cor

-- Aprovação Gerente Regional

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 1);
INSERT INTO regra_aprovacao_cor 
SELECT id, 5, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(2, @next_id);

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 1);
INSERT INTO regra_aprovacao_cor 
SELECT id, 4, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(2, @next_id);

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 1);
INSERT INTO regra_aprovacao_cor 
SELECT id, 2, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(2, @next_id);

-- Aprovação Gerente Comercial

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 2);
INSERT INTO regra_aprovacao_cor 
SELECT id, 5, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(3, @next_id);

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 2);
INSERT INTO regra_aprovacao_cor 
SELECT id, 4, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(3, @next_id);

-- Aprovação Diretor Comercial

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 3);
INSERT INTO regra_aprovacao_cor 
SELECT id, 5, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(4, @next_id);

-- Aprovação Adm Vendas

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 5);
INSERT INTO regra_aprovacao_cor 
SELECT id, 5, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(8, @next_id);

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 5);
INSERT INTO regra_aprovacao_cor 
SELECT id, 4, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(8, @next_id);

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 5);
INSERT INTO regra_aprovacao_cor 
SELECT id, 2, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(8, @next_id);

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 5);
INSERT INTO regra_aprovacao_cor 
SELECT id, 3, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(8, @next_id);

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 5);
INSERT INTO regra_aprovacao_cor 
SELECT id, 1, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(8, @next_id);

-- Aprovação Supera GMT

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 20);
INSERT INTO regra_aprovacao_cor 
SELECT id, 5, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(19, @next_id);

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 20);
INSERT INTO regra_aprovacao_cor 
SELECT id, 4, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(19, @next_id);

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 20);
INSERT INTO regra_aprovacao_cor 
SELECT id, 2, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(19, @next_id);

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 20);
INSERT INTO regra_aprovacao_cor 
SELECT id, 3, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(19, @next_id);

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 20);
INSERT INTO regra_aprovacao_cor 
SELECT id, 1, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(19, @next_id);

-- Aprovação Bonificação Diretor

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 7);
INSERT INTO regra_aprovacao_cor 
SELECT id, 5, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(20, @next_id);

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 7);
INSERT INTO regra_aprovacao_cor 
SELECT id, 4, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(20, @next_id);

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 7);
INSERT INTO regra_aprovacao_cor 
SELECT id, 2, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(20, @next_id);

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 7);
INSERT INTO regra_aprovacao_cor 
SELECT id, 3, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(20, @next_id);

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Cor', true, 7);
INSERT INTO regra_aprovacao_cor 
SELECT id, 1, r.descricao, r.ativo, 0, 100, r.id_perfil FROM regra r where r.id = @next_id;

insert into status_pedido_regra (id_status_pedido, id_regra)
values(20, @next_id);

-- regras bean

-- regra A.R

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'A.R.', true, 8);

insert into status_pedido_regra (id_status_pedido, id_regra)
values(6, @next_id);

-- aprovação gerente de distribuição (agenciamento)

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Agenciamento', true, 4);

insert into status_pedido_regra (id_status_pedido, id_regra)
values(5, @next_id);

-- aprovação Supera

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Programa Supera', true, 12);

insert into status_pedido_regra (id_status_pedido, id_regra)
values(14, @next_id);

-- aprovação Bonificação GP

set @next_id := @next_id +1;

INSERT INTO regra VALUES (@next_id, 'Bonificação', true, 13);

insert into status_pedido_regra (id_status_pedido, id_regra)
values(15, @next_id);