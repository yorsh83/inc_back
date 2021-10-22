SELECT * FROM inc_pos_upload WHERE id_incident = 'INC000005194837';LIKE '%95';
SELECT * FROM inc_pos_kanban;
SELECT COUNT(*) FROM inc_pos_kanban WHERE status_kanban = 5;
SELECT * FROM inc_pos_kanban WHERE status_kanban = 1;
SELECT COUNT(NULL) FROM inc_pos_upload;
SELECT COUNT(USUARIO) FROM inc_pos_upload;
SELECT COUNT(*) FROM inc_pos_upload WHERE usuario != '';
SELECT * FROM INC_POS_KANBAN WHERE ID_INCIDENT = 'INC000004119495';
SELECT ipu.ID, ipu.ID_INCIDENT FROM inc_pos_upload ipu JOIN inc_pos_kanban ipk ON ipu.ID_INCIDENT = ipk.id_incident WHERE ipk.ID_INCIDENT = 'INC000004629957';
SELECT id_incident, usuario FROM inc_pos_upload WHERE usuario LIKE '%';
DELETE FROM inc_pos_upload WHERE ID = 5;
DELETE FROM inc_pos_kanban WHERE ID = 15;

INSERT INTO inc_pos_reporte(id_reporte, resueltos, pedientes, procesos)values(seq_report_test.currval,10,25,5);
INSERT INTO inc_pos_cat_kanban(id, id_kanban, name_kanban)values(seq_cat_kanban.currval,'5','retrospectiva');

UPDATE INC_POS_KANBAN SET detail = 'este es un ejemplo donde el usuario va a escribir el detalle' WHERE id = 1;
UPDATE INC_POS_KANBAN SET STATUS_KANBAN = '2' WHERE id = 7;

DROP TABLE inc_pos_upload;
DROP TABLE inc_pos_kanban;
DROP TABLE inc_pos_reporte;

CREATE SEQUENCE seq_upload
START WITH
1 INCREMENT BY 1 MINVALUE 1;

CREATE SEQUENCE seq_kanban
START WITH
1 INCREMENT BY 1 MINVALUE 1;

DROP SEQUENCE seq_upload;
DROP SEQUENCE seq_kanban;
DROP SEQUENCE seq_report;

SELECT seq_cat_kanban.nextval FROM dual;
SELECT seq_cat_kanban.currval FROM dual;
