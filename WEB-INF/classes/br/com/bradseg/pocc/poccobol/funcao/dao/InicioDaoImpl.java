package br.com.bradseg.pocc.poccobol.funcao.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Documentação do DAO da Funcionalidade
 * 
 * @author Bradesco Seguros
 */
@Repository
public class InicioDaoImpl implements InicioDao {

	@Autowired(required = false)
	private DataSource dataSource;

	/*
	 * (non-Javadoc)
	 */
	public String consultarSaudacao(String nome) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("nome", nome.toLowerCase());
		String mensagemModelo = new NamedParameterJdbcTemplate(dataSource).queryForObject(
				"SELECT MSG FROM SAUDACAO WHERE NOME = :nome", params, String.class);
		return mensagemModelo;
	}

	/*
	 * (non-Javadoc)
	 */
	public String consultarSaudacaoPadrao(String nome) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		String mensagemModelo = new NamedParameterJdbcTemplate(dataSource).queryForObject(
				"SELECT MSG FROM SAUDACAO WHERE NOME IS NULL", params, String.class);
		return mensagemModelo;
	}

	/*
	 * (non-Javadoc)
	 */
	public void incluirSaudacao(String modeloSaudacao, String nome) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("modeloSaudacao", modeloSaudacao);
		params.addValue("nome", nome);
		new NamedParameterJdbcTemplate(dataSource).update("INSERT INTO SAUDACAO values (:modeloSaudacao, :nome)",
				params);
	}

}
