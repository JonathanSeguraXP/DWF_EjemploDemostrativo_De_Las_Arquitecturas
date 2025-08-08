
DROP TABLE IF EXISTS books;


CREATE TABLE IF NOT EXISTS books (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     title VARCHAR(255) NOT NULL,
                                     author VARCHAR(255) NOT NULL
);


INSERT INTO books (title, author) VALUES
                                      ('Cien años de soledad', 'Gabriel García Márquez'),
                                      ('1984', 'George Orwell'),
                                      ('El Principito', 'Antoine de Saint-Exupéry');