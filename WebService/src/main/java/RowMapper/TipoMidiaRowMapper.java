/**
 * 
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Bean.TipoMidia;

/**
 * @author marcos
 *
 */
public class TipoMidiaRowMapper implements RowMapper<TipoMidia>{
	
	@Override
	public TipoMidia mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		TipoMidia tipoMidia = new TipoMidia();
		
		tipoMidia.setIdTipoMidia(rs.getInt("id_tipo_midia"));
		tipoMidia.setNomeTipoMidia(rs.getString("nm_tipo_midia"));


		return tipoMidia;
	}

}
