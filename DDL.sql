create schema agoravai;

use agoravai;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on agoravai.* to user@'localhost';

create table usr_usuario (
  usr_id bigint unsigned not null auto_increment,
  usr_nome varchar(20) not null,
  usr_senha varchar(100) not null,
  usr_role varchar(10) not null,
  primary key (usr_id),
  unique key uni_usuario_nome (usr_nome)
  
);
create table frases(
  frase_id bigint unsigned not null auto_increment,
  frase_text varchar(300) not null,
  frase_autor varchar (100) not null,
  frase_autorProfissao varchar (100) not null,
  frase_usuario varchar (100) not null,
  frase_fonte varchar (100) not null,
  frase_categoria varchar (50) not null,
  frase_data varchar (10) not null,
)
insert into usr_usuario (usr_nome, usr_senha,usr_role)
    values ('admin', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C','admin');
insert into usr_usuario (usr_nome, usr_senha,usr_role)
    values ('celso', 'celso','user');
insert into frase (frase_text, frase_autor, frase_autorProfissao,frase_usuario,frase_fonte,frase_categoria,frase_data)
  values ('Bem vindo ao caos.','Celso Reis','Pré-dev','admin','aleatoria','Observações diarias','12/04/2022')
-- create table aut_autorizacao (
--   aut_id bigint unsigned not null auto_increment,
--   aut_nome varchar(20) not null,
--   primary key (aut_id),
--   unique key uni_aut_nome (aut_nome)
-- );

-- create table uau_usuario_autorizacao (
--   usr_id bigint unsigned not null,
--   aut_id bigint unsigned not null,
--   primary key (usr_id, aut_id),
--   foreign key aut_usuario_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade,
--   foreign key aut_autorizacao_fk (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
-- );

-- insert into usr_usuario (usr_nome, usr_senha)
--     values ('admin', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');
-- insert into aut_autorizacao (aut_nome)
--     values ('ROLE_ADMIN');
-- insert into uau_usuario_autorizacao values (1, 1);