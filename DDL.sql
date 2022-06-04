create schema agoraVai;

use agoraVai;

create user 'admin'@'localhost' identified by 'admin123';

grant select, insert, delete, update on agoraVai.* to user@'localhost';

create table tbl_usuario (
  userId bigint unsigned not null auto_increment,
  userNome varchar(20) not null,
  userSenha varchar(100) not null,
  primary key (userId),
  unique key uni_usuario_nome (userNome)
);

create table tbl_perfil (
  perfilId bigint unsigned not null auto_increment,
  perfilNome varchar(20) not null,
  primary key (perfilId),
  unique key uni_aut_nome (perfilNome)
);

create table uau_usuario_perfil (
  userId bigint unsigned not null,
  perfilId bigint unsigned not null,
  primary key (userId, perfilId),
  foreign key aut_usuario_fk (userId) references tbl_usuario (userId) on delete restrict on update cascade,
  foreign key aut_perfil_fk (perfilId) references tbl_perfil (perfilId) on delete restrict on update cascade
);

insert into tbl_usuario (userNome, userSenha)
    values ('admin', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');
insert into tbl_perfil (perfilNome)
    values ('ROLE_ADMIN');
insert into uau_usuario_perfil values (1, 1);

insert into tbl_usuario (userNome, userSenha)
    values ('celso', 'admin123');
insert into tbl_perfil (perfilNome)
    values ('ROLE_USUARIO');
insert into uau_usuario_perfil values (2, 1);