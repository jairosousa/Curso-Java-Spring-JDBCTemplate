package br.com.devmedia.appfinal.controller;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping("/hello")
	public String hello() {
		String valor = "";

		try {
			DatabaseMetaData data = jdbcTemplate.getDataSource().getConnection().getMetaData();
			valor = "URL: " + data.getURL();

		} catch (SQLException e) {
			valor = e.getMessage();
		}
		return valor;
	}
}
