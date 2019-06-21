package br.com.devmedia.appfinal.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.devmedia.appfinal.entity.Departamento;
import br.com.devmedia.appfinal.entity.Endereco;

@Repository
public class EnderecoDao extends GenericDao<Endereco> {

	@Autowired
	public EnderecoDao(DataSource dataSource) {
		super(dataSource, Endereco.class);
	}

	@Override
	protected SqlParameterSource parameterSource(Endereco endereco) {
		return new BeanPropertySqlParameterSource(endereco);
	}

	@Override
	protected RowMapper<Endereco> rowMapper() {
		return new BeanPropertyRowMapper<Endereco>(Endereco.class);
	}
	
	public Endereco save(Endereco endereco) {
		Number key = save("ENDERECOS", "ID_ENDERECO", parameterSource(endereco));
		endereco.setIdEndereco(key.intValue());
		return endereco;
	}

}
