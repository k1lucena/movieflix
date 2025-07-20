CREATE TABLE users(
    id serial PRIMARY KEY,
    name varchar(200) NOT NULL,
    email varchar(200) NOT NULL,
    password varchar(200) NOT NULL
);