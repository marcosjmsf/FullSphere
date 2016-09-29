/**
 * 
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Bean.Album;

/**
 * @author marcos
 *
 */
public class AlbumPaginaRowMapper implements RowMapper<Album>{

	@Override
	public Album mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Album album = new Album();
		
		album.setAnoLancamento(rs.getString("ano_lancamento"));
		album.getArtista().setNomeArtista(rs.getString("nm_artista"));
		album.getArtista().setIdArtista(rs.getInt("id_artista_fk"));
		album.setDescricaoAlbum(rs.getString("desc_album"));
		album.setFotoAlbum(rs.getString("foto_album"));
		album.setIdAlbum(rs.getInt("id_album"));
		album.setMembrosAlbum(rs.getString("membros_album"));
		album.setNomeAlbum(rs.getString("nm_album"));
		album.setSetListAlbum(rs.getString("setList_album"));
		album.setNotaAlbum(rs.getDouble("nota_Album"));
		album.setQuantidadeNota(rs.getInt("quantidade_nota"));
		album.setNotaPropria(rs.getDouble("nota_propria"));
		

		return album;
	}
}
