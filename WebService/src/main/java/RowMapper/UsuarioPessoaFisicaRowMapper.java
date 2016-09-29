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
public class UsuarioPessoaFisicaRowMapper implements RowMapper<UsuarioPessoaFisica> {

	@Override
	public UsuarioPessoaFisica mapRow(ResultSet rs, int arg1) throws SQLException {
		
		UsuarioPessoaFisica usuarioPessoaFisica = new UsuarioPessoaFisica();
		
		usuarioPessoaFisica.setComplementoEndereco(rs.getString("complemento_endereco"));
		usuarioPessoaFisica.setCpf(rs.getString("cpf"));
		usuarioPessoaFisica.setDtNasc(rs.getDate("dt_nasc"));
		usuarioPessoaFisica.setEmailUsuario(rs.getString("e_mail_usuario"));
		usuarioPessoaFisica.getEndereco().setIdLogradouro(rs.getInt("id_logradouro_fk"));
		usuarioPessoaFisica.getEndereco().setNomeBairro(rs.getString("nome_bairro"));
		usuarioPessoaFisica.getEndereco().setNomeCidade(rs.getString("nome_cidade"));
		usuarioPessoaFisica.getEndereco().setNomeEstado(rs.getString("nm_estado"));
		usuarioPessoaFisica.getEndereco().setNomeLogradouro(rs.getString("nome_logradouro"));
		usuarioPessoaFisica.getEndereco().setCep(rs.getString("cep_logradouro"));
		usuarioPessoaFisica.getEndereco().setSiglaEstado(rs.getString("sigla_estado"));
		usuarioPessoaFisica.setPermissaoModeracao(rs.getString("nm_funcao_moderacao"));
		usuarioPessoaFisica.setIdUsuario(rs.getInt("id_usuario"));
		usuarioPessoaFisica.setNome(rs.getString("nome"));
		usuarioPessoaFisica.setNomeUser(rs.getString("nome_exibicao"));
		usuarioPessoaFisica.setNumeroEndereco(rs.getString("numero_endereco"));
		usuarioPessoaFisica.setSexo(rs.getString("sexo"));
		usuarioPessoaFisica.setTelefonePrincipal(rs.getString("telefone_principal"));
		usuarioPessoaFisica.setTelefoneSecundario(rs.getString("telefone_secundario"));
		usuarioPessoaFisica.setIdPermissaoModeracao(rs.getInt("id_funcao_moderacao_fk"));
		usuarioPessoaFisica.setFotoUsuario(rs.getString("foto_usuario"));

		
		
		return usuarioPessoaFisica;
	}

}
