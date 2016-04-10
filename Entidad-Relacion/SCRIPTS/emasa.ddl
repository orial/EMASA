-- Generado por Oracle SQL Developer Data Modeler 4.1.3.901
--   en:        2016-04-10 12:41:31 CEST
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g




CREATE TABLE ACTUACIONES
  (
    Fecha_actuacion DATE NOT NULL ,
    Oper_realizadas VARCHAR2 (200) NOT NULL ,
    Observaciones   VARCHAR2 (200) ,
    Id_orden        NUMBER NOT NULL ,
    Num_Brigada     NUMBER NOT NULL
  ) ;
ALTER TABLE ACTUACIONES ADD CONSTRAINT ACTUACIONES_PK PRIMARY KEY ( Fecha_actuacion, Id_orden, Num_Brigada ) ;


CREATE TABLE AVISO
  (
    Id_aviso      NUMBER NOT NULL ,
    Fecha_Entrada DATE NOT NULL ,
    Origen        VARCHAR2 (15) NOT NULL ,
    Id_empleado   NUMBER ,
    CLIENTE_DNI   VARCHAR2 (12) ,
    Relacionado   NUMBER
  ) ;
ALTER TABLE AVISO ADD CONSTRAINT AVISO_PK PRIMARY KEY ( Id_aviso ) ;


CREATE TABLE BRIGADA
  (
    Num_Brigada NUMBER NOT NULL ,
    Turno       NUMBER NOT NULL ,
    Contrata    CHAR (1) NOT NULL
  ) ;
ALTER TABLE BRIGADA ADD CONSTRAINT BRIGADA_PK PRIMARY KEY ( Num_Brigada ) ;


CREATE TABLE CANTIDAD
  (
    Cantidad        NUMBER NOT NULL ,
    Id_repuesto     NUMBER NOT NULL ,
    Fecha_actuacion DATE NOT NULL ,
    Id_orden        NUMBER NOT NULL ,
    Num_Brigada     NUMBER NOT NULL
  ) ;
ALTER TABLE CANTIDAD ADD CONSTRAINT CANTIDAD_PK PRIMARY KEY ( Cantidad, Id_repuesto, Fecha_actuacion, Id_orden, Num_Brigada ) ;


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
    Id_empleado  NUMBER NOT NULL ,
    DNI          VARCHAR2 (12) NOT NULL ,
    Nombre       VARCHAR2 (15) NOT NULL ,
    Apellidos    VARCHAR2 (30) NOT NULL ,
    Departamento VARCHAR2 (40) NOT NULL ,
    Cargo        VARCHAR2 (20) NOT NULL ,
    Turno        NUMBER NOT NULL ,
    Zona         VARCHAR2 (20) ,
    Especialidad VARCHAR2 (20) ,
    Num_Brigada  NUMBER
  ) ;
ALTER TABLE EMPLEADO ADD CONSTRAINT EMPLEADO_PK PRIMARY KEY ( Id_empleado ) ;


CREATE TABLE HISTORICO
  (
    Id_aviso            NUMBER NOT NULL ,
    Fecha_actualizacion DATE NOT NULL ,
    Id_empleado         NUMBER NOT NULL ,
    Supervisor          NUMBER NOT NULL ,
    Descripcion         VARCHAR2 (200) NOT NULL ,
    Direccion           VARCHAR2 (100) NOT NULL ,
    Estado              VARCHAR2 (20) NOT NULL ,
    Duplicado           NUMBER NOT NULL ,
    Fecha_Cierre        DATE ,
    Tipo_aviso          VARCHAR2 (15) ,
    Causa               VARCHAR2 (50) ,
    Peligrosidad        VARCHAR2 (20) ,
    Ubicacion_GPS       VARCHAR2 (20) ,
    Red_Agua            VARCHAR2 (50) ,
    Doc_adjunto         VARCHAR2 (200)
  ) ;
ALTER TABLE HISTORICO ADD CONSTRAINT HISTORICO_PK PRIMARY KEY ( Id_aviso, Fecha_actualizacion, Id_empleado, Supervisor ) ;


CREATE TABLE ORD_TRABAJO
  (
    Id_orden           NUMBER NOT NULL ,
    Fecha_creacion     DATE NOT NULL ,
    Trabajo_a_realizar VARCHAR2 (200) NOT NULL ,
    Estado             VARCHAR2 (15) NOT NULL ,
    Fecha_Finalizacion DATE ,
    Id_aviso           NUMBER NOT NULL
  ) ;
ALTER TABLE ORD_TRABAJO ADD CONSTRAINT ORD_TRABAJO_PK PRIMARY KEY ( Id_orden ) ;


