-- Borra la tabla si ya existe (opcional, solo para desarrollo)
DROP TABLE IF EXISTS books;

-- Crea la tabla con la estructura correcta
CREATE TABLE IF NOT EXISTS books (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     title VARCHAR(255) NOT NULL,
                                     author VARCHAR(255) NOT NULL,
                                     is_read BOOLEAN DEFAULT FALSE  -- Nombre de columna que coincide con @Column(name = "is_read")
);

-- Inserta datos de ejemplo (usando el nombre de columna correcto: is_read)
INSERT INTO books (title, author, is_read) VALUES
                                               ('Cien años de soledad', 'Gabriel García Márquez', false),
                                               ('1984', 'George Orwell', true),
                                               ('El Principito', 'Antoine de Saint-Exupéry', false);