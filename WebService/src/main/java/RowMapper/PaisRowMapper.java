/**
 * 
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import Bean.Pais;

/**
 * @author marcos
 *
 */
public class PaisRowMapper implements RowMapper<Pais>{
	
	@Override
	public Pais mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Pais pais = new Pais();
		
		pais.setIdPais(rs.getInt("id_pais"));
		pais.setNomePais(rs.getString("nm_pais"));
		pais.setBandeiraPais(rs.getString("bandeira_pais"));
		pais.setNameCountry(rs.getString("nm_country"));

		return pais;
	}
	
	
	
	

}
