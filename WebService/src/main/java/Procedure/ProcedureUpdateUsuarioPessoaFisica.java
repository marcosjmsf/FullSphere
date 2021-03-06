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
public class ProcedureUpdateUsuarioPessoaFisica extends StoredProcedure{
	
	public ProcedureUpdateUsuarioPessoaFisica(DataSource dataSource) {
		
        super(dataSource, "UPDATE_USUARIO_FISICO");  
               
        declareParameter(new SqlParameter("prc_id_usuario", Types.INTEGER));
        declareParameter(new SqlParameter("prc_telefone_principal", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_telefone_secundario", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_id_logradouro_fk", Types.INTEGER));
        declareParameter(new SqlParameter("prc_numero_endereco", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_complemento_endereco", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_nome", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_dt_nasc", Types.DATE));
        declareParameter(new SqlParameter("prc_sexo", Types.CHAR));
        declareParameter(new SqlParameter("prc_nome_user", Types.VARCHAR));
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
