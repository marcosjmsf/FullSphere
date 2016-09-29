/**
 * 
 */
package RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Bean.Artista;

/**
 * @author marcos
 *
 */
public class ArtistaFavoritoListaRowMapper implements RowMapper<Artista>{

	@Override
	public Artista mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Artista artista = new Artista();
		
		artista.setIdArtista(rs.getInt("id_artista"));
		artista.setNomeArtista(rs.getString("nm_artista"));
		artista.setDescricaoArtista(rs.getString("desc_artista"));
		artista.setFotoArtista(rs.getString("foto_artista"));
		artista.setMembrosArtista(rs.getString("membros_artista"));
		artista.getPais().setNomePais(rs.getString("nm_pais"));
		artista.getPais().setBandeiraPais(rs.getString("bandeira_pais"));

		return artista;
	}
}
