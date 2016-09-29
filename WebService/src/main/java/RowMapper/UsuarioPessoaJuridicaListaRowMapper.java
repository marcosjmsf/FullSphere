/**
 * 
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Bean.UsuarioPessoaJuridica;

/**
 * @author marcos
 *
 */
public class UsuarioPessoaJuridicaListaRowMapper implements RowMapper<UsuarioPessoaJuridica> {

	@Override
	public UsuarioPessoaJuridica mapRow(ResultSet rs, int arg1) throws SQLException {
		
		UsuarioPessoaJuridica usuarioPessoaJuridica = new UsuarioPessoaJuridica();
		
		usuarioPessoaJuridica.getEndereco().setNomeCidade(rs.getString("nome_cidade"));
		usuarioPessoaJuridica.getEndereco().setNomeEstado(rs.getString("nm_estado"));
		usuarioPessoaJuridica.getEndereco().setSiglaEstado(rs.getString("sigla_estado"));
		usuarioPessoaJuridica.setNomeFantasia(rs.getString("nome_exibicao"));
		usuarioPessoaJuridica.setFotoUsuario(rs.getString("foto_usuario"));
		usuarioPessoaJuridica.setGuidUsuario(rs.getString("guid_usuario"));
		
		
		
		return usuarioPessoaJuridica;
	}
}
