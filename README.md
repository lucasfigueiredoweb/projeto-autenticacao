# Autenticacao-Controle-de-Sessao
JAVA / Vraptor / Maven

# Tabela de Usuario

create table usuario (
	id bigserial,
	nome text not null,
	login text not null,
	senha text not null,
	constraint pk_usuario primary key (id)
);

Lembre-se de Configurar 1 Insert na tabela de Usuario!
