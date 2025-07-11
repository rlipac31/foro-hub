ALTER TABLE topicos
CHANGE COLUMN nombre_curso nombreCurso VARCHAR(100) NOT NULL,
CHANGE COLUMN categoria_curso categoriaCurso VARCHAR(100) NOT NULL;