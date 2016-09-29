/**
 * 
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Bean.Gravadora;

/**
 * @author marcos
 *
 */
public class GravadoraRowMapper implements RowMapper<Gravadora>{
	
	@Override
	public Gravadora mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Gravadora gravadora = new Gravadora();
		
		gravadora.setIdGravadora(rs.getInt("id_gravadora"));
		gravadora.setNomeGravadora(rs.getString("nm_gravadora"));


		return gravadora;
	}
	

}
