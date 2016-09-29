/**
 * 
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Bean.ComentarioArtista;

/**
 * @author marcos
 *
 */
public class ComentarioArtistaRowMapper implements RowMapper<ComentarioArtista>{

	@Override
	public ComentarioArtista mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		ComentarioArtista comentarioArtista = new ComentarioArtista();
		
		comentarioArtista.getComentario().setIdComentario(rs.getInt("id_comentario_artista"));
		comentarioArtista.getComentario().setConteudo(rs.getString("conteudo_comentario_artista"));
		comentarioArtista.getComentario().setDataComentario(rs.getDate("dt_comentario_artista"));
		comentarioArtista.getArtistaAuxiliar().getUsuario().setGuidUsuario(rs.getString("guid_usuario"));
		comentarioArtista.getArtistaAuxiliar().getUsuario().setNomeExibicao(rs.getString("nome_exibicao"));
		comentarioArtista.getArtistaAuxiliar().getUsuario().setFotoUsuario(rs.getString("foto_usuario"));
		comentarioArtista.getComentario().setFlagAutor(rs.getBoolean("flag_autor"));

		

		return comentarioArtista;
	}
}
