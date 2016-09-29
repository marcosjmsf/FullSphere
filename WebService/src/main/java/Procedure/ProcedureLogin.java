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
public class ProcedureLogin extends StoredProcedure{

	public ProcedureLogin(DataSource dataSource) {

		super(dataSource, "LOGIN");  

		declareParameter(new SqlParameter("prc_e_mail_usuario", Types.VARCHAR));
		declareParameter(new SqlParameter("prc_senha_usuario", Types.VARCHAR));
		declareParameter(new SqlOutParameter("prc_codigo", Types.VARCHAR));
		declareParameter(new SqlOutParameter("prc_mensagem", Types.VARCHAR));
		declareParameter(new SqlOutParameter("prc_id_usuario", Types.INTEGER));
		declareParameter(new SqlOutParameter("prc_tipo_usuario", Types.VARCHAR));
		declareParameter(new SqlOutParameter("prc_estado_plano", Types.VARCHAR));

		compile();
	}

	@Override
	public Map<String, Object> execute(Map<String, ?> inParams) throws DataAccessException {
		// TODO Auto-generated method stub

		return super.execute(inParams);
	}


}
