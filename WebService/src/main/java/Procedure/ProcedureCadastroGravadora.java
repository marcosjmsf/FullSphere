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
public class ProcedureCadastroGravadora extends StoredProcedure{
	
	
	public ProcedureCadastroGravadora(DataSource dataSource) {
		
        super(dataSource, "CADASTRO_GRAVADORA");  
               	
        declareParameter(new SqlParameter("prc_nm_gravadora", Types.VARCHAR));
        declareParameter(new SqlOutParameter("prc_codigo", Types.VARCHAR));
        declareParameter(new SqlOutParameter("prc_id_gravadora", Types.INTEGER));
        declareParameter(new SqlOutParameter("prc_mensagem", Types.VARCHAR));

        compile();
	}
	
	@Override
	public Map<String, Object> execute(Map<String, ?> inParams) throws DataAccessException {
	// TODO Auto-generated method stub

	return super.execute(inParams);
	}
	

}
