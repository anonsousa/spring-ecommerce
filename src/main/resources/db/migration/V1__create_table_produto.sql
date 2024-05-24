CREATE TABLE tbl_produto (
    id_produto UUID PRIMARY KEY,
    nome varchar(100) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    descricao VARCHAR(2000) NOT NULL,
    tipo_categoria VARCHAR(50),
    marca VARCHAR(40),
    imagem_url VARCHAR(255),
    estoque INT NOT NULL,
    data_adicao DATE

)