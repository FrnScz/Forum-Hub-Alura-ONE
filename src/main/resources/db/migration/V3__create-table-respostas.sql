create table respostas{
  id int(11) not null auto_increment,
  mensagem varchar(250) not null,
  topico int(11) not null,
  datarcriacao varchar(10) not null,
  autor int(3) not null,
  solucao varchar(250) not null,

  primary key(id)
};