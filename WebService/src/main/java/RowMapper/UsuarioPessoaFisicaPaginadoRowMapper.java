/**
 * 
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Bean.UsuarioPessoaFisica;

/**
 * @author marcos
 *
 */
public class UsuarioPessoaFisicaPaginadoRowMapper implements RowMapper<UsuarioPessoaFisica> {

	@Override
	public UsuarioPessoaFisica mapRow(ResultSet rs, int arg1) throws SQLException {
		
		UsuarioPessoaFisica usuarioPessoaFisica = new UsuarioPessoaFisica();
	
		usuarioPessoaFisica.setNomeUser(rs.getString("nome_exibicao"));
		usuarioPessoaFisica.setFotoUsuario(rs.getString("foto_usuario"));
		usuarioPessoaFisica.setGuidUsuario(rs.getString("guid_usuario"));
		usuarioPessoaFisica.getEndereco().setNomeEstado(rs.getString("nm_estado"));
		usuarioPessoaFisica.getEndereco().setSiglaEstado(rs.getString("sigla_estado"));
		usuarioPessoaFisica.getEndereco().setNomeCidade(rs.getString("nome_cidade"));

		return usuarioPessoaFisica;
	}
}
