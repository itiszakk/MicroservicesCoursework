CREATE SCHEMA IF NOT EXISTS treatments;

CREATE TABLE IF NOT EXISTS treatments.treatment (
    id SERIAL PRIMARY KEY,
    patient_id INT NOT NULL,
    description TEXT NOT NULL,
    treatment_date DATE NOT NULL
);