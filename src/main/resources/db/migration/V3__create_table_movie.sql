CREATE TABLE movie(
    id serial PRIMARY KEY,
    title varchar(200) NOT NULL,
    description text,
    release_date date,
    rating numeric,
    created_at timestamp,
    updated_at timestamp
);