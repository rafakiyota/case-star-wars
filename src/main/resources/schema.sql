DROP TABLE IF EXISTS busca;
  
CREATE TABLE busca (
  id INT AUTO_INCREMENT PRIMARY KEY,
  dominio VARCHAR(255) NOT NULL,
  termo VARCHAR(255) NOT NULL,
  quantidade INT NOT NULL
);