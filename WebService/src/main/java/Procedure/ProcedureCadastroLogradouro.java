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
public class ProcedureCadastroLogradouro extends StoredProcedure{
	
	
	public ProcedureCadastroLogradouro(DataSource dataSource) {
		
        super(dataSource, "CADASTRO_LOGRADOURO");  
               
        declareParameter(new SqlParameter("prc_cep", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_logradouro", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_logradouro_limpo", Types.VARCHAR));
        declareParameter(new SqlOutParameter("prc_id_logradouro", Types.INTEGER));

        compile();
	}
	
	
	

@Override
	public Map<String, Object> execute(Map<String, ?> inParams) throws DataAccessException {
	// TODO Auto-generated method stub

	return super.execute(inParams);
	}
	
	

}
