CREATE DEFINER=`root`@`localhost` PROCEDURE `procedure_uppercase_titulo`(IN idLivro INT)
BEGIN
	UPDATE
		LIVROS
	SET
		TITULO = UPPER(TITULO)
	WHERE
		ID_LIVRO = idLivro;
END