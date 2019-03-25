use bd_qas_s3;

-- Generated by Oracle SQL Developer Data Modeler 18.3.0.268.1156
--   at:        2019-03-06 11:16:23 BRT
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g

CREATE TABLE controle_aprovacao (
    id                             INT(4) NOT NULL AUTO_INCREMENT,
    id_pedido                      VARCHAR(50) CHARACTER SET ucs2 NOT NULL,
    id_status_controle_aprovacao   INT(4) NOT NULL,
    id_regra                       INT(4) NOT NULL,
    id_usuario                     INT(4),
    id_status_pedido               INT(4) NOT NULL,
    data_aprovacao                 DATE,
    ativo                          CHAR(1),
    CONSTRAINT pk__ctr_apr PRIMARY KEY ( id )
);

CREATE TABLE fluxo_pedido (
    id                      INT(4) NOT NULL,
    id_status_pedido_de     INT(4) NOT NULL,
    id_status_pedido_para   INT(4) NOT NULL,
    bean_validacao          VARCHAR(50),
	aplica_pedido 			BIT(1),
	aplica_orcamento 		BIT(1)
);

ALTER TABLE fluxo_pedido ADD CONSTRAINT pk__flx_ped PRIMARY KEY ( id );

create table status_pedido_regra (

    id_status_pedido int(4) not null,
    id_regra int(4) not null
);

alter table status_pedido_regra add constraint pk__sts_ped__rgr primary key (id_status_pedido, id_regra);

CREATE TABLE regra (
    id          INT(4) NOT NULL,
    descricao   VARCHAR(100),
    ativo       CHAR(1),
	id_perfil	INT(4)
);

ALTER TABLE regra ADD CONSTRAINT pk__rgr PRIMARY KEY ( id );

CREATE TABLE regra_aprovacao_cor (
    id                  INT(4) NOT NULL,
    id_cor_pedido       INT(4) NOT NULL,
    descricao           VARCHAR(100),
    ativo               CHAR(1),
    percentual_inicio   INT(3),
    percentual_fim      INT(3),
	id_perfil			INT(4)
);

ALTER TABLE regra_aprovacao_cor ADD CONSTRAINT pk__rgr_apr_cor PRIMARY KEY ( id );

CREATE TABLE regra_aprovacao_prazo (
    id                   INT(4) NOT NULL,
    id_usuario           INT(4) NOT NULL,
    descricao            VARCHAR(100),
    ativo                CHAR(1),
    numero_dias_inicio   INT(10),
    numero_dias_fim      INT(10),
    dt_inicio            DATE,
    dt_fim               DATE,
    sts_ativo            CHAR(1),
    dt_sincronismo       DATE,
	id_perfil			 INT(4)
);

ALTER TABLE regra_aprovacao_prazo ADD CONSTRAINT pk_rgr_apr_prz PRIMARY KEY ( id );

CREATE TABLE regra_aprovacao_tabela (
    id          INT(4) NOT NULL,
    descricao   VARCHAR(100),
    ativo       CHAR(1),
	id_perfil	INT(4)
);

ALTER TABLE regra_aprovacao_tabela ADD CONSTRAINT pk__rgr_apr_tbl PRIMARY KEY ( id );

ALTER TABLE regras_aprovacao_prazo ADD COLUMN descricao VARCHAR(100);

CREATE TABLE status_controle_aprovacao (
    id          INT(4) NOT NULL,
    descricao   VARCHAR(50)
);

ALTER TABLE status_controle_aprovacao ADD CONSTRAINT pk__sts_ctr_apr PRIMARY KEY ( id );

ALTER TABLE regra
    ADD CONSTRAINT fk__rgr__per FOREIGN KEY ( id_perfil )
        REFERENCES perfil ( id_perfil );
        
ALTER TABLE regra_aprovacao_cor
    ADD CONSTRAINT fk__rgr_apr_cor__per FOREIGN KEY ( id_perfil )
        REFERENCES perfil ( id_perfil );
        
ALTER TABLE regra_aprovacao_prazo
    ADD CONSTRAINT fk__rgr_apr_prz__per FOREIGN KEY ( id_perfil )
        REFERENCES perfil ( id_perfil );
		        
ALTER TABLE regra_aprovacao_tabela
    ADD CONSTRAINT fk__rgr_apr_tbl__per FOREIGN KEY ( id_perfil )
        REFERENCES perfil ( id_perfil );
		
ALTER TABLE controle_aprovacao
    ADD CONSTRAINT fk__ctr_apr__rgr FOREIGN KEY ( id_regra )
        REFERENCES regra ( id );

ALTER TABLE controle_aprovacao
    ADD CONSTRAINT fk__ctr_apr__sts_ctr_apr FOREIGN KEY ( id_status_controle_aprovacao )
        REFERENCES status_controle_aprovacao ( id );

ALTER TABLE controle_aprovacao
    ADD CONSTRAINT fk__ctr_apr__sts_ped FOREIGN KEY ( id_status_pedido )
        REFERENCES status_pedido ( id );

ALTER TABLE controle_aprovacao
    ADD CONSTRAINT fk__ctr_apr__usr FOREIGN KEY ( id_usuario )
        REFERENCES usuario ( id_usuario );

ALTER TABLE fluxo_pedido
    ADD CONSTRAINT fk__flx_ped__flx_sts_ped_de FOREIGN KEY ( id_status_pedido_de )
        REFERENCES status_pedido ( id );

ALTER TABLE fluxo_pedido
    ADD CONSTRAINT fk__flx_ped__flx_sts_ped_para FOREIGN KEY ( id_status_pedido_para )
        REFERENCES status_pedido ( id );

ALTER TABLE regra_aprovacao_cor
    ADD CONSTRAINT fk__rgr_apr_cor__cor_ped FOREIGN KEY ( id_cor_pedido )
        REFERENCES cor_pedido ( id );

ALTER TABLE regra_aprovacao_cor
    ADD CONSTRAINT fk__rgr_apr_cor__rgr FOREIGN KEY ( id )
        REFERENCES regra ( id );
		
ALTER TABLE regra_aprovacao_prazo
    ADD CONSTRAINT fk__rgr_apr_prz__rgr FOREIGN KEY ( id )
        REFERENCES regra ( id );

ALTER TABLE regra_aprovacao_prazo
    ADD CONSTRAINT fk__rgr_apr_prz__usr FOREIGN KEY ( id_usuario )
        REFERENCES usuario ( id_usuario );

ALTER TABLE regra_aprovacao_tabela
    ADD CONSTRAINT fk__rgr_apr_tbl__rgr FOREIGN KEY ( id )
        REFERENCES regra ( id );

alter table status_pedido_regra 
	add constraint fk__sts_ped_rgr__sts_ped foreign key (id_status_pedido) 
		references status_pedido (id);

alter table status_pedido_regra 
	add constraint fk__sts_ped_rgr__rgr foreign key (id_regra) 
		references regra (id);

-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                             9
-- CREATE INDEX                             0
-- ALTER TABLE                             45
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
