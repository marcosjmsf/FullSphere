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
public class ItemListaDesejoRowMapper implements RowMapper<ItemColecao>{

	@Override
	public ItemColecao mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		ItemColecao itemColecao = new ItemColecao();
		
		itemColecao.getEdicaoAlbum().setIdEdicaoAlbum(rs.getInt("id_edicao_album_fk"));
		itemColecao.setDataAdicaoItem(rs.getDate("dt_adicao"));
		itemColecao.getEdicaoAlbum().getTipoMidia().setNomeTipoMidia(rs.getString("nm_tipo_midia"));
		itemColecao.getEdicaoAlbum().setNomeEdicaoAlbum(rs.getString("nm_edicao_album"));
		itemColecao.getEdicaoAlbum().setDataLancamentoEdicaoAlbum(rs.getDate("data_lancamento_edicao_album"));
		itemColecao.getEdicaoAlbum().setCapaEdicaoAlbum(rs.getString("capa_edicao_album"));
		itemColecao.getEdicaoAlbum().getPais().setNomePais(rs.getString("nm_pais"));
		itemColecao.getEdicaoAlbum().getPais().setBandeiraPais(rs.getString("bandeira_pais"));
		itemColecao.getEdicaoAlbum().getGravadora().setNomeGravadora(rs.getString("nm_gravadora"));
		itemColecao.getEdicaoAlbum().getAlbum().getArtista().setNomeArtista(rs.getString("nm_artista"));
		itemColecao.getEdicaoAlbum().getAlbum().setNomeAlbum(rs.getString("nm_album"));
		

		return itemColecao;
	}
	
}