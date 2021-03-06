/**
 * 
 */
package Procedure;

import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

/**
 * @author marcos
 *
 */
public class ProcedureDeleteAmizade extends StoredProcedure{
	
	public ProcedureDeleteAmizade(DataSource dataSource) {
		
        super(dataSource, "UPDATE_ESTADO_AMIZADE");  
               
        declareParameter(new SqlParameter("prc_id_solicitante", Types.INTEGER));
        declareParameter(new SqlParameter("prc_guid_convidado", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_id_amizade", Types.INTEGER));
        declareParameter(new SqlOutParameter("prc_codigo", Types.VARCHAR));
        declareParameter(new SqlOutParameter("prc_mensagem", Types.VARCHAR));

        compile();
	}
	
	@Override
	public Map<String, Object> execute(Map<String, ?> inParams) throws DataAccessException {
	// TODO Auto-generated method stub

	return super.execute(inParams);
	}
}
