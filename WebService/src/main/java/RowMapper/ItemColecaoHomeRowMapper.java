/**
 * 
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Bean.ItemColecao;

/**
 * @author marcos
 *
 */
public class ItemColecaoHomeRowMapper implements RowMapper<ItemColecao>{

	@Override
	public ItemColecao mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		ItemColecao itemColecao = new ItemColecao();
		
		itemColecao.getEdicaoAlbum().setIdEdicaoAlbum(rs.getInt("id_edicao_album"));
		itemColecao.getEdicaoAlbum().getTipoMidia().setNomeTipoMidia(rs.getString("nm_tipo_midia"));
		itemColecao.getEdicaoAlbum().setNomeEdicaoAlbum(rs.getString("nm_edicao_album"));
		itemColecao.getEdicaoAlbum().setCapaEdicaoAlbum(rs.getString("capa_edicao_album"));		
		itemColecao.getEdicaoAlbum().getAlbum().setNomeAlbum(rs.getString("nm_album"));
		itemColecao.getEdicaoAlbum().getAlbum().getArtista().setNomeArtista(rs.getString("nm_artista"));
		return itemColecao;
	}
}
