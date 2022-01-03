CREATE DATABASE viladevinhouse;

CREATE TABLE role(
	id SERIAL PRIMARY KEY,
	role VARCHAR(128) NOT NULL UNIQUE
);


CREATE TABLE app_user(
	id SERIAL PRIMARY KEY,
	username VARCHAR(128) NOT NULL UNIQUE,
	password VARCHAR(256) NOT NULL,
	role_id INT DEFAULT '1',
	FOREIGN KEY (role_id) REFERENCES role (id)
);



CREATE TABLE villager(
	id SERIAL PRIMARY KEY,
	name VARCHAR(256) NOT NULL,
	surname VARCHAR(256) NOT NULL,
	birthday DATE NOT NULL,
	income DECIMAL DEFAULT '0',
	cpf VARCHAR(256) UNIQUE DEFAULT 'Não Possui',
	appuser_id Integer NOT NULL UNIQUE,
	FOREIGN KEY (appuser_id) REFERENCES app_user(id)

);

INSERT INTO role (role) VALUES ('user'), ('administrator');

INSERT INTO app_user (username, password, role_id) 
VALUES ('administrator@viladevinhouse.com', 'admin', 2);

INSERT INTO villager (name, surname, birthday, income, cpf, appuser_id)
VALUES ('Jhon', 'Doe', '1989-12-31', 18000.00, '987.654.321-00', 1);