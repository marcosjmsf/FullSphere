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
public class ProcedureCadastroEdicaoAlbum extends StoredProcedure{
	
	public ProcedureCadastroEdicaoAlbum(DataSource dataSource) {
		
        super(dataSource, "CADASTRO_EDICAO_ALBUM");  
               
        declareParameter(new SqlParameter("prc_nm_edicao_album", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_data_lancamento_edicao_album", Types.DATE));
        declareParameter(new SqlParameter("prc_observacao_edicao_album", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_setList_edicao_album", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_capa_edicao_album", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_id_pais_fk", Types.INTEGER));
        declareParameter(new SqlParameter("prc_id_gravadora_fk", Types.INTEGER));
        declareParameter(new SqlParameter("prc_id_album_fk", Types.INTEGER));
        declareParameter(new SqlParameter("prc_id_tipo_midia_fk", Types.INTEGER));
        declareParameter(new SqlOutParameter("prc_codigo", Types.VARCHAR));
        declareParameter(new SqlOutParameter("prc_id_edicao_album", Types.INTEGER));
        declareParameter(new SqlOutParameter("prc_mensagem", Types.VARCHAR));

        compile();
	}
	
	@Override
	public Map<String, Object> execute(Map<String, ?> inParams) throws DataAccessException {
	// TODO Auto-generated method stub

	return super.execute(inParams);
	}

}
