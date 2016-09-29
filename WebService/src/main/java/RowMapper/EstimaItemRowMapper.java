/**
 * 
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Bean.EstimaItem;



/**
 * @author marcos
 *
 */
public class EstimaItemRowMapper implements RowMapper<EstimaItem> {
	
	@Override
	public EstimaItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		EstimaItem estimaItem = new EstimaItem();
		
		estimaItem.setIdEstimaItem(rs.getInt("id_estima_item"));
		estimaItem.setDescricaoEstimaItem(rs.getString("desc_estima_item"));
		
		return estimaItem;
	}
}
