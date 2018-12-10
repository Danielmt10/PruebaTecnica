DROP TABLE IF EXISTS tb_type_users;
DROP TABLE IF EXISTS tb_users;

CREATE TABLE IF NOT EXISTS tb_type_users (
  type_id INT NOT NULL AUTO_INCREMENT,
  type_name VARCHAR(15) NOT NULL,
  CONSTRAINT pk_tpusr PRIMARY KEY (type_id),
);

CREATE TABLE IF NOT EXISTS tb_users (
  user_id VARCHAR(15) NOT NULL,
  pass_user VARCHAR(15) NOT NULL,
  user_name VARCHAR(200) NOT NULL,
  is_active NUMERIC(1) DEFAULT 1 NOT NULL,
  type_id INT NOT NULL,
  CONSTRAINT pk_usr PRIMARY KEY (user_id),
  CONSTRAINT fk_tpsr FOREIGN KEY (type_id) REFERENCES tb_type_users (type_id)
);

insert into tb_type_users (type_name) values ('INVITADO');
insert into tb_type_users (type_name) values ('ADMIN');

insert into tb_users (user_id, pass_user, user_name, is_active, type_id) values ('1017253301','dfsd1fsdf2','JHON JAIRO FICIO',1,1);
insert into tb_users (user_id, pass_user, user_name, is_active, type_id) values ('1017253302','123123dss3','EL NIÑO ATEO',0,1);
insert into tb_users (user_id, pass_user, user_name, is_active, type_id) values ('1017253303','asdasd132ad','EL XHOM',1,2);
