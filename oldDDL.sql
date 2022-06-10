drop user 'admin'@'localhost';
drop schema agoraVai;

create schema agoraVai;

use agoraVai;

create user 'admin'@'localhost' identified by 'admin123';

grant select, insert, delete, update on agoraVai.* to admin@'localhost';

create table tbl_usuario (
  user_id bigint unsigned not null auto_increment,
  user_nome varchar(20) not null,
  user_senha varchar(100) not null,
  primary key (user_id),
  unique key uni_usuario_nome (user_nome)
);

create table tbl_perfil (
  perfil_id bigint unsigned not null auto_increment,
  perfil_nome varchar(20) not null,
  primary key (perfil_id),
  unique key uni_aut_nome (perfil_nome)
);

create table uau_usuario_perfil (
  user_id bigint unsigned not null,
  perfil_id bigint unsigned not null,
  primary key (user_id, perfil_id),
  foreign key aut_usuario_fk (user_id) references tbl_usuario (user_id) on delete restrict on update cascade,
  foreign key aut_perfil_fk (perfil_id) references tbl_perfil (perfil_id) on delete restrict on update cascade
);

insert into tbl_usuario (user_nome, user_senha)
    values ('admin', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');
insert into tbl_perfil (perfil_nome)
    values ('ROLE_ADMIN');
insert into uau_usuario_perfil values (1, 1);
