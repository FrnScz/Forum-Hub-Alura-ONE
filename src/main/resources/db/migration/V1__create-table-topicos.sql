create table topicos{
  id int(11) not null auto_increment,
  titulo varchar(100) not null,
  mensagem varchar(250) not null,
  datatopico varchar(10) not null,
  statustopico varchar(10) not null,
  autor int(3) not null,
  curso varchar(50) not null,
  respostas varchar(250) not null,

  primary key(id)
};