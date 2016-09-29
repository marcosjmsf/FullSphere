/**
 * 
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Bean.Endereco;

/**
 * @author marcos
 *
 */
public class EnderecoRowMapper implements RowMapper<Endereco> {

	@Override
	public Endereco mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Endereco endereco = new Endereco();
		
		endereco.setIdLogradouro(rs.getInt("id_logradouro"));
		endereco.setNomeBairro(rs.getString("nome_bairro"));
		endereco.setNomeCidade(rs.getString("nome_cidade"));
		endereco.setNomeEstado(rs.getString("nm_estado"));
		endereco.setNomeLogradouro(rs.getString("nome_logradouro"));
		endereco.setCep(rs.getString("cep_logradouro"));
		endereco.setSiglaEstado(rs.getString("sigla_estado"));
		
		
		
		return endereco;
	}
	
	
	

}
