CREATE TABLE controle_aprovacao_pedido_item (
    id                             INT(4) NOT NULL AUTO_INCREMENT,
	id_pedido_item                 VARCHAR(50) CHARACTER SET ucs2 NOT NULL,
    id_usuario                     INT(4),
    id_status_pedido               INT(4) NOT NULL,
    data_aprovacao                 DATE,
    ativo                          CHAR(1),
    CONSTRAINT pk__ctr_apr_ped_itm PRIMARY KEY ( id )
);

ALTER TABLE controle_aprovacao_pedido_item
    ADD CONSTRAINT fk__ctr_apr_ped_itm__ped_itm FOREIGN KEY ( id_pedido_item )
        REFERENCES pedido_item ( id_pedido_item );

ALTER TABLE controle_aprovacao_pedido_item
    ADD CONSTRAINT fk__ctr_apr_ped_itm__sts_ped FOREIGN KEY ( id_status_pedido )
        REFERENCES status_pedido ( id );

ALTER TABLE controle_aprovacao_pedido_item
    ADD CONSTRAINT fk__ctr_apr_ped_itm__usr FOREIGN KEY ( id_usuario )
        REFERENCES usuario ( id_usuario );
		
--drop table controle_aprovacao_pedido_item