CREATE SCHEMA IF NOT EXISTS seizures;

CREATE TABLE IF NOT EXISTS seizures.seizure (
    id SERIAL PRIMARY KEY,
    patient_id INT NOT NULL,
    description TEXT NOT NULL,
    seizure_date DATE NOT NULL
);