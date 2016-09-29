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
public class ProcedureConfiguracaoPaginaUsuario extends StoredProcedure{

	public ProcedureConfiguracaoPaginaUsuario(DataSource dataSource) {

		super(dataSource, "CONFIGURACAO_PAGINA_USUARIO");  

		declareParameter(new SqlParameter("prc_id_usuario", Types.INTEGER));
		declareParameter(new SqlParameter("prc_guid_pesquisa", Types.VARCHAR));
		declareParameter(new SqlOutParameter("prc_id_estado_amizade", Types.INTEGER));
		declareParameter(new SqlOutParameter("prc_id_amizade", Types.INTEGER));
		declareParameter(new SqlOutParameter("prc_amizade", Types.BOOLEAN));
		declareParameter(new SqlOutParameter("prc_solicitante", Types.BOOLEAN));
		declareParameter(new SqlOutParameter("prc_data_nascimento_privacidade", Types.BOOLEAN));
		declareParameter(new SqlOutParameter("prc_sexo_privacidade", Types.BOOLEAN));
		declareParameter(new SqlOutParameter("prc_email_privacidade", Types.BOOLEAN));
		declareParameter(new SqlOutParameter("prc_telefone_privacidade", Types.BOOLEAN));
		declareParameter(new SqlOutParameter("prc_localizacao_privacidade", Types.BOOLEAN));
		declareParameter(new SqlOutParameter("prc_colecao_privacidade", Types.BOOLEAN));
		declareParameter(new SqlOutParameter("prc_artista_favorito_privacidade", Types.BOOLEAN));

		compile();
	}

	@Override
	public Map<String, Object> execute(Map<String, ?> inParams) throws DataAccessException {
		// TODO Auto-generated method stub

		return super.execute(inParams);
	}
}
