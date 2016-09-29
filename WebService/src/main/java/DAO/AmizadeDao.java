/**
 * 
 */
package DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

import Bean.Amizade;
import Bean.Resultado;

/**
 * @author marcos
 *
 */
public class AmizadeDao {

	private JdbcTemplate jdbcTemplate;
	private StoredProcedure procedureCadastroAmizade;
	private StoredProcedure procedureUpdateEstadoAmizade;
	private StoredProcedure procedureDeleteAmizade;
	private StoredProcedure procedureBloqueioAmizade;
	
	
	public Resultado cadastroAmizade(Amizade amizade){
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();
		
		parametros.put("prc_id_solicitante", amizade.getSolicitante().getIdUsuario());
		parametros.put("prc_guid_convidado", amizade.getConvidado().getGuidUsuario());
		parametros.put("prc_id_estado_amizade", amizade.getIdEstadoAmizade());

		
		parametrosOut = procedureCadastroAmizade.execute(parametros);
		
		Resultado resultado = new Resultado();
		
		resultado.setCode((String)parametrosOut.get("prc_codigo"));
		resultado.setMensagem((String)parametrosOut.get("prc_mensagem"));
		
		return resultado;
	}
	
	public Resultado updateEstadoAmizade(Amizade amizade){
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();
		
		parametros.put("prc_id_solicitante", amizade.getSolicitante().getIdUsuario());
		parametros.put("prc_guid_convidado", amizade.getConvidado().getGuidUsuario());
		parametros.put("prc_id_estado_amizade", amizade.getIdEstadoAmizade());
		parametros.put("prc_id_amizade", amizade.getIdAmizade());

		
		parametrosOut = procedureUpdateEstadoAmizade.execute(parametros);
		
		Resultado resultado = new Resultado();
		
		resultado.setCode((String)parametrosOut.get("prc_codigo"));
		resultado.setMensagem((String)parametrosOut.get("prc_mensagem"));
		
		return resultado;		
		
	}
	
	
	public Resultado deleteAmizade(Amizade amizade){
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();
		
		parametros.put("prc_id_solicitante", amizade.getSolicitante().getIdUsuario());
		parametros.put("prc_guid_convidado", amizade.getConvidado().getGuidUsuario());
		parametros.put("prc_id_amizade", amizade.getIdAmizade());

		
		parametrosOut = procedureDeleteAmizade.execute(parametros);
		
		Resultado resultado = new Resultado();
		
		resultado.setCode((String)parametrosOut.get("prc_codigo"));
		resultado.setMensagem((String)parametrosOut.get("prc_mensagem"));
		
		return resultado;		
		
	}
	
	public Resultado bloqueioAmizade(Amizade amizade){
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();
		
		parametros.put("prc_id_solicitante", amizade.getSolicitante().getIdUsuario());
		parametros.put("prc_guid_convidado", amizade.getConvidado().getGuidUsuario());
		
		parametrosOut = procedureBloqueioAmizade.execute(parametros);
		
		Resultado resultado = new Resultado();
		
		resultado.setCode((String)parametrosOut.get("prc_codigo"));
		resultado.setMensagem((String)parametrosOut.get("prc_mensagem"));
		
		return resultado;		
		
	}
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public StoredProcedure getProcedureCadastroAmizade() {
		return procedureCadastroAmizade;
	}

	public void setProcedureCadastroAmizade(StoredProcedure procedureCadastroAmizade) {
		this.procedureCadastroAmizade = procedureCadastroAmizade;
	}

	public StoredProcedure getProcedureUpdateEstadoAmizade() {
		return procedureUpdateEstadoAmizade;
	}

	public void setProcedureUpdateEstadoAmizade(StoredProcedure procedureUpdateEstadoAmizade) {
		this.procedureUpdateEstadoAmizade = procedureUpdateEstadoAmizade;
	}

	public StoredProcedure getProcedureDeleteAmizade() {
		return procedureDeleteAmizade;
	}

	public void setProcedureDeleteAmizade(StoredProcedure procedureDeleteAmizade) {
		this.procedureDeleteAmizade = procedureDeleteAmizade;
	}

	public StoredProcedure getProcedureBloqueioAmizade() {
		return procedureBloqueioAmizade;
	}

	public void setProcedureBloqueioAmizade(StoredProcedure procedureBloqueioAmizade) {
		this.procedureBloqueioAmizade = procedureBloqueioAmizade;
	}
	
	
	
	
	
}
