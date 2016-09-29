package RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Bean.UsuarioPessoaFisica;

/**
 * @author marcos
 *
 */
public class UsuarioPessoaFisicaPageRowMapper implements RowMapper<UsuarioPessoaFisica> {

	@Override
	public UsuarioPessoaFisica mapRow(ResultSet rs, int arg1) throws SQLException {
		
		UsuarioPessoaFisica usuarioPessoaFisica = new UsuarioPessoaFisica();
	
		usuarioPessoaFisica.setNomeUser(rs.getString("nome_exibicao"));
		usuarioPessoaFisica.setFotoUsuario(rs.getString("foto_usuario"));
		usuarioPessoaFisica.setGuidUsuario(rs.getString("guid_usuario"));

		return usuarioPessoaFisica;
	}
}
