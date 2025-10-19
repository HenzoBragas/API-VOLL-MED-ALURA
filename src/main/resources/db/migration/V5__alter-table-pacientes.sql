UPDATE medicos SET ativos = 1;
ALTER TABLE pacientes ADD COLUMN ativos SMALLINT DEFAULT 1;
