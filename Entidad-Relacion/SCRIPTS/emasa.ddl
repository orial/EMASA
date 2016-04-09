-- Generado por Oracle SQL Developer Data Modeler 4.1.3.901
--   en:        2016-04-10 01:01:19 CEST
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g




CREATE TABLE ACTUACIONES
  (
    Fecha                     DATE NOT NULL ,
    Operaciones_realizadas    VARCHAR2 (200) NOT NULL ,
    Observaciones             VARCHAR2 (200) ,
    ORD_TRABAJO_Identificador NUMBER NOT NULL ,
    BRIGADA_Num_Brigada       NUMBER NOT NULL
  ) ;
ALTER TABLE ACTUACIONES ADD CONSTRAINT ACTUACIONES_PK PRIMARY KEY ( Fecha, ORD_TRABAJO_Identificador, BRIGADA_Num_Brigada ) ;


CREATE TABLE AVISO
  (
    Codigo               NUMBER NOT NULL ,
    Fecha_Entrada        DATE NOT NULL ,
    Origen               VARCHAR2 (15) NOT NULL ,
    AVISO_Codigo         NUMBER ,
    EMPLEADO_Id_empleado NUMBER ,
    CLIENTE_DNI          VARCHAR2 (12)
  ) ;
ALTER TABLE AVISO ADD CONSTRAINT AVISO_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE BRIGADA
  (
    Num_Brigada NUMBER NOT NULL ,
    Turno       NUMBER NOT NULL ,
    Contrata    CHAR (1) NOT NULL
  ) ;
ALTER TABLE BRIGADA ADD CONSTRAINT BRIGADA_PK PRIMARY KEY ( Num_Brigada ) ;


CREATE TABLE CANTIDAD
  (
    Cantidad                      NUMBER NOT NULL ,
    REPUESTO_Codigo               NUMBER NOT NULL ,
    ACT_Fecha                     DATE NOT NULL ,
    ACT_ORD_TRABAJO_Identificador NUMBER NOT NULL ,
    ACT_BRIGADA_Num_Brigada       NUMBER NOT NULL
  ) ;
ALTER TABLE CANTIDAD ADD CONSTRAINT CANTIDAD_PK PRIMARY KEY ( Cantidad, REPUESTO_Codigo, ACT_Fecha, ACT_ORD_TRABAJO_Identificador, ACT_BRIGADA_Num_Brigada ) ;


CREATE TABLE CLIENTE
  (
    DNI      VARCHAR2 (12) NOT NULL ,
    Nombre   VARCHAR2 (40) NOT NULL ,
    Poliza   NUMBER ,
    Telefono NUMBER ,
    "e-mail" VARCHAR2 (40)
  ) ;
ALTER TABLE CLIENTE ADD CONSTRAINT CLIENTE_PK PRIMARY KEY ( DNI ) ;


CREATE TABLE EMPLEADO
  (
    Id_empleado         NUMBER NOT NULL ,
    Departamento        VARCHAR2 (40) NOT NULL ,
    Turno               NUMBER ,
    BRIGADA_Num_Brigada NUMBER ,
    DNI                 VARCHAR2 (12) NOT NULL ,
    Cargo               VARCHAR2 (20) NOT NULL ,
    Zona                VARCHAR2 (20) ,
    Especialidad        VARCHAR2 (20)
  ) ;
ALTER TABLE EMPLEADO ADD CONSTRAINT EMPLEADO_PK PRIMARY KEY ( Id_empleado ) ;


CREATE TABLE HISTORICO
  (
    AVISO_Codigo         NUMBER NOT NULL ,
    Fecha_actualizacion  DATE NOT NULL ,
    EMPLEADO_Id_empleado NUMBER NOT NULL ,
    Supervisor           NUMBER NOT NULL ,
    Descripcion          VARCHAR2 (200) NOT NULL ,
    Direccion            VARCHAR2 (100) NOT NULL ,
    Estado               VARCHAR2 (20) NOT NULL ,
    Duplicado            NUMBER NOT NULL ,
    Fecha_Cierre         DATE ,
    Tipo_aviso           VARCHAR2 (15) ,
    Causa                VARCHAR2 (50) ,
    Peligrosidad         VARCHAR2 (20) ,
    Ubicacion_GPS        VARCHAR2 (20) ,
    Red_Agua             VARCHAR2 (50) ,
    Doc_adjunto          VARCHAR2 (200)
  ) ;
ALTER TABLE HISTORICO ADD CONSTRAINT HISTORICO_PK PRIMARY KEY ( AVISO_Codigo, Fecha_actualizacion, EMPLEADO_Id_empleado, Supervisor ) ;


CREATE TABLE OBJ_REPARADO
  (
    Codigo                    NUMBER NOT NULL ,
    Ubicacion_tecnica         VARCHAR2 (40) NOT NULL ,
    Diametro                  NUMBER ,
    Profundidad               NUMBER ,
    Longitud                  NUMBER ,
    Presion_nominal           NUMBER ,
    ACTUACIONES_Fecha         DATE NOT NULL ,
    ACTUACIONES_Identificador NUMBER NOT NULL ,
    ACTUACIONES_Num_Brigada   NUMBER NOT NULL
  ) ;
