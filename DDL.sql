drop user 'user'@'localhost';
drop schema agoravai;
create schema agoravai;

use agoravai;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on agoravai.* to user@'localhost';

create table usr_usuario (
  usr_id bigint unsigned not null auto_increment,
  usr_nome varchar(20) not null,
  usr_senha varchar(100) not null,
  primary key (usr_id),
  unique key uni_usuario_nome (usr_nome)
);

create table aut_autorizacao (
  aut_id bigint unsigned not null auto_increment,
  aut_nome varchar(20) not null,
  primary key (aut_id),
  unique key uni_aut_nome (aut_nome)
);

create table uau_usuario_autorizacao (
  usr_id bigint unsigned not null,
  aut_id bigint unsigned not null,
  primary key (usr_id, aut_id),
  foreign key aut_usuario_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade,
  foreign key aut_autorizacao_fk (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);

create table ant_trabalho (
  ant_id bigint unsigned not null auto_increment,
  ant_titulo varchar(20) not null,
  ant_texto varchar(100) not null,
  primary key (ant_id),
  unique key ant_trabalho_titulo (ant_titulo)
);

create table alu_aluno (
  alu_id bigint unsigned not null auto_increment,
  alu_nome varchar(100) not null,
  alu_p1 varchar(5) not null,
  alu_p2 varchar(5) not null,
  alu_trabalho varchar(100) not null,
  primary key (alu_id),
  unique key alu_aluno_nome (alu_nome)
);



insert into usr_usuario (usr_nome, usr_senha)
    values ('admin', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');
insert into aut_autorizacao (aut_nome)
    values ('ROLE_ADMIN');

  insert into usr_usuario (usr_nome, usr_senha)
    values ('user', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');
insert into aut_autorizacao (aut_nome)
    values ('ROLE_USUARIO');
insert into uau_usuario_autorizacao values (1, 1);
insert into uau_usuario_autorizacao values (2, 2);

insert into ant_trabalho (ant_titulo, ant_texto)
    values ('teste', 'teste');