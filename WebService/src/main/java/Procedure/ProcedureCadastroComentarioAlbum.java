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
public class ProcedureCadastroComentarioAlbum extends StoredProcedure{
	
	public ProcedureCadastroComentarioAlbum(DataSource dataSource) {
		
        super(dataSource, "CADASTRO_COMENTARIO_ALBUM");  
               
        declareParameter(new SqlParameter("prc_conteudo_comentario_album", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_id_album_fk", Types.INTEGER));
        declareParameter(new SqlParameter("prc_id_usuario_pf_pk", Types.INTEGER));
        declareParameter(new SqlOutParameter("prc_codigo", Types.VARCHAR));
        declareParameter(new SqlOutParameter("prc_id_comentario", Types.INTEGER));
        declareParameter(new SqlOutParameter("prc_mensagem", Types.VARCHAR));

        compile();
	}
	
	@Override
	public Map<String, Object> execute(Map<String, ?> inParams) throws DataAccessException {
	// TODO Auto-generated method stub

	return super.execute(inParams);
	}
}
