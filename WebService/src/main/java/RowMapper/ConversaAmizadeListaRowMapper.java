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
public class ConversaAmizadeListaRowMapper implements RowMapper<MensagemAmizade>{

	@Override
	public MensagemAmizade mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		MensagemAmizade mensagemAmizade = new MensagemAmizade();

		mensagemAmizade.getMensagem().setIdMensagem(rs.getInt("id_mensagem_amizade"));
		mensagemAmizade.getMensagem().setConteudoMensagem(rs.getString("conteudo_mensagem_amizade"));
		mensagemAmizade.getMensagem().setDataMensagem(rs.getDate("dt_mensagem_amizade"));
		mensagemAmizade.getAmizade().setIdAmizade(rs.getInt("id_amizade_fk"));
		mensagemAmizade.getAmizade().getSolicitante().setGuidUsuario(rs.getString("guid_usuario"));
		mensagemAmizade.getAmizade().getConvidado().setGuidUsuario(rs.getString("guid_usuario_aux"));
		mensagemAmizade.getAmizade().getConvidado().setNomeExibicao(rs.getString("nome_exibicao_aux"));
		mensagemAmizade.getAmizade().getConvidado().setFotoUsuario(rs.getString("foto_usuario_aux"));

		return mensagemAmizade;
	}

}
