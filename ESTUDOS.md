
# ESTUDOS - Anotações
Challenge 03 - ONE - Oracle Next Education

        <dependency>
			<groupId>org.flywaydb</groupId>
			<artifactId>flyway-core</artifactId>
		</dependency>
		<dependency>
			<groupId>org.flywaydb</groupId>
			<artifactId>flyway-mysql</artifactId>
		</dependency>


        @Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}

server.port=2500
spring.application.name=forumhub
spring.datasource.url=jdbc:postgresql://localhost:5432/one_literalura
spring.datasource.username=postgres
spring.datasource.password=root
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.HSQLDialect

traduzir os parametros da paginacao
spring.data.web.pageable.page-parameter=pagina
spring.data.web.pageable.size-parameter=tamanho
spring.data.web.sort.sort-parameter=ordem

server.error.include-stacktrace=never

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

create table respostas{
  id int(11) not null auto_increment,
  mensagem varchar(250) not null,
  topico int(11) not null,
  dataresposta varchar(10) not null,
  autor int(3) not null,
  resposta varchar(250) not null,

  primary key(id)
};


CREATE TABLE springforumweb.usuarios (
	id int(3) auto_increment NOT null primary key,
    login varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	senha varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
);

CREATE TABLE springforumweb.respostas (
	id int(11) auto_increment NOT null primary key,
    mensagem varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    topico int(11) NOT NULL,
    dataresposta varchar(10) NOT NULL,
    autor int(11) NOT NULL,
	resposta varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
);