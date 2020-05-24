Trabalho sobre api de filmes

Configurações dos Dockes usados:

sudo docker run --name postgres -e POSTGRES_PASSWORD=123456789 -v /home/ubuntu/postgres:/var/lib/postgresql/data -p 5432:5432 -d postgres

sudo docker run --name adminer --link postgres:db -p 8082:8080 -d adminer


Informações do Banco criado:

CREATE TABLE filme (
    id BIGSERIAL NOT NULL,
    titulo VARCHAR(255) UNIQUE NOT NULL,
    sinopse TEXT NOT NULL,
    lancamento NUMERIC(4,0) NOT NULL,
    produtores TEXT NOT NULL,
    artistas TEXT NOT null,    
	PRIMARY KEY (id)
);

CREATE TABLE avaliacao (
    id BIGSERIAL NOT NULL,
    usuario VARCHAR(255) NOT NULL,
    comentario VARCHAR(255) NOT NULL,
    voto NUMERIC(1,0) NOT NULL,
    idFilme BIGINT NOT null,
	PRIMARY KEY (id),
	FOREIGN KEY (idFilme) REFERENCES filme(id)
)
