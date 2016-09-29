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

import Bean.EstiloMusical;
import Bean.EstimaItem;
import Bean.Gravadora;
import Bean.Pais;
import Bean.TipoMidia;
import RowMapper.EstiloMusicalRowMapper;
import RowMapper.EstimaItemRowMapper;
import RowMapper.GravadoraRowMapper;
import RowMapper.PaisComboBoxRowMapper;
import RowMapper.TipoMidiaRowMapper;

/**
 * @author marcos
 *
 */
public class UtilDao {
	
	private JdbcTemplate jdbcTemplate ;
	private StoredProcedure procedureCadastroGravadora;

	
	public List <EstiloMusical> consultaEstiloMusical(){

		String sql ="select nm_estilo_musical, id_estilo_musical from estilo_musical order by nm_estilo_musical";
		
		List <EstiloMusical> listaEstiloMusical = jdbcTemplate.query(sql, new EstiloMusicalRowMapper());

		
		return listaEstiloMusical;

	}
	
	public List <Pais> consultaPais(){

		String sql ="select id_pais, nm_pais from pais";
		
		List <Pais> listaPais = jdbcTemplate.query(sql, new PaisComboBoxRowMapper());

		
		return listaPais;

	}
	
	public List <TipoMidia> consultaTipoMidia(){

		String sql ="select id_tipo_midia, nm_tipo_midia from Tipo_Midia";
		
		List <TipoMidia> listaTipoMidia = jdbcTemplate.query(sql, new TipoMidiaRowMapper());

		
		return listaTipoMidia;

	}

	public List<Gravadora> consultaGravadora(String gravadoraNome){

		String sql ="select * from gravadora where nm_gravadora LIKE ? limit 10";
		
		Object [] parametros = {"%"+gravadoraNome+"%"};
		
		List<Gravadora> listaGravadora =  new ArrayList<Gravadora>();
		
		listaGravadora = jdbcTemplate.query(sql, parametros, new GravadoraRowMapper());
		
		return listaGravadora;

	}

	public Gravadora cadastroGravadora(Gravadora gravadora){

		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();
		
		
		parametros.put("prc_nm_gravadora", gravadora.getNomeGravadora());

		parametrosOut = procedureCadastroGravadora.execute(parametros);
		
		gravadora.getResultado().setCode((String)parametrosOut.get("prc_codigo"));
		gravadora.getResultado().setMensagem((String)parametrosOut.get("prc_mensagem"));
		gravadora.setIdGravadora((int)parametrosOut.get("prc_id_gravadora"));
		
		
	
		
		return gravadora;
	}
	

		public List<EstimaItem> consultaEstimaItem(){
	
			String sql ="select id_estima_item, desc_estima_item from Estima_Item";
			
			
			List<EstimaItem> listaEstimaItem =  new ArrayList<EstimaItem>();
			
			listaEstimaItem = jdbcTemplate.query(sql,new EstimaItemRowMapper());
			
			return listaEstimaItem;
	
		}

	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public StoredProcedure getProcedureCadastroGravadora() {
		return procedureCadastroGravadora;
	}

	public void setProcedureCadastroGravadora(StoredProcedure procedureCadastroGravadora) {
		this.procedureCadastroGravadora = procedureCadastroGravadora;
	}
	
	
	
	

}
