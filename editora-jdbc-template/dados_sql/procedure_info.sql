CREATE DEFINER=`root`@`localhost` PROCEDURE `procedure_info`(
IN in_id INT,
OUT out_titulo VARCHAR(45),
OUT out_autor VARCHAR(45),
OUT out_editora VARCHAR(45)
)
BEGIN
	SELECT
		E.RAZAO_SOCIAL, L.TITULO, A.NOME
	INTO
		out_editora, out_titulo, out_autor
	FROM
		EDITORAS E, AUTORES A, LIVROS L, LIVROS_AUTORES LA
	WHERE
		L.ID_LIVRO = LA.ID_LIVRO
	AND
		LA.ID_AUTOR = A.ID_AUTOR
	AND
		A.ID_EDITORA = E.ID_EDITORA
	AND
		L.ID_LIVRO = in_id;
		
END