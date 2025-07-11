create table usuarios(
          id bigint not null auto_increment,
          nombre varchar(100) not null,
          email varchar(100) not null unique,
          contrasenia varchar(255) not null,
          perfil varchar(100) not null,

          primary key(id)
);



create table topicos(
    id bigint not null auto_increment,
    titulo varchar(200) not null,
    mensaje TEXT not null,
    usuario_id bigint not null,
    nombre_curso varchar(100) not null,
    categoria_curso varchar(100) not null,
    fechaCreacion datetime not null,
    state tinyint not null,
    primary key(id),
    constraint fk_topicos_usuario_id foreign key(usuario_id) references usuarios(id)
);


