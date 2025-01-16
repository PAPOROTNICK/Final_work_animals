CREATE database FriendsOfHuman;
use FriendsOfHuman;


CREATE TABLE Animals (
id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

INSERT INTO Animals (name) VALUES 
('PetAnimals'),
('PackAnimals');



CREATE TABLE PetAnimals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

INSERT INTO PetAnimals (name) VALUES 
('Cat'),
('Dog'),
('Hamster');


CREATE TABLE Cat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    type ENUM('Cat'),
    birth_date DATE,
    commands VARCHAR(255),
    category VARCHAR(255) DEFAULT 'Домашние'
);

INSERT INTO Cat (name, type, birth_date, commands) VALUES 
('Max','Cat','2024-05-20','jumping'),
('Jaison','Cat','2024-11-10','sitting'),
('Bob','Cat','2022-06-20','purrs');


CREATE TABLE Dog (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    type ENUM('Dog'),
    birth_date DATE,
    commands VARCHAR(255),
    category VARCHAR(255) DEFAULT 'Домашние'
);

INSERT INTO Dog (name, type, birth_date, commands) VALUES 
('Max','Dog','2021-05-20','barks'),
('Jaison','Dog','2023-03-10','jumping'),
('Bob','Dog','2022-08-20','eats');


CREATE TABLE Hamster (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    type ENUM('Hamster'),
    birth_date DATE,
    commands VARCHAR(255),
    category VARCHAR(255) DEFAULT 'Домашние'
);

INSERT INTO Hamster (name, type, birth_date, commands) VALUES 
('Dima','Hamster','2024-01-20','runs in a wheel'),
('Jakson','Hamster','2021-04-10','digs know'),
('Bib','Hamster','2024-05-20','sleeping');


CREATE TABLE PackAnimals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);
INSERT INTO PackAnimals (name) VALUES 
('Horse'),
('Camel'),
('Donkey');

CREATE TABLE Horse (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    type ENUM('Horse'),
    birth_date DATE,
    commands VARCHAR(255),
    category VARCHAR(255) DEFAULT 'Вьючные'
);


CREATE TABLE Camel (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    type ENUM('Camel'),
    birth_date DATE,
    commands VARCHAR(255),
    category VARCHAR(255) DEFAULT 'Вьючные'
);


CREATE TABLE Donkey (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    type ENUM('Donkey'),
    birth_date DATE,
    commands VARCHAR(255),
    category VARCHAR(255) DEFAULT 'Вьючные'
);

INSERT INTO Horse (name, type, birth_date, commands) VALUES 
('Dana','Horse','2022-06-21','jump'),
('Kira','Horse','2020-08-15','sleeping'),
('Gib','Horse','2021-02-23','walking');

INSERT INTO Camel (name, type, birth_date, commands) VALUES 
('Dima','Camel','2023-07-27','drinks water'),
('Jakson','Camel','2023-04-11','sleeping'),
('Bib','Camel','2024-02-21','walking');

INSERT INTO Donkey (name, type, birth_date, commands) VALUES 
('Dina','Donkey','2024-04-22','sitting'),
('Clark','Donkey','2020-04-16','sitting'),
('Bobi','Donkey','2018-05-28','sitting');


DELETE FROM Camel WHERE id > 0;


CREATE TABLE HorsesAndDonkeys AS
SELECT id, name, type, birth_date, category
FROM Horse
UNION ALL
SELECT id, name, type, birth_date, category
FROM Donkey;


CREATE TABLE YoungAnimals AS
SELECT 
    id,
    name,
    type,
    birth_date,
    category,
    TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) AS age_in_months
FROM (
    SELECT id, name, type, birth_date, category FROM Cat
    UNION ALL
    SELECT id, name, type, birth_date, category FROM Dog
    UNION ALL
    SELECT id, name, type, birth_date, category FROM Hamster
    UNION ALL
    SELECT id, name, type, birth_date, category FROM Horse
    UNION ALL
    SELECT id, name, type, birth_date, category FROM Donkey
) AS AllAnimals
WHERE TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) >= 1
  AND TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) < 3;


CREATE TABLE AllAnimals AS
SELECT 
    id,
    name,
    type,
    birth_date,
    category,
    'Cat' AS origin_table
FROM Cat
UNION ALL
SELECT 
    id,
    name,
    type,
    birth_date,
    category,
    'Dog' AS origin_table
FROM Dog
UNION ALL
SELECT 
    id,
    name,
    type,
    birth_date,
    category,
    'Hamster' AS origin_table
FROM Hamster
UNION ALL
SELECT 
    id,
    name,
    type,
    birth_date,
    category,
    'Horse' AS origin_table
FROM Horse
UNION ALL
SELECT 
    id,
    name,
    type,
    birth_date,
    category,
    'Donkey' AS origin_table
FROM Donkey;
