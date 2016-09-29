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
public class AlbumDiscografiaArtistaRowMapper implements RowMapper<Album>{

	@Override
	public Album mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Album album = new Album();
		
		album.setAnoLancamento(rs.getString("ano_lancamento"));
		album.setFotoAlbum(rs.getString("foto_album"));
		album.setIdAlbum(rs.getInt("id_album"));
		album.setNomeAlbum(rs.getString("nm_album"));
		album.setNotaAlbum(rs.getDouble("nota_Album"));
		album.setQuantidadeNota(rs.getInt("quantidade_nota"));
		

		return album;
	}
}