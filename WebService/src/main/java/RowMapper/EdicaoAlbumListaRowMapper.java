/**
 * 
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Bean.EdicaoAlbum;

/**
 * @author marcos
 *
 */
public class EdicaoAlbumListaRowMapper implements RowMapper<EdicaoAlbum>{

	@Override
	public EdicaoAlbum mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		EdicaoAlbum edicaoAlbum = new EdicaoAlbum();
		
		edicaoAlbum.setIdEdicaoAlbum(rs.getInt("id_edicao_album"));
		edicaoAlbum.setDataLancamentoEdicaoAlbum(rs.getDate("data_lancamento_edicao_album"));
		edicaoAlbum.setNomeEdicaoAlbum(rs.getString("nm_edicao_album"));
		edicaoAlbum.setCapaEdicaoAlbum(rs.getString("capa_edicao_album"));
		edicaoAlbum.getPais().setNomePais(rs.getString("nm_pais"));
		edicaoAlbum.getPais().setBandeiraPais(rs.getString("bandeira_pais"));
		edicaoAlbum.getGravadora().setNomeGravadora(rs.getString("nm_gravadora"));
		edicaoAlbum.getTipoMidia().setNomeTipoMidia(rs.getString("nm_tipo_midia"));
		

		return edicaoAlbum;
	}
}