CREATE TABLE REPARACION
  (
    Id_reparacion     NUMBER NOT NULL ,
    Ubicacion_tecnica VARCHAR2 (40) NOT NULL ,
    Diametro          NUMBER ,
    Profundidad       NUMBER ,
    Longitud          NUMBER ,
    Presion_nominal   NUMBER ,
    Fecha_actuacion   DATE NOT NULL ,
    Id_orden          NUMBER NOT NULL ,
    Num_Brigada       NUMBER NOT NULL
  ) ;
ALTER TABLE REPARACION ADD CONSTRAINT REPARACION_PK PRIMARY KEY ( Id_reparacion ) ;


CREATE TABLE REPUESTO
  (
    Id_repuesto NUMBER NOT NULL ,
    Nombre      VARCHAR2 (40) NOT NULL ,
    Descripción VARCHAR2 (200)
  ) ;
ALTER TABLE REPUESTO ADD CONSTRAINT REPUESTO_PK PRIMARY KEY ( Id_repuesto ) ;


CREATE TABLE VISITAS
  (
    Fecha_visita DATE NOT NULL ,
    Id_empleado  NUMBER NOT NULL ,
    Id_aviso     NUMBER NOT NULL
  ) ;
ALTER TABLE VISITAS ADD CONSTRAINT VISITAS_PK PRIMARY KEY ( Fecha_visita, Id_empleado, Id_aviso ) ;


ALTER TABLE ACTUACIONES ADD CONSTRAINT ACTUACIONES_BRIGADA_FK FOREIGN KEY ( Num_Brigada ) REFERENCES BRIGADA ( Num_Brigada ) ;

ALTER TABLE ACTUACIONES ADD CONSTRAINT ACTUACIONES_ORD_TRABAJO_FK FOREIGN KEY ( Id_orden ) REFERENCES ORD_TRABAJO ( Id_orden ) ;

ALTER TABLE AVISO ADD CONSTRAINT AVISO_AVISO_FK FOREIGN KEY ( Relacionado ) REFERENCES AVISO ( Id_aviso ) ;

ALTER TABLE AVISO ADD CONSTRAINT AVISO_CLIENTE_FK FOREIGN KEY ( CLIENTE_DNI ) REFERENCES CLIENTE ( DNI ) ;

ALTER TABLE AVISO ADD CONSTRAINT AVISO_EMPLEADO_FK FOREIGN KEY ( Id_empleado ) REFERENCES EMPLEADO ( Id_empleado ) ;

ALTER TABLE CANTIDAD ADD CONSTRAINT CANTIDAD_ACTUACIONES_FK FOREIGN KEY ( Fecha_actuacion, Id_orden, Num_Brigada ) REFERENCES ACTUACIONES ( Fecha_actuacion, Id_orden, Num_Brigada ) ;

ALTER TABLE CANTIDAD ADD CONSTRAINT CANTIDAD_REPUESTO_FK FOREIGN KEY ( Id_repuesto ) REFERENCES REPUESTO ( Id_repuesto ) ;

ALTER TABLE EMPLEADO ADD CONSTRAINT EMPLEADO_BRIGADA_FK FOREIGN KEY ( Num_Brigada ) REFERENCES BRIGADA ( Num_Brigada ) ;

ALTER TABLE HISTORICO ADD CONSTRAINT HISTORICO_AVISO_FK FOREIGN KEY ( Id_aviso ) REFERENCES AVISO ( Id_aviso ) ;

ALTER TABLE HISTORICO ADD CONSTRAINT HISTORICO_EMPLEADO_FK FOREIGN KEY ( Id_empleado ) REFERENCES EMPLEADO ( Id_empleado ) ;

ALTER TABLE ORD_TRABAJO ADD CONSTRAINT ORD_TRABAJO_AVISO_FK FOREIGN KEY ( Id_aviso ) REFERENCES AVISO ( Id_aviso ) ;

ALTER TABLE REPARACION ADD CONSTRAINT REPARACION_ACTUACIONES_FK FOREIGN KEY ( Fecha_actuacion, Id_orden, Num_Brigada ) REFERENCES ACTUACIONES ( Fecha_actuacion, Id_orden, Num_Brigada ) ;

ALTER TABLE VISITAS ADD CONSTRAINT VISITAS_AVISO_FK FOREIGN KEY ( Id_aviso ) REFERENCES AVISO ( Id_aviso ) ;

ALTER TABLE VISITAS ADD CONSTRAINT VISITAS_EMPLEADO_FK FOREIGN KEY ( Id_empleado ) REFERENCES EMPLEADO ( Id_empleado ) ;


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
