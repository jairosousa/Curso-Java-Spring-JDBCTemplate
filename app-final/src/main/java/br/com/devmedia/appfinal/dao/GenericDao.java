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
	
	protected abstract SqlParameterSource parameterSource(T entity);
	
	protected abstract RowMapper<T> rowMapper();

	public int delete(String sql, Integer id) {
		return getJdbcTemplate().update(sql, id);
	}

	protected NamedParameterJdbcTemplate nameQuery() {
		return new NamedParameterJdbcTemplate(getDataSource());
	}

	protected Number save(String tableName, String key, SqlParameterSource parameterSource) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(getDataSource());
		insert.withTableName(tableName);
		insert.usingGeneratedKeyColumns(key);
		return insert.executeAndReturnKey(parameterSource);
	}

	protected int update(String sql, SqlParameterSource parameterSource) {
		return nameQuery().update(sql, parameterSource);
	}

	protected T findById(String sql, Integer id) {
		return getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<T>(aClass), id);
	}

	protected T findById(String sql, Integer id, RowMapper<T> rowMapper) {
		return getJdbcTemplate().queryForObject(sql, rowMapper, id);
	}

	protected List<T> findAll(String sql) {
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<T>(aClass));
	}

	protected List<T> findAll(String sql, RowMapper<T> rowMapper) {
		return getJdbcTemplate().query(sql, rowMapper);
	}

}
