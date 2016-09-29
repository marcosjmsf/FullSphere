/**
 * 
 */
package DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import Bean.MensagemAmizade;
import Bean.Resultado;
import RowMapper.ConversaAmizadeListaRowMapper;
import RowMapper.ConversaAmizadeRowMapper;

/**
 * @author marcos
 *
 */
public class MensagemDao {

	private JdbcTemplate jdbcTemplate;
	
	
	public Resultado cadastroMensagemAmizade(MensagemAmizade mensagemAmizade){
		
		Resultado resultado = new Resultado();
		
		String sql = "Insert into (id_amizade_fk, conteudo_mensagem_amizade, dt_mensagem_amizade, id_usuario_fk) values(?,?,?,?)";
		
		Object [] parametros = {mensagemAmizade.getAmizade().getIdAmizade(), mensagemAmizade.getMensagem().getConteudoMensagem(), mensagemAmizade.getMensagem().getDataMensagem(),
				mensagemAmizade.getAmizade().getSolicitante().getIdUsuario()};
		
		int  result = jdbcTemplate.update(sql,parametros);

		if(result > 0){
			
			resultado.setCode("0");
			resultado.setCode("Mensagem enviada com sucesso.");
			
		}else{
			
			resultado.setCode("-1");
			resultado.setCode("Erro ao enviar mensagem.");
			
		}
		
		
		return resultado;
	}
	
	
	//Esse metodo retornara as mensagens de uma determinada conversa de forma paginada
	public List <MensagemAmizade> consultaConversaAmizade(int idAmizade){
				
		String sql = "Select me.id_mensagem_amizade, me.conteudo_mensagem_amizade, me.dt_mensagem_amizade, "
				+ " us.id_usuario, us.nome_exibicao, us.foto_usuario, us.guid_usuario "
				+ " from mensagem_amizade me, usuario us "
				+ " where me.id_amizade_fk = ? "
				+ " and me.id_usuario_fk = us.id_usuario "
				+ " order by me.dt_mensagem_amizade DESC";
		
		Object [] parametros = {idAmizade};
		
		List <MensagemAmizade> listaMensagemAmizade = jdbcTemplate.query(sql, parametros, new ConversaAmizadeRowMapper());
		
		
		return listaMensagemAmizade;
	}
	
	
	//Esse metodo sera utilizado para preencher a pagina que exibira todas as conversas de amizade de um determinado usuario
	//Sera retornado apenas uma mensagem por conversa, e tambem a guid de quem enviou aquela mensagem
	//Sera retornado tambem os dados do usuario com quem o usuario solicitante esta conversando
	public List <MensagemAmizade> consultaConversaAmizadeLista(int idUsuario){
				
		String sql = "Select   id_mensagem_amizade, conteudo_mensagem_amizade, dt_mensagem_amizade,id_amizade_fk"
				+ " guid_usuario, foto_usuario_aux, nome_exibicao_aux, guid_usuario_aux from "
				+ " (Select me.id_mensagem_amizade, me.conteudo_mensagem_amizade, me.dt_mensagem_amizade,me.id_amizade_fk,"
				+ " us.guid_usuario, "
				+ " us2.nome_exibicao as nome_exibicao_aux, us2.foto_usuario as foto_usuario_aux, us2.guid_usuario as guid_usuario_aux "
				+ " from mensagem_amizade me, usuario us, amizade am, usuario us2 "
				+ " where am.id_amizade = me.id_amizade_fk "
				+ " and (am.solcitante_fk = ? OR am.convidado_fk = ?) "
				+ " and me.id_usuario_fk = us.id_usuario "
				+ " and us2.id_usuario = (IF (am.solcitante_fk = ?,am.convidado_fk,am.solcitante_fk)) "
				+ " and am.id_estado_amizade_fk <> 3 "
				+ " order by me.dt_mensagem_amizade DESC limit 100) "
				+ " AS teste "
				+ " group by id_amizade_fk "
				+ " order by dt_mensagem_amizade desc ";
		
		Object [] parametros = {idUsuario,idUsuario,idUsuario};
		
		List <MensagemAmizade> listaMensagemAmizade = jdbcTemplate.query(sql, parametros, new ConversaAmizadeListaRowMapper());
		
		
		return listaMensagemAmizade;
	}
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	
	
}
