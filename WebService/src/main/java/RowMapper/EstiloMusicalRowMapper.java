/**
 * 
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Bean.EstiloMusical;

/**
 * @author marcos
 *
 */
public class EstiloMusicalRowMapper implements RowMapper<EstiloMusical> {
	
	@Override
	public EstiloMusical mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		EstiloMusical estiloMusical = new EstiloMusical();
		
		estiloMusical.setIdEstiloMusical(rs.getInt("id_estilo_musical"));
		estiloMusical.setNomeEstiloMusical(rs.getString("nm_estilo_musical"));
		
		return estiloMusical;
	}
}
