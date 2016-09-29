/**
 * 
 */
package DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

import Bean.ComentarioAlbum;
import Bean.ComentarioArtista;
import Bean.Pesquisa;
import Bean.Resultado;
import RowMapper.ComentarioAlbumRowMapper;
import RowMapper.ComentarioArtistaRowMapper;

/**
 * @author marcos
 *
 */
public class ComentarioDao {
	
	private JdbcTemplate jdbcTemplate ;
	private StoredProcedure procedureCadastroComentarioArtista;
	private StoredProcedure procedureCadastroComentarioAlbum;

	
	
	public ComentarioArtista cadastroComentarioArtista (ComentarioArtista comentarioArtista){

		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();
		ComentarioArtista resposta = new ComentarioArtista();
		
		parametros.put("prc_conteudo_comentario_artista", comentarioArtista.getComentario().getConteudo());
		parametros.put("prc_id_artista_fk", comentarioArtista.getArtistaAuxiliar().getArtista().getIdArtista());
		parametros.put("prc_id_usuario_pf_fk", comentarioArtista.getArtistaAuxiliar().getUsuario().getIdUsuario());

		parametrosOut = procedureCadastroComentarioArtista.execute(parametros);
		
		resposta.getComentario().setIdComentario((int)parametrosOut.get("prc_id_comentario"));


		return resposta;

	}

	
	public ComentarioAlbum cadastroComentarioAlbum (ComentarioAlbum comentarioAlbum){

		Map<String, Object> parametros = new HashMap<String, Object>();
		Map<String, Object> parametrosOut = new HashMap<String, Object>();
		ComentarioAlbum resposta = new ComentarioAlbum();
		
		parametros.put("prc_conteudo_comentario_album", comentarioAlbum.getComentario().getConteudo());
		parametros.put("prc_id_album_fk", comentarioAlbum.getAlbumAuxiliar().getAlbum().getIdAlbum());
		parametros.put("prc_id_usuario_pf_pk", comentarioAlbum.getAlbumAuxiliar().getUsuario().getIdUsuario());

		parametrosOut = procedureCadastroComentarioAlbum.execute(parametros);
		
		resposta.getComentario().setIdComentario((int)parametrosOut.get("prc_id_comentario"));


		return resposta;

	}

	
	public Resultado deleteComentarioAlbum (ComentarioAlbum comentarioAlbum){

		Resultado resultado = new Resultado();

		String sql = "delete from comentario_album where id_comentario_album = ?";

		Object [] parametros = {comentarioAlbum.getComentario().getIdComentario()};

		int result = jdbcTemplate.update(sql, parametros);

		if(result >0){

			resultado.setCode("0");
			resultado.setMensagem("Comentario deletado com sucesso");
			
		}else{

			resultado.setCode("-1");
			resultado.setMensagem("Erro ao deletar comentario");

		}

		return resultado;

	}
	
	
	public Resultado deleteComentarioArtista (ComentarioArtista comentarioArtista){

		Resultado resultado = new Resultado();

		String sql = "delete from comentario_artista where id_comentario_artista = ?";

		Object [] parametros = {comentarioArtista.getComentario().getIdComentario()};

		int result = jdbcTemplate.update(sql, parametros);

		if(result >0){

			resultado.setCode("0");
			resultado.setMensagem("Comentario deletado com sucesso");
			
		}else{

			resultado.setCode("-1");
			resultado.setMensagem("Erro ao deletar comentario");

		}

		return resultado;

	}
	
	public List<ComentarioArtista> consultaListaComentarioArtista (Pesquisa pesquisa){

		int limiteFinal = pesquisa.getNumeroPagina() * 10;
		int limiteInicial = limiteFinal - 10;
		

		String sql = "select ca.id_comentario_artista, ca.conteudo_comentario_artista, ca.dt_comentario_artista, "
				+ " us.guid_usuario, us.nome_exibicao, us.foto_usuario, "
				+ "	(Select IF(COUNT(*), true, false) tag from Comentario_Artista where id_usuario_pf_fk = ? and id_comentario_artista = ca.id_comentario_artista )as flag_autor "
				+ " from Comentario_Artista ca, Usuario us "
				+ " where ca.id_artista_fk = ?"
				+ " and us.id_usuario = ca.id_usuario_pf_fk "
				+ " ORDER BY  dt_comentario_artista DESC"
				+ " limit ?,?";

		Object [] parametros = {pesquisa.getIdUsuario(),pesquisa.getIdPesquisa(),limiteInicial,limiteFinal};

		List<ComentarioArtista> listComentarioArtista = jdbcTemplate.query(sql, parametros, new ComentarioArtistaRowMapper());

		return listComentarioArtista;

	}
	
	public List<ComentarioAlbum> consultaListaComentarioAlbum (Pesquisa pesquisa){

		int limiteFinal = pesquisa.getNumeroPagina() * 10;
		int limiteInicial = limiteFinal - 10;
		
		
		String sql = "select ca.id_comentario_album, ca.conteudo_comentario_album, ca.dt_comentario_album,"
				+ " us.guid_usuario, us.nome_exibicao, us.foto_usuario, "
				+ "	(Select IF(COUNT(*), true, false) tag from Comentario_Album where id_usuario_pf_pk = ? and id_comentario_album =ca.id_comentario_album )as flag_autor "
				+ " from Comentario_Album ca, Usuario us"
				+ " where ca.id_album_fk = ?"
				+ " and us.id_usuario = ca.id_usuario_pf_pk "
				+ " ORDER BY  dt_comentario_album DESC"
				+ " limit ?,?";

		Object [] parametros = {pesquisa.getIdUsuario(),pesquisa.getIdPesquisa(),limiteInicial,limiteFinal};

		List<ComentarioAlbum> listComentarioAlbum = jdbcTemplate.query(sql, parametros, new ComentarioAlbumRowMapper());

		return listComentarioAlbum;

	}
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public StoredProcedure getProcedureCadastroComentarioArtista() {
		return procedureCadastroComentarioArtista;
	}


	public void setProcedureCadastroComentarioArtista(StoredProcedure procedureCadastroComentarioArtista) {
		this.procedureCadastroComentarioArtista = procedureCadastroComentarioArtista;
	}


	public StoredProcedure getProcedureCadastroComentarioAlbum() {
		return procedureCadastroComentarioAlbum;
	}


	public void setProcedureCadastroComentarioAlbum(StoredProcedure procedureCadastroComentarioAlbum) {
		this.procedureCadastroComentarioAlbum = procedureCadastroComentarioAlbum;
	}
	
	
	

}
