/**
 * 
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Bean.MensagemAmizade;

/**
 * @author marcos
 *
 */
public class ConversaAmizadeRowMapper implements RowMapper<MensagemAmizade> {

	@Override
	public MensagemAmizade mapRow(ResultSet rs, int arg1) throws SQLException {
		
		MensagemAmizade mensagemAmizade = new MensagemAmizade();
		
		mensagemAmizade.getMensagem().setIdMensagem(rs.getInt("id_mensagem_amizade"));
		mensagemAmizade.getMensagem().setConteudoMensagem(rs.getString("conteudo_mensagem_amizade"));
		mensagemAmizade.getMensagem().setDataMensagem(rs.getDate("dt_mensagem_amizade"));
		mensagemAmizade.getAmizade().getSolicitante().setNomeExibicao(rs.getString("nome_exibicao"));
		mensagemAmizade.getAmizade().getSolicitante().setFotoUsuario(rs.getString("foto_usuario"));
		mensagemAmizade.getAmizade().getSolicitante().setGuidUsuario(rs.getString("guid_usuario"));
	
		return mensagemAmizade;
	}
}
