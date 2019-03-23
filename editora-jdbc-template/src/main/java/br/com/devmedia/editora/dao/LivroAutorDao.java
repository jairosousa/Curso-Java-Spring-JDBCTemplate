package br.com.devmedia.editora.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.devmedia.editora.entity.LivroAutor;

@Repository
public class LivroAutorDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public LivroAutorDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public LivroAutor save(LivroAutor livroAutor) {

		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
				.withTableName("LIVROS_AUTORES")
				.usingColumns("ID_LIVRO", "ID_AUTOR")
				.usingGeneratedKeyColumns("ID_LIVRO_AUTOR");

		Number key = insert.executeAndReturnKey(new BeanPropertySqlParameterSource(livroAutor));

		livroAutor.setIdLivroAutor(key.intValue());

		return livroAutor;
	}

}
