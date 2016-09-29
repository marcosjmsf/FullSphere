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
public class UsuarioFisicoHomeIdRowMapper implements RowMapper<UsuarioPessoaFisica> {

	@Override
	public UsuarioPessoaFisica mapRow(ResultSet rs, int arg1) throws SQLException {
		
		UsuarioPessoaFisica usuarioPessoaFisica = new UsuarioPessoaFisica();
		
		usuarioPessoaFisica.setEmailUsuario(rs.getString("e_mail_usuario"));
		usuarioPessoaFisica.getEndereco().setSiglaEstado(rs.getString("sigla_estado"));
		usuarioPessoaFisica.setPermissaoModeracao(rs.getString("nm_funcao_moderacao"));
		usuarioPessoaFisica.setNome(rs.getString("nome"));
		usuarioPessoaFisica.setNomeUser(rs.getString("nome_exibicao"));
		usuarioPessoaFisica.setFotoUsuario(rs.getString("foto_usuario"));

		
		
		return usuarioPessoaFisica;
	}

}
