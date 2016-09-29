/**
 * 
 */
package DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

import Bean.Endereco;
import RowMapper.EnderecoRowMapper;

/**
 * @author marcos
 *
 */
public class EnderecoDao {
	
	private JdbcTemplate jdbcTemplate ;
	private StoredProcedure procedureCadastroLogradouro;

	

	public List <Endereco> consultaEnderecoCep(String cep){
		
		List <Endereco> listaEndereco = new ArrayList<Endereco>();
		
		String sql ="SELECT lo.nome_logradouro, lo.id_logradouro, lo.cep_logradouro,"
				+ " ba.nome_bairro,"
				+ " ci.nome_cidade,"
				+ " es.sigla_estado,"
				+ " es.nm_estado "
				+ "from logradouro lo, bairro ba, cidade ci, estado es "
				+ "where  lo.cep_logradouro = ? "
				+ "and ba.id_bairro = lo.id_bairro "
				+ "and ci.id_cidade = ba.id_cidade "
				+ "and es.id_estado = ci.id_estado";
		
		Object [] parametros = {cep};
		
		
		//try{
			listaEndereco = jdbcTemplate.query(sql, parametros, new EnderecoRowMapper());
			
			/*if(listaEndereco.size()>=1){
				
				listaEndereco.get(0).getResultado().setCode("0");
				listaEndereco.get(0).getResultado().setMensagem("OK");
				
			}else{
				
				Endereco endereco = new Endereco();
				endereco.getResultado().setCode("-2");
				endereco.getResultado().setMensagem("Cep não encontrado");
				listaEndereco.add(endereco);
				
			}
			

		}catch(EmptyResultDataAccessException e){
			
			Endereco endereco = new Endereco();
			endereco.getResultado().setCode("-2");
			endereco.getResultado().setMensagem("Cep não encontrado");
			
			listaEndereco.add(endereco);
			
		}*/
		return listaEndereco;
	}
	
	
	public Endereco cadastroLogradouro (Endereco endereco){
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();
		
		parametros.put("prc_cep", endereco.getCep());
		parametros.put("prc_logradouro", endereco.getNomeLogradouro());
		parametros.put("prc_logradouro_limpo", endereco.getNomeLogradouro().toUpperCase().replace(" ", ""));
		
		parametrosOut = procedureCadastroLogradouro.execute(parametros);
		
		endereco.setIdLogradouro(Integer.parseInt(parametrosOut.get("prc_id_logradouro").toString()));
		
		return endereco;
	}
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public StoredProcedure getProcedureCadastroLogradouro() {
		return procedureCadastroLogradouro;
	}


	public void setProcedureCadastroLogradouro(StoredProcedure procedureCadastroLogradouro) {
		this.procedureCadastroLogradouro = procedureCadastroLogradouro;
	}
	
	
	
	
	

}
