CREATE SCHEMA IF NOT EXISTS patients;

CREATE TABLE IF NOT EXISTS patients.patient (
    id SERIAL PRIMARY KEY,
    last_name TEXT NOT NULL,
    first_name TEXT NOT NULL,
    patronymic TEXT,
    birthdate DATE NOT NULL
);