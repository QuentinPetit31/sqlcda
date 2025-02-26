CREATE DATABASE sqlcda;
USE sqlcda;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    `password` VARCHAR(100) NOT NULL
);
