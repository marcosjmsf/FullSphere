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
public class PaisComboBoxRowMapper implements RowMapper<Pais>{
		
		@Override
		public Pais mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			
			Pais pais = new Pais();
			
			pais.setIdPais(rs.getInt("id_pais"));
			pais.setNomePais(rs.getString("nm_pais"));


			return pais;
		}
		
		
		



}
