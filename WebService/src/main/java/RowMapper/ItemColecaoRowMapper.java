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
public class ItemColecaoRowMapper implements RowMapper<ItemColecao>{

	@Override
	public ItemColecao mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		ItemColecao itemColecao = new ItemColecao();
		
		itemColecao.setIdItemColecao(rs.getInt("id_item_colecao"));
		itemColecao.setObservacaoItem(rs.getString("obs_item"));
		itemColecao.setQuantidadeItem(rs.getInt("quantidade_item"));
		itemColecao.setEstadoCaixa(rs.getInt("estado_item_caixa"));
		itemColecao.setEstadoMidia(rs.getInt("estado_item_midia"));
		itemColecao.setEstadoEncarte(rs.getInt("estado_item_encarte"));
		itemColecao.getEstimaItem().setIdEstimaItem(rs.getInt("id_estima_item"));
		itemColecao.getEstimaItem().setDescricaoEstimaItem(rs.getString("desc_estima_item"));
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
