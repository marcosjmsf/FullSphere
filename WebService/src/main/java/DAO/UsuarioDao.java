/**
 * 
 */
package DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

import Bean.Resultado;
import Bean.Usuario;

/**
 * @author marcos
 *
 */
public class UsuarioDao {
	
	private JdbcTemplate jdbcTemplate;
	private StoredProcedure procedureLogin;
	private StoredProcedure procedureTrocaSenha;
	private StoredProcedure procedureUpdateEmailUsuario;
	
	//Metodo para efetuar login, toda a logica da operacao esta no banco
	public Usuario login(Usuario usuario){

		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();
		
		
		parametros.put("prc_e_mail_usuario", usuario.getEmail());
		parametros.put("prc_senha_usuario", usuario.getSenha());

		parametrosOut = procedureLogin.execute(parametros);
		
		usuario = new Usuario();
		
		usuario.getResultado().setCode((String)parametrosOut.get("prc_codigo"));
		usuario.getResultado().setMensagem((String)parametrosOut.get("prc_mensagem"));
		usuario.setIdUsuario((int)parametrosOut.get("prc_id_usuario"));
		usuario.setTipoUsuario((String)parametrosOut.get("prc_tipo_usuario"));
		usuario.setEstadoPlano((String)parametrosOut.get("prc_estado_plano"));
		
		
	
		
		return usuario;
	}
	
	//Esse metodo sera utilizado para adicionar fotos ao perfil de um usuario
	public Resultado adicionarFotoUsuario(Usuario usuario){
		
		Resultado resultado = new Resultado();
		String sql = "update usuario set foto_usuario = ? where id_usuario = ?";
		
		Object [] parametros = {usuario.getImagem().getNome()+usuario.getImagem().getExtensao(),
				usuario.getIdUsuario()};
		
		int result = jdbcTemplate.update(sql, parametros);

		if(result > 0){
			
			resultado.setCode("0");
			resultado.setMensagem("Foto adicionada com sucesso");
			
		}else{
			
			resultado.setCode("-1");
			resultado.setMensagem("Erro ao adicionar foto");
			
			
		}
		
		return resultado;
	}

	//Esse metodo ira verificar se o usuario ja possui uma foto cadastrada
	public String existeFoto(Usuario usuario){
	
		
		String sql = "select foto_usuario from usuario where id_usuario = ?";
		
		Object [] parametros = {usuario.getIdUsuario()};
		
		String diretorio = jdbcTemplate.queryForObject(sql, String.class, parametros);

		return diretorio;
	}
	
	//Esse metodo sera utilizado para a troca de senha
	public Resultado trocaSenha(Usuario usuario){
		
		Resultado resultado = new Resultado();
		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();
		
		parametros.put("prc_id_usuario", usuario.getIdUsuario());
		parametros.put("prc_senha", usuario.getSenha());
		parametros.put("prc_senha_nova", usuario.getNovaSenha());

		parametrosOut = procedureTrocaSenha.execute(parametros);
				
		resultado.setCode((String)parametrosOut.get("prc_codigo"));
		resultado.setMensagem((String)parametrosOut.get("prc_mensagem"));

		return resultado;
	}
	
	//Metodo para efetuar troca de email
	public Resultado updateEmailUsuario(Usuario usuario){

		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();
		
		
		parametros.put("prc_e_mail_usuario", usuario.getEmail());
		parametros.put("prc_id_usuario", usuario.getIdUsuario());

		parametrosOut = procedureUpdateEmailUsuario.execute(parametros);
		
		Resultado resultado = new Resultado();
		
		resultado.setCode((String)parametrosOut.get("prc_codigo"));
		resultado.setMensagem((String)parametrosOut.get("prc_mensagem"));
		
		return resultado;
	}
	
	public Usuario convertIdToGuid(int idUsuario){
		
		Usuario usuario = new Usuario();
		
		String sql = "select guid_usuario from usuario where id_usuario = ?";
		
		Object [] parametros = {idUsuario};
		
		String guid = jdbcTemplate.queryForObject(sql, String.class, parametros);
		
		usuario.setGuidUsuario(guid);
		
		return usuario;
	}


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	public StoredProcedure getProcedureLogin() {
		return procedureLogin;
	}



	public void setProcedureLogin(StoredProcedure procedureLogin) {
		this.procedureLogin = procedureLogin;
	}

	public StoredProcedure getProcedureTrocaSenha() {
		return procedureTrocaSenha;
	}

	public void setProcedureTrocaSenha(StoredProcedure procedureTrocaSenha) {
		this.procedureTrocaSenha = procedureTrocaSenha;
	}

	public StoredProcedure getProcedureUpdateEmailUsuario() {
		return procedureUpdateEmailUsuario;
	}

	public void setProcedureUpdateEmailUsuario(StoredProcedure procedureUpdateEmailUsuario) {
		this.procedureUpdateEmailUsuario = procedureUpdateEmailUsuario;
	}
	
	
	
	
	

}
