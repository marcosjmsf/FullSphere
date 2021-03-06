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
 */
public class ProcedureCadastroAlbum extends StoredProcedure{
	
	public ProcedureCadastroAlbum(DataSource dataSource) {
		
        super(dataSource, "CADASTRO_ALBUM");  
               
        declareParameter(new SqlParameter("prc_nm_album", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_foto_album", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_desc_album", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_ano_lancamento", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_membros_album", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_setList_album", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_id_artista_fk", Types.INTEGER));
        declareParameter(new SqlOutParameter("prc_codigo", Types.VARCHAR));
        declareParameter(new SqlOutParameter("prc_id_album", Types.INTEGER));
        declareParameter(new SqlOutParameter("prc_mensagem", Types.VARCHAR));

        compile();
	}
	
	@Override
	public Map<String, Object> execute(Map<String, ?> inParams) throws DataAccessException {
	// TODO Auto-generated method stub

	return super.execute(inParams);
	}

}
