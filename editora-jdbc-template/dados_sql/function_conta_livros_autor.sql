CREATE DEFINER=`root`@`localhost` FUNCTION `function_conta_livros_autor`(idAutor INT) RETURNS varchar(200) CHARSET latin1
BEGIN
	DECLARE retorno, nome VARCHAR(200);
	DECLARE conte INT;
    
    SELECT
		COUNT(L.ID_LIVRO), A.NOME
	INTO
		conte, nome
	FROM
		AUTORES A, LIVROS L, LIVROS_AUTORES LA
	WHERE
		A.ID_AUTOR = LA.ID_AUTOR
	AND
		LA.ID_LIVRO = L.ID_LIVRO
	AND
		A.ID_AUTOR = idAutor;
        
	SET retorno = concat("O Autor ", nome, " possui ", conte, " livro(s) publicado(s)!");
    
RETURN retorno;
END