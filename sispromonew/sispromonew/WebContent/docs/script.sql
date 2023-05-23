drop database dbsispromonew;
create database dbsispromonew  
CHARACTER SET utf8 COLLATE utf8_general_ci;

use dbsispromonew;
create table cliente(
    id int auto_increment primary key,
    nome varchar(50),
    cnpj varchar(50) DEFAULT NULL,
    cep varchar(50) DEFAULT NULL,
    endereco varchar(50) DEFAULT NULL,
    numero varchar(50) DEFAULT NULL,
    complemento varchar(50) DEFAULT NULL,
    bairro varchar(50) DEFAULT NULL,
    cidade varchar(50) DEFAULT NULL,
    uf varchar(50)) DEFAULT NULL,
    FOREIGN KEY (idpromotor) REFERENCES promotor(id),
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
    
create TABLE promotor(
    id int AUTO_INCREMENT PRIMARY key,
    nome varchar(50) DEFAULT NULL,
    cpf varchar(50) DEFAULT NULL,
    telefone varchar(50) DEFAULT NULL,
    login varchar(50) DEFAULT NULL,
    senha varchar(50) DEFAULT NULL,
    idcliente int DEFAULT NULL,
);

CREATE TABLE registros (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  clienteID INT NOT NULL,
  promotorID INT NOT NULL,
  dataCheckin TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  dataCheckout TIMESTAMP NULL DEFAULT NULL,
  FOREIGN KEY (clienteID) REFERENCES cliente(ID),
  FOREIGN KEY (promotorID) REFERENCES promotor(ID)
);