ALTER TABLE OBJ_REPARADO ADD CONSTRAINT OBJ_REPARADO_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE ORD_TRABAJO
  (
    Identificador      NUMBER NOT NULL ,
    Fecha_creacion     DATE NOT NULL ,
    Trabajo_a_realizar VARCHAR2 (200) NOT NULL ,
    Fecha_Finalizacion DATE ,
    AVISO_Codigo       NUMBER NOT NULL ,
    Estado             VARCHAR2 (15) NOT NULL
  ) ;
ALTER TABLE ORD_TRABAJO ADD CONSTRAINT ORD_TRABAJO_PK PRIMARY KEY ( Identificador ) ;


CREATE TABLE REPUESTO
  (
    Codigo      NUMBER NOT NULL ,
    Nombre      VARCHAR2 (40) NOT NULL ,
    Descripción VARCHAR2 (200)
  ) ;
ALTER TABLE REPUESTO ADD CONSTRAINT REPUESTO_PK PRIMARY KEY ( Codigo ) ;


CREATE TABLE VISITAS
  (
    fecha_visita         DATE NOT NULL ,
    EMPLEADO_Id_empleado NUMBER NOT NULL ,
    AVISO_Codigo         NUMBER NOT NULL
  ) ;
ALTER TABLE VISITAS ADD CONSTRAINT VISITAS_PK PRIMARY KEY ( fecha_visita, EMPLEADO_Id_empleado, AVISO_Codigo ) ;


ALTER TABLE ACTUACIONES ADD CONSTRAINT ACTUACIONES_BRIGADA_FK FOREIGN KEY ( BRIGADA_Num_Brigada ) REFERENCES BRIGADA ( Num_Brigada ) ;

ALTER TABLE ACTUACIONES ADD CONSTRAINT ACTUACIONES_ORD_TRABAJO_FK FOREIGN KEY ( ORD_TRABAJO_Identificador ) REFERENCES ORD_TRABAJO ( Identificador ) ;

ALTER TABLE AVISO ADD CONSTRAINT AVISO_AVISO_FK FOREIGN KEY ( AVISO_Codigo ) REFERENCES AVISO ( Codigo ) ;

ALTER TABLE AVISO ADD CONSTRAINT AVISO_CLIENTE_FK FOREIGN KEY ( CLIENTE_DNI ) REFERENCES CLIENTE ( DNI ) ;

ALTER TABLE AVISO ADD CONSTRAINT AVISO_EMPLEADO_FK FOREIGN KEY ( EMPLEADO_Id_empleado ) REFERENCES EMPLEADO ( Id_empleado ) ;

ALTER TABLE CANTIDAD ADD CONSTRAINT CANTIDAD_ACTUACIONES_FK FOREIGN KEY ( ACT_Fecha, ACT_ORD_TRABAJO_Identificador, ACT_BRIGADA_Num_Brigada ) REFERENCES ACTUACIONES ( Fecha, ORD_TRABAJO_Identificador, BRIGADA_Num_Brigada ) ;

ALTER TABLE CANTIDAD ADD CONSTRAINT CANTIDAD_REPUESTO_FK FOREIGN KEY ( REPUESTO_Codigo ) REFERENCES REPUESTO ( Codigo ) ;

ALTER TABLE EMPLEADO ADD CONSTRAINT EMPLEADO_BRIGADA_FK FOREIGN KEY ( BRIGADA_Num_Brigada ) REFERENCES BRIGADA ( Num_Brigada ) ;

ALTER TABLE HISTORICO ADD CONSTRAINT HISTORICO_AVISO_FK FOREIGN KEY ( AVISO_Codigo ) REFERENCES AVISO ( Codigo ) ;

ALTER TABLE HISTORICO ADD CONSTRAINT HISTORICO_EMPLEADO_FK FOREIGN KEY ( EMPLEADO_Id_empleado ) REFERENCES EMPLEADO ( Id_empleado ) ;

ALTER TABLE OBJ_REPARADO ADD CONSTRAINT OBJ_REPARADO_ACTUACIONES_FK FOREIGN KEY ( ACTUACIONES_Fecha, ACTUACIONES_Identificador, ACTUACIONES_Num_Brigada ) REFERENCES ACTUACIONES ( Fecha, ORD_TRABAJO_Identificador, BRIGADA_Num_Brigada ) ;

ALTER TABLE ORD_TRABAJO ADD CONSTRAINT ORD_TRABAJO_AVISO_FK FOREIGN KEY ( AVISO_Codigo ) REFERENCES AVISO ( Codigo ) ;

ALTER TABLE VISITAS ADD CONSTRAINT VISITAS_AVISO_FK FOREIGN KEY ( AVISO_Codigo ) REFERENCES AVISO ( Codigo ) ;

ALTER TABLE VISITAS ADD CONSTRAINT VISITAS_EMPLEADO_FK FOREIGN KEY ( EMPLEADO_Id_empleado ) REFERENCES EMPLEADO ( Id_empleado ) ;


-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            11
-- CREATE INDEX                             0
-- ALTER TABLE                             25
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
