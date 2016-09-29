/**
 * 
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Bean.ComentarioAlbum;

/**
 * @author marcos
 *
 */
public class ComentarioAlbumRowMapper implements RowMapper<ComentarioAlbum>{

	@Override
	public ComentarioAlbum mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		ComentarioAlbum comentarioAlbum = new ComentarioAlbum();
		
		comentarioAlbum.getComentario().setIdComentario(rs.getInt("id_comentario_album"));
		comentarioAlbum.getComentario().setConteudo(rs.getString("conteudo_comentario_album"));
		comentarioAlbum.getComentario().setDataComentario(rs.getDate("dt_comentario_album"));
		comentarioAlbum.getAlbumAuxiliar().getUsuario().setGuidUsuario(rs.getString("guid_usuario"));
		comentarioAlbum.getAlbumAuxiliar().getUsuario().setNomeExibicao(rs.getString("nome_exibicao"));
		comentarioAlbum.getAlbumAuxiliar().getUsuario().setFotoUsuario(rs.getString("foto_usuario"));
		comentarioAlbum.getComentario().setFlagAutor(rs.getBoolean("flag_autor"));
		

		return comentarioAlbum;
	}
}
