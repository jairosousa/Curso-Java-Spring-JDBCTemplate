package br.com.devmedia.editora.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.devmedia.editora.dao.mapper.EditoraMapper;
import br.com.devmedia.editora.entity.Autor;
import br.com.devmedia.editora.entity.Editora;

@Repository
@PropertySource("classpath:sql/editora.xml")
public class EditoraDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${sql.insert}")
	private String SQL_INSERT;

	@Value("${sql.findBy.razaosocial}")
	private String SQL_FIND_BY_RAZAO_SOCIAL;

	@Value("${sql.findBy.cidades}")
	private String SQL_FIND_BY_CIDADES;

	@Value("${sql.findBy.id}")
	private String SQL_FIND_BY_ID;

	@Value("${sql.findAll}")
	private String SQL_FIND_ALL;

	@Value("${sql.count}")
	private String SQL_COUNT;

	@Value("${sql.findEmailBy.id}")
	private String SQL_FIND_BY_EMAIL_ID;

	@Value("${sql.findEmails}")
	private String SQL_FIND_EMAILS;

	@Value("${sql.findCidadeAndEmailBy.id}")
	private String SQL_FIND_CIDADE_AND_EMAIL_BY_ID;

	@Value("${sql.findCidadesAndEmails}")
	private String SQL_FIND_CIDADES_AND_EMAILS;

	@Value("${sql.update}")
	private String SQL_UPDATE;

	@Value("${sql.delete}")
	private String SQL_DELETE;

	@Value("${sql.findEditoraWithAutores}")
	private String SQL_EDITORA_WITH_AUTORES;
	
	public void saveBatch(final List<Editora> editoras) {
		SimpleJdbcInsert simple = new SimpleJdbcInsert(jdbcTemplate)
		.withTableName("EDITORAS")
		.usingColumns("RAZAO_SOCIAL", "CIDADE", "EMAIL");
		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(editoras.toArray());
		
		simple.executeBatch(batch);
	}
	
	public void insertBatch(final List<Editora> editoras) {
		
		jdbcTemplate.batchUpdate(SQL_INSERT, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Editora editora = editoras.get(i);
				ps.setString(1, editora.getRazaoSocial());
				ps.setString(2, editora.getCidade());
				ps.setString(3, editora.getEmail());
				
			}
			
			@Override
			public int getBatchSize() {
				return editoras.size();
			}
		});
	}

	public Editora findEditoraWithAutores(int idEditora, int page, int size) {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_EDITORA_WITH_AUTORES, idEditora, page * size, size);

		Editora editora = null;
		List<Autor> autores = new ArrayList();

		for (Map row : rows) {
			if (editora == null) {
				editora = new Editora();
				editora.setId((Integer) row.get("ID_EDITORA"));
				editora.setRazaoSocial((String) row.get("RAZAO_SOCIAL"));
				editora.setCidade((String) row.get("CIDADE"));
				editora.setEmail((String) row.get("EMAIL"));
			}

			Autor autor = new Autor();
			autor.setId((Integer) row.get("ID_AUTOR"));
			autor.setNome((String) row.get("NOME"));
			autor.setEmail((String) row.get("EMAIL_AUTOR"));

			autores.add(autor);
		}

		editora.setAutores(autores);

		return editora;
	}

	public int delete(int id) {
		return jdbcTemplate.update(SQL_DELETE, id);
	}

	public int update(Editora editora) {
		return jdbcTemplate.update(SQL_UPDATE, editora.getRazaoSocial(), editora.getCidade(), editora.getEmail(),
				editora.getId());
	}

	public List<Editora> findCidadesAndEmails() {
		return jdbcTemplate.query(SQL_FIND_CIDADES_AND_EMAILS, new EditoraMapper().new CidadeAndEmailMapper());
	}

	public Editora findCidadeAndEmailForId(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_CIDADE_AND_EMAIL_BY_ID, new Integer[] { id },
				new EditoraMapper().new CidadeAndEmailMapper());
	}

	public List<String> findCidadeAndEmailById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_CIDADE_AND_EMAIL_BY_ID, new Integer[] { id },
				new RowMapper<List<String>>() {

					@Override
					public List<String> mapRow(ResultSet rs, int rowNum) throws SQLException {
						String cidade = rs.getString("CIDADE");
						String email = rs.getString("EMAIL");
						return Arrays.asList(cidade, email);
					}

				});
	}

	public List<String> findByEmails() {
		return jdbcTemplate.queryForList(SQL_FIND_EMAILS, String.class);
	}

	public String findEmailById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL_ID, String.class, id);
	}

	public int count() {
		return jdbcTemplate.queryForObject(SQL_COUNT, Integer.class);
	}

	public List<Editora> findByRazaoSocial(String rz) {
		return jdbcTemplate.query(SQL_FIND_BY_RAZAO_SOCIAL, new String[] { rz }, new EditoraMapper());
	}

	public List<Editora> findByCidades(String c1, String c2) {
		return jdbcTemplate.query(SQL_FIND_BY_CIDADES, new EditoraMapper(), c1, c2);
	}

	public Editora findById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new EditoraMapper(), id);
	}

	public List<Editora> findAll() {
		return jdbcTemplate.query(SQL_FIND_ALL, new EditoraMapper());
	}

	public Editora add(Editora editora) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		insert.setTableName("EDITORAS");
		insert.setColumnNames(Arrays.asList("RAZAO_SOCIAL", "CIDADE", "EMAIL"));
		insert.setGeneratedKeyName("ID_EDITORA");

		Number key = insert.executeAndReturnKey(new BeanPropertySqlParameterSource(editora));

		editora.setId(key.intValue());

		return editora;
	}

	public Integer save(Editora editora) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		insert.setTableName("EDITORAS");
		insert.setColumnNames(Arrays.asList("RAZAO_SOCIAL", "CIDADE", "EMAIL"));
		insert.setGeneratedKeyName("ID_EDITORA");

		Number key = insert.executeAndReturnKey(new BeanPropertySqlParameterSource(editora));

		return key.intValue();
	}

	public int insert(Editora editora) {
		return jdbcTemplate.update(SQL_INSERT, editora.getRazaoSocial(), editora.getCidade(), editora.getEmail());
	}

}
