package br.com.devmedia.appfinal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public abstract class GenericDao<T> extends JdbcDaoSupport {

	private Class aClass;

	public GenericDao(DataSource dataSource, Class aClass) {
		setDataSource(dataSource);
		this.aClass = aClass;
	}
	
	public abstract SqlParameterSource parameterSource(T entity);

	public int delete(String sql, Integer id) {
		return getJdbcTemplate().update(sql, id);
	}

	public NamedParameterJdbcTemplate nameQuery() {
		return new NamedParameterJdbcTemplate(getDataSource());
	}

	public Number save(String tableName, String key, SqlParameterSource parameterSource) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(getDataSource());
		insert.withTableName(tableName);
		insert.usingGeneratedKeyColumns(key);
		return insert.executeAndReturnKey(parameterSource);
	}

	public int update(String sql, SqlParameterSource parameterSource) {
		return nameQuery().update(sql, parameterSource);
	}

	public T findById(String sql, Integer id) {
		return getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<T>(aClass), id);
	}

	public T findById(String sql, Integer id, RowMapper<T> rowMapper) {
		return getJdbcTemplate().queryForObject(sql, rowMapper, id);
	}

	public List<T> findAll(String sql) {
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<T>(aClass));
	}

	public List<T> findAll(String sql, RowMapper<T> rowMapper) {
		return getJdbcTemplate().query(sql, rowMapper);
	}

}
