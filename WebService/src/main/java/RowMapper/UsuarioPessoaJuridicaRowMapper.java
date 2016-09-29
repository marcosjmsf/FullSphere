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
public class UsuarioPessoaJuridicaRowMapper implements RowMapper<UsuarioPessoaJuridica> {

	@Override
	public UsuarioPessoaJuridica mapRow(ResultSet rs, int arg1) throws SQLException {
		
		UsuarioPessoaJuridica usuarioPessoaJuridica = new UsuarioPessoaJuridica();
		
		usuarioPessoaJuridica.setComplementoEndereco(rs.getString("complemento_endereco"));
		usuarioPessoaJuridica.setCnpj(rs.getString("cnpj"));
		usuarioPessoaJuridica.setInscricaoEstadual(rs.getString("insc_estadual"));
		usuarioPessoaJuridica.setEmailUsuario(rs.getString("e_mail_usuario"));
		usuarioPessoaJuridica.getEndereco().setIdLogradouro(rs.getInt("id_logradouro_fk"));
		usuarioPessoaJuridica.getEndereco().setNomeBairro(rs.getString("nome_bairro"));
		usuarioPessoaJuridica.getEndereco().setNomeCidade(rs.getString("nome_cidade"));
		usuarioPessoaJuridica.getEndereco().setNomeEstado(rs.getString("nm_estado"));
		usuarioPessoaJuridica.getEndereco().setNomeLogradouro(rs.getString("nome_logradouro"));
		usuarioPessoaJuridica.getEndereco().setCep(rs.getString("cep_logradouro"));
		usuarioPessoaJuridica.getEndereco().setSiglaEstado(rs.getString("sigla_estado"));
		usuarioPessoaJuridica.setIdUsuario(rs.getInt("id_usuario"));
		usuarioPessoaJuridica.setNomeFantasia(rs.getString("nome_exibicao"));
		usuarioPessoaJuridica.setNumeroEndereco(rs.getString("numero_endereco"));
		usuarioPessoaJuridica.setTelefonePrincipal(rs.getString("telefone_principal"));
		usuarioPessoaJuridica.setTelefoneSecundario(rs.getString("telefone_secundario"));
		usuarioPessoaJuridica.setRazaoSocial(rs.getString("razao_social"));
		usuarioPessoaJuridica.setFotoUsuario(rs.getString("foto_usuario"));
		usuarioPessoaJuridica.setGuidUsuario(rs.getString("guid_usuario"));
		
		
		
		return usuarioPessoaJuridica;
	}


}
