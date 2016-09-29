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
public class ProcedureCadastroItemColecao extends StoredProcedure{
	
	public ProcedureCadastroItemColecao(DataSource dataSource) {
		
        super(dataSource, "CADASTRO_ITEM_COLECAO");  
               
        declareParameter(new SqlParameter("prc_obs_item", Types.VARCHAR));
        declareParameter(new SqlParameter("prc_id_estima_item_fk", Types.INTEGER));
        declareParameter(new SqlParameter("prc_id_edicao_album_fk", Types.INTEGER));
        declareParameter(new SqlParameter("prc_id_usuario_pk", Types.INTEGER));
        declareParameter(new SqlParameter("prc_dt_adicao_item", Types.DATE));
        declareParameter(new SqlParameter("prc_quantidade_item", Types.INTEGER));
        declareParameter(new SqlParameter("prc_estado_item_caixa", Types.INTEGER));
        declareParameter(new SqlParameter("prc_estado_item_midia", Types.INTEGER));
        declareParameter(new SqlParameter("prc_estado_item_encarte", Types.INTEGER));
        declareParameter(new SqlOutParameter("prc_codigo", Types.VARCHAR));
        declareParameter(new SqlOutParameter("prc_id_item_colecao", Types.INTEGER));
        declareParameter(new SqlOutParameter("prc_mensagem", Types.VARCHAR));

        compile();
	}
	
	@Override
	public Map<String, Object> execute(Map<String, ?> inParams) throws DataAccessException {
	// TODO Auto-generated method stub

	return super.execute(inParams);
	}

}
